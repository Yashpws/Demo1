package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import CommonObjects.CommonMethods;

public class pom_Search {
	static WebElement element = null;

	/*
	 * public static By search_box= By.xpath(".//*[@id='twotabsearchtextbox']");
	 * 
	 * public static By go_btn=
	 * By.xpath(".//*[@id='nav-search']/form/div[2]/div/input");
	 * 
	 * public static By item_name= By.
	 * xpath(".//*[@id='result_0']//*[contains((@data-attribute),'Cage (Red Queen 3)')]"
	 * );
	 */

	public static WebElement search_box(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 1) { try {
		 */ {
			try {

				if (CommonMethods.waitForElement(driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")),
						driver) != null)

				{
					element = CommonMethods
							.waitForElement(driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")), driver);
					/*
					 * break; } catch (StaleElementReferenceException e) { }
					 * attempts++; }
					 */} else {
					throw new SkipException("Skipping this exception");
				}
			} catch (Exception e) {
				throw new SkipException("Skipping this exception");

			}
		}
		return element;

	}

	public static WebElement go_btn(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 1) { try {
		 * 
		 */
		try {

			if (CommonMethods.waitForElement(
					driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")), driver) != null)

			{
				element = CommonMethods.waitForElement(
						driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input")), driver);
				/*
				 * break; } catch (StaleElementReferenceException e) { }
				 * attempts++; }
				 */
			} else

			{
				throw new SkipException("Skipping this exception");
			}
		} catch (Exception e) {
			throw new SkipException("Skipping this exception");

		}
		return element;
	}

	public static WebElement item_name(WebDriver driver, String locater) {
		/*
		 * int attempts = 0; while (attempts < 1) { try {*/
		try {

				if (CommonMethods.waitForElement(driver.findElement(By.xpath(locater)), driver) != null)

				{
 
		element = CommonMethods.waitForElement(driver.findElement(By.xpath(locater)), driver);
		/*
		 * break; } catch (StaleElementReferenceException e) { } attempts++; }
		 * 
		 */} else

			{
				throw new SkipException("Skipping this exception");
			}
		} catch (Exception e) {
			throw new SkipException("Skipping this exception");

		}
		return element;

	}

}
