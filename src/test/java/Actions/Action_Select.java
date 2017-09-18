package Actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.host.Set;

import pom.pom_Select;

public class Action_Select {

	static String ProductName;
	static String Price;
	static String ProductDescription;
	static String ProductOffer;
	static String Productrelated;
	static ArrayList<String> tabs2;
	static int i = 1;
	public static String MainWindow;
	static java.util.Set<String> s1;
	static Iterator<String> i1;

	// static WebElement Buy_Btn;

	public static String getProductName(WebDriver driver, String Search_p) {
		
		//MainWindow = driver.getWindowHandle();
		 String winHandle="";
		// To handle all new opened window.
		s1 = driver.getWindowHandles();
		String firstWinHandle = driver.getWindowHandle();
		s1.remove(firstWinHandle);
		try{
			winHandle=s1.iterator().next();
		} catch(Exception e)
		{
			e.getSuppressed();
		}
		 if (winHandle!=firstWinHandle){
			String secondWinHandle=winHandle;
			 driver.switchTo().window(secondWinHandle);
		 }
		 
	/*	 
		i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			
			if(ChildWindow.toString().contains("Online Shopping")){
				driver.close();
			}

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				
				

				// Switching to Child window
				driver.switchTo().window(ChildWindow);*/
                try{
				ProductName = pom_Select.product_title(driver).getText().toString().trim();
                }
                catch(Exception e){
                	e.getMessage();
                	String originalHandle = driver.getWindowHandle();

            	    //Do something to open new tabs

            	    for(String handle : driver.getWindowHandles()) {
            	        if (!handle.equals(originalHandle)) {
            	            driver.switchTo().window(handle);
            	            driver.close();
            	        }
            	    }

            	    driver.switchTo().window(originalHandle);
                	
                }
				System.out.println(ProductName);
			
			
		
		// Switching to Parent window i.e Main Window.
		//driver.switchTo().window(MainWindow);
		// tabs2 = new ArrayList<String>(driver.getWindowHandles());
		// driver.switchTo().window(tabs2.get(1));

		return ProductName;

	}

	public static String getPrice(WebDriver driver) {
		Price = pom_Select.product_price(driver).getText().toString().trim();
		System.out.println(Price);
		return Price;
	}

	public static String getProductDescription(WebDriver driver) {
		ProductDescription = pom_Select.product_desc(driver).getText().toString().trim();
		System.out.println(ProductDescription);
		return ProductDescription;

	}

	public static String getProductOffers(WebDriver driver) {
		ProductOffer = pom_Select.product_offer(driver).getText().toString().trim();
		System.out.println(ProductOffer);
		return ProductOffer;
	}

	public static String getProductRelated(WebDriver driver) {
		Productrelated = pom_Select.product_related(driver).getText().toString().trim();
		System.out.println(Productrelated);
		return Productrelated;

	}

	public static void Buynow_btn(WebDriver driver) {
		pom_Select.buy_btn(driver).click();

	}
}
