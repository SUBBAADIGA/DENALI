package pages;

import com.microsoft.playwright.Page;

public class RegisterPage {
	
	
	private final Page page;
	
	public RegisterPage(Page page) {
        this.page=page;
	}
	
	String FirstNamelabel="input#input-firstname";
	String Lastnamelabel="input#input-lastname";
	String EmailLabel="input#input-email"; 
	String TelephoneLabel="input#input-telephone"; 
	String PassWordLabel="input#input-password"; 
	String ConfPassWordLabel="input#input-confirm"; 
	String AgreeTermsLabel="input[name='agree']";
	String ContinueLabel="input[value='Continue']";
	
	String AccountCreatedLabel="//h1[text()='Your Account Has Been Created!']";
	

	   
	   public void EnterFirstName(String Firstname)
	   {
		   page.locator(FirstNamelabel).fill(Firstname);
	   }
	   
	   public void EnterLastname(String LastName)
	   {
		   page.locator(Lastnamelabel).fill(LastName);
	   }
	   
	   public void EnterEmail(String Email)
	   {
		   page.locator(EmailLabel).fill(Email);
	   }
	   
	   public void EnterTelephone(String number)
	   {
		   page.locator(TelephoneLabel).fill(number);
	   }
	   
	   public void EnterPassword(String pwd)
	   {
		   page.locator(PassWordLabel).fill(pwd);
	   }
	   
	   public void EntercnfPWD(String pwd)
	   {
		   page.locator(ConfPassWordLabel).fill(pwd);
	   }
	   
	   public void AgreeTerms()
	   {
		   page.locator(AgreeTermsLabel).click();
	   }
	   
	   public void ClickContinue()
	   {
		   page.locator(ContinueLabel).click();
	   }
	   
	   public void RegisterAccount(String fname,String LastName,String Email,String Telephone,String PWD)
	   {
		   EnterFirstName(fname);
		   EnterLastname(LastName);
		   EnterEmail(Email);
		   EnterTelephone(Telephone);
		   EnterPassword(PWD);
		   EntercnfPWD(PWD);
		   AgreeTerms();
		   ClickContinue();
	   }
	   
	   public Boolean VerifyAccountCreation()
	   {
		   return page.waitForSelector(AccountCreatedLabel).isVisible();
	   }

}
