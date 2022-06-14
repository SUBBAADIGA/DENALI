package pages;

import java.util.HashMap;

import com.microsoft.playwright.Page;

public class ProductPage {
	
	
	private final Page page;
	
	public ProductPage(Page page) {
        this.page=page;
	}
	
	String MacBookPrice="p.price:below(:text('MacBook'))";
	String IphonePrice="p.price:below(:text('MacBook'))";
	String AppleCinema="p.price:below(:text('Apple Cinema 30\"'))";
	String Canon="p.price:below(:text('Canon EOS 5D'))";
	String addtoCart="//span[text()='Add to Cart']";
	String Cartoption="span#cart-total";
	String checkout="//strong[text()=' Checkout']";


	
	 HashMap<String, String> ProductLists=new HashMap<String, String>();
	 

	 
	 public void AddtoCart(int i)
	 {
		page.locator(addtoCart).nth(-1+i).click();
		
		
	 }
	 
	 public HashMap<String, String> StorePrice()
	 {
		 ProductLists.put("MacBook",page.locator(MacBookPrice).first().textContent());
		 ProductLists.put("Iphone",page.locator(IphonePrice).first().textContent());
		 ProductLists.put("AppleCinema",page.locator(AppleCinema).first().textContent());
		 ProductLists.put("Canon",page.locator(Canon).first().textContent());
		 
		 return ProductLists;
	 }
	
	 
	 public void ClickCheckout()
	 {
		 page.locator(Cartoption).first().click();
		 page.locator(checkout).first().click();
	 }
	
	


}
