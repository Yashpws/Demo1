package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import CommonObjects.CommonMethods;

public class pom_Select {
	private static WebElement element = null;

	public static WebElement product_title(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 2) { try {
		 */try {
				if (CommonMethods.waitForElement(
						driver.findElement(By.xpath(".//*[@id='productTitle']")), driver) != null)

				{
		element = CommonMethods.waitForElement(driver.findElement(By.xpath(".//*[@id='productTitle']")), driver);
		/*
		 * break; } catch (StaleElementReferenceException e) { } attempts++; }
		 */} else

			{
				throw new SkipException("Skipping this exception");
			}
		} catch (Exception e) {
			throw new SkipException("Skipping this exception");

		}
		return element;

	}

	public static WebElement product_price(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 2) { try {
		 */
		element = CommonMethods.waitForElement(
				driver.findElement(By
						.xpath(".//*[@id='soldByThirdParty']//*[@class='a-size-medium a-color-price inlineBlock-display offer-price a-text-normal price3P']")),
				driver);
		/*
		 * break; } catch (
		 * 
		 * StaleElementReferenceException e) { } attempts++; }
		 */
		return element;

	}

	public static WebElement product_desc(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 2) { try {
		 */
		element = CommonMethods
				.waitForElement(driver.findElement(By.xpath(".//*[@id='productDescription_feature_div']")), driver);
		/*
		 * break; } catch (
		 * 
		 * StaleElementReferenceException e) { } attempts++; }
		 */
		return element;

	}

	public static WebElement product_desc_link(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 2) { try {
		 */
		element = CommonMethods.waitForElement(driver.findElement(By.xpath(".//*[@id='productDescription']/a")),
				driver);
		/*
		 * break; } catch (
		 * 
		 * StaleElementReferenceException e) { } attempts++; }
		 */
		return element;

	}

	public static WebElement product_offer(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 2) { try {
		 */
		element = CommonMethods.waitForElement(driver.findElement(By.xpath("//span[contains(.,'+ FREE Delivery ')]")),
				driver);
		/*
		 * break; } catch (
		 * 
		 * StaleElementReferenceException e) { } attempts++; }
		 */
		return element;

	}

	public static WebElement product_related(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 2) { try {
		 */
		element = CommonMethods.waitForElement(driver.findElement(By.xpath(".//*[@id='merchant-info']")), driver);
		/*
		 * break; } catch (StaleElementReferenceException e) { } attempts++; }
		 */
		return element;

	}

	public static WebElement buy_btn(WebDriver driver) {
		/*
		 * int attempts = 0; while (attempts < 1) { try {
		 */try {
			if (CommonMethods.waitForElement(
					driver.findElement(By.xpath(".//*[@id='buy-now-button' or @id='checkout-button']")), driver) != null)

			{
				element = CommonMethods.waitForElement(
						driver.findElement(By.xpath(".//*[@id='buy-now-button' or @id='checkout-button']")), driver);
				/*
				 * break; } catch (StaleElementReferenceException e) { }
				 * attempts++; }
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
