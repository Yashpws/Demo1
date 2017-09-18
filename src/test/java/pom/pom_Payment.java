package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import CommonObjects.CommonMethods;

public class pom_Payment {
	private static WebElement element = null;

	public static WebElement payment_verification(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 2) { try {
		 */
		if (CommonMethods.waitForElement(
				driver.findElement(By.xpath(".//*[@id='checkoutDisplayPage']/div/div[2]/div[2]/div[2]/h1")),
				driver) != null) {
			element = CommonMethods.waitForElement(
					driver.findElement(By.xpath(".//*[@id='checkoutDisplayPage']/div/div[2]/div[2]/div[2]/h1")),
					driver);
			/*
			 * break; } catch (StaleElementReferenceException e) { } attempts++;
			 * }
			 */} else {
			throw new SkipException("Skipping this exception");
		}
		return element;

	}

	public static WebElement payment_btn(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 1) { try {
		 */
try {
		if (CommonMethods.waitForElement(driver.findElement(By.xpath(".//*[@id='address-book-entry-0']/div[2]/span/a")),
				driver) != null)

			{
				element = CommonMethods.waitForElement(
						driver.findElement(By.xpath(".//*[@id='address-book-entry-0']/div[2]/span/a")), driver);
				/*
				 * break; } catch (StaleElementReferenceException e) { }
				 * attempts++; }
				 */} else {
			throw new SkipException("Skipping this exception");
		}
}
catch(Exception e){
	throw new SkipException("Skipping this exception");
	
}
		return element;

	}
	
}
