package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pom.pom_Payment;

public class Action_Payment {
	static WebElement payment_page;
	static String payment_text;


	public static String verify_checkout(WebDriver driver) {

		payment_page = pom_Payment.payment_verification(driver);
		payment_text=payment_page.getText().toString().trim();
		return payment_text;
	}
	
	public static void payment_btn_click(WebDriver driver) {
	
		pom_Payment.payment_btn(driver).click();
		
	
	
	}

}
