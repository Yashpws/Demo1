package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonObjects.CommonMethods;

public class pom_Address {
	private static WebElement element = null;
	private static List<WebElement> element1 = null;

	public static WebElement deliver_btn(WebDriver driver) {
		/*int attempts = 0;
		while (attempts < 2) {
			try {*/
				element = CommonMethods.waitForElement(
						driver.findElement(
								By.xpath(".//*[@id='address-book-entry-0']//*[@class='a-declarative a-button-text']")),
						driver);
			/*	break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}*/
		return element;

	}

	public static List<WebElement> Delivery_details(WebDriver driver) {
		/*int attempts = 0;
		while (attempts < 2) {
			try {*/
				element1 = CommonMethods.waitForElements(driver.findElements(
						By.xpath(".//*[@id='address-book-entry-0']//*[@class='displayAddressUL']/li")), driver);

			/*	break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;

		}*/

		return element1;

	}
}
