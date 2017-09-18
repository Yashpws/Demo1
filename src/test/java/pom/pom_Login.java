package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonObjects.CommonMethods;

public class pom_Login {
	
	private static WebElement element = null;

	public static By username = By.xpath(".//*[@id='ap_email']");

	public static By password = By.xpath(".//*[@id='ap_password']");

	public static By login_btn = By.xpath(".//*[@id='signInSubmit']");
	
	public static By login_next_page = By.xpath(".//*[@id='address-book-entry-0']//*[@class='displayAddressLI displayAddressFullName']/b");
	

	public static WebElement signin_l(WebDriver driver) {
	/*	int attempts = 0;
		while (attempts < 1) {
			try {*/
		element = CommonMethods.waitForElement(driver.findElement(By.xpath(".//*[@name='email']")), driver);
	/*	break;
	} catch (StaleElementReferenceException e) {
	}
	attempts++;
}*/
		return element;

	}

	public static WebElement signin_lp(WebDriver driver) {
	/*	int attempts = 0;
		while (attempts < 1) {
			try {*/
		element = CommonMethods.waitForElement(driver.findElement(By.xpath(".//*[@name='password']")), driver);
	/*	break;
	} catch (StaleElementReferenceException e) {
	}
	attempts++;
}*/
		return element;

	}
	
	public static WebElement signin_btn(WebDriver driver) {
	/*	int attempts = 0;
		while (attempts < 1) {
			try {*/
		element = CommonMethods.waitForElement(driver.findElement(By.xpath(".//*[@id='signInSubmit']")), driver);
	/*	break;
	} catch (StaleElementReferenceException e) {
	}
	attempts++;
}*/
		return element;

	}

	public static WebElement signin_next_page(WebDriver driver) {
	/*	int attempts = 0;
		while (attempts < 1) {
			try {*/
		element = CommonMethods.waitForElement(driver.findElement(By.xpath(".//*[@id='address-book-entry-0']//*[@class='displayAddressLI displayAddressFullName']/b")), driver);
	/*	break;
	} catch (StaleElementReferenceException e) {
	}
	attempts++;
}*/
		return element;

	}
}
