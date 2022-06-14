package tests;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTestClass;
import pages.CartLoginPage;
import pages.CheckotPage;
import pages.ProductPage;
import pages.RegisterPage;

public class RegisterCartTest extends BaseTestClass {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    LocalDateTime now = LocalDateTime.now();
    public String name=dtf.format(now);

    @BeforeMethod
    @Parameters({ "url", "browserName" , "headless"})
    public void browserStart(@Optional("https://naveenautomationlabs.com/opencart/") String url,
                                  @Optional("chrome") String browserName, @Optional("false") String headless) {
        launchPlaywright(browserName, headless);
        launchApplication(url);
    }

    @Test(priority = 1)
    @Parameters({ "Fname", "LName","Email","Telephone","PWD" })
    public void CreateAccountTest(@Optional("SAADIGA23") String Fname, @Optional("Auto") String LName,@Optional("sadiga2w3@gmail.com") String Email,@Optional("987873678") String Telephone,@Optional("Test@123") String PWD) {
       
    	loginPage.ClickRegisterLabel();
        registerpage.RegisterAccount(Fname+name,LName,name+Email,Telephone,PWD);
        Assert.assertTrue(registerpage.VerifyAccountCreation());
        loginPage.Logout();

    }
    
    @Test(priority = 2)
    @Parameters({ "Email", "PWD"})
    public void AddProductToCart(@Optional("sadiga2w3@gmail.com") String Email,@Optional("Test@123") String PWD) throws InterruptedException {

        loginPage.LogintoApp(name+Email, PWD);
        productPage.AddtoCart(1);
        productPage.AddtoCart(2);
        productPage.ClickCheckout();     
        checkotPage.ConfigureBillingDetails();
        loginPage.Logout();
        
        
    }

    @AfterMethod
    public void browserClose() {
        closePlaywright();
    }
}