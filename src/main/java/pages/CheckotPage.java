package pages;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckotPage {
	
	
	private final Page page;
	
	public CheckotPage(Page page) {
        this.page=page;
	}
	
	String Registercheckbox="//input[@value='register']";
	String ContinueButton="input#button-account";
	String Firstname="input#input-payment-firstname";
	String LastName="input#input-payment-lastname";
	String Address1="input#input-payment-address-1";
	String City="input#input-payment-city";
	String PostCode="input#input-payment-postcode";
	String Country="select#input-payment-country";
	String Region="select#input-payment-zone";
	String ContinueBilling="input#button-payment-address";
	String Continueshipping="input#button-shipping-address";
	String comment="textarea[name='comment']";
	String Terms="input[name='agree']";
	String ContinueShippingmethod="input#button-shipping-method";
	String ContinuePayment="input#button-payment-method";
	String confirmorder="input#button-confirm";
	String OrderSuccss="//h1[text()='Your order has been placed!']";
	


	public void CongigureCheckoutOPtion()
	{
		page.locator(Registercheckbox).click();
		page.locator(Registercheckbox).click();
	}
	
	public void ConfigureBillingDetails() throws InterruptedException
	{
		page.locator(Firstname).first().fill("subrahmanya");
		page.locator(LastName).first().fill("Adiga");
		page.locator(Address1).first().fill("Dharmasthala");
		page.locator(City).first().fill("Blore");
		page.locator(PostCode).first().fill("574216");
		
		page.locator(Country).selectOption("99");
		
		page.locator(Region).selectOption("1489");
		       
        page.locator(ContinueBilling).first().click();
        
        page.locator(Continueshipping).first().click();
        
        page.locator(comment).first().fill("Please take care");
        
        page.locator(ContinueShippingmethod).first().click();
        
        page.locator(Terms).click();
        page.locator(ContinuePayment).click();
        
        page.locator(confirmorder).first().click();
        
        boolean result = page.waitForSelector(OrderSuccss).isVisible();
        
        Assert.assertTrue(result);

	}
	
	

}
