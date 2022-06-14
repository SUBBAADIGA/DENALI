package pages;

import com.microsoft.playwright.Page;

public class CartLoginPage {
	
	
	private final Page page;
	
	public CartLoginPage(Page page) {
        this.page=page;
	}
	
	
	String MyAccountLabel="a[title='My Account']";
	String RegisterLabel="//a[text()='Register']";
	String LoginLabel="//a[text()='Login']"; 
	String LogoutLabel="//a[text()='Logout']";
	String LogoutSuccssMsg="//h1[text()='Account Logout']";
	String Emaillabel="input#input-email";
	String PassWordLabel="input#input-password";
	String LoginButtonLabel="input[value='Login']";
	String MyaccountPostLogin="//h2[text()='My Account']";
	String Homepageicon="img[title='naveenopencart']";

	
	public void ClickRegisterLabel()
	{
		page.click(MyAccountLabel);
		page.click(RegisterLabel);
	}
	
	public boolean Logout()
	{
		page.click(MyAccountLabel);
		page.click(LogoutLabel);
		 return page.waitForSelector(LogoutSuccssMsg).isVisible();
	}
	
	public void LogintoApp(String EmailID,String PWD)
	{
		page.click(MyAccountLabel);
		page.click(LoginLabel);
		page.waitForSelector(Emaillabel).fill(EmailID);
		page.fill(PassWordLabel, PWD);
		page.click(LoginButtonLabel);
		page.waitForSelector(MyaccountPostLogin).isVisible();
		page.click(Homepageicon);
	}


}
