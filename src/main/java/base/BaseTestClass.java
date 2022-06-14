package base;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitUntilState;

import pages.CartLoginPage;
import pages.CheckotPage;
import pages.ProductPage;
import pages.RegisterPage;


public class BaseTestClass {

    Playwright playwright;
    BrowserType browserType;
    Browser browser;
    BrowserContext context;
    protected Page page;
    
    public CartLoginPage loginPage;
    public RegisterPage registerpage;
    public ProductPage  productPage;
    public CheckotPage  checkotPage;
    

    public void launchPlaywright(String browserName, String headless) {
        playwright = Playwright.create();
        if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("msedge")
                || browserName.equalsIgnoreCase("chromium")) {
            browserType = playwright.chromium();
        } else if (browserName.equalsIgnoreCase("webkit")) {
            browserType = playwright.webkit();
        }
        if (headless.equalsIgnoreCase("true")) {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(true));
        } else {
            browser = browserType.launch(new BrowserType.LaunchOptions().setChannel(browserName).setHeadless(false));
        }
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1400, 700));
        context.close();
        page = browser.newPage();
        System.out.println("**** Project Browser Name and Version is : " + browserName + " : " + browser.version());
        loginPage = new CartLoginPage(page);
        registerpage=new RegisterPage(page);
        checkotPage=new CheckotPage(page);
        productPage=new ProductPage(page);
    }

    public void launchApplication(String url) {
        page.navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
        page.waitForSelector("img[title='naveenopencart']");
    }

    public void closePlaywright() {
        page.close();
        browser.close();
        playwright.close();
    }

}