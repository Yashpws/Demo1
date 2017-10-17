package TestCases; //Add Dataprovider wherever possible.

import org.testng.annotations.Test;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.collect.FluentIterable;

import org.testng.AssertJUnit;
import org.testng.ITestContext;
import org.testng.SkipException;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Actions.Action_Address;
import Actions.Action_Login;
import Actions.Action_Payment;
import Actions.Action_Search;
import Actions.Action_Select;
import CommonObjects.Report;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pom.pom_Search;

//@Listeners(Reporter.JyperionListener.class)
@Listeners(Reporter.TestNGCustomReportListener.class)
public class TestCase_Booking_smoke {

	public static WebDriver driver;
	static Action_Login booking;
	static String browser;
	static String driversyntax;
	static String path;
	static String url = "http://www.amazon.in/";
	static WebElement product;
	static String searchresult;
	static boolean search;
	static boolean select;
	static String productName;
	static int i;

	// static String locater;
	// browser, driver and driver path selection
	// --------------------------------------------------------------------------------------------------

	@BeforeClass
	public void bc(ITestContext context) {
		context.getCurrentXmlTest().getParameter(browser);
		Report.Report_Details_Header();
	}

	@BeforeTest
	@Parameters({"browser","driversyntax", "path"})
	public WebDriver setup(@Optional("firefox") String browser, @Optional("webdriver.gecko.driver") String driversyntax,
			@Optional("G:\\Vikas- Shailesh - demo Framework\\Drivers\\geckodriver-v0.17.0-win64\\geckodriver.exe") String path)
			throws Exception {
		 this.browser = browser;

		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			/*
			 * FirefoxOptions options = new FirefoxOptions(); options.
			 * setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"
			 * ); //Location where Firefox is installed
			 * 
			 * DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			 * capabilities.setCapability("marionette", true);
			 * capabilities.setPlatform(Platform.WINDOWS);
			 * capabilities.setCapability(CapabilityType.PROXY, 7055);
			 * capabilities.setCapability("moz:firefoxOptions",options);
			 */
			// set more capabilities as per your requirements

			System.setProperty(driversyntax, path);
			driver = new FirefoxDriver();

		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty(driversyntax, path);
			// create chrome instance
			driver = new ChromeDriver();
		}
		// Check if parameter passed as 'Edge'
		else if (browser.equalsIgnoreCase("ie")) {
			// set path to Edge.exe
			System.setProperty(driversyntax, path);
			// create Edge instance
			driver = new InternetExplorerDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	/*
	 * @BeforeTest public void reportgeneration() throws InterruptedException {
	 * Report.ReporterOutputHeader(); }
	 */

	// -------------------Screenshot----------------------------------------------------------------
	public static void takeSnapShot(String file) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = (TakesScreenshot) driver;

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(file);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

	// ----------------------------Login-----------------------------------
	@Test(enabled = false, groups = { "login" }, dependsOnGroups = { "Select", "Search" })
	public void test_login() {
		Action_Login.Signin(driver);
	}

	// ----------------------------Search-----------------------------------
	// @DataProvider(name = "")
	@Parameters({ "browser", "driversyntax", "path" })
	@Test(enabled = false, dataProvider = "Search", groups = { "Search1" }, singleThreaded = true, priority = 0)
	public void test_Search(String Search_p, String Locaters, String Product_name) throws Throwable {
		Report.ReporterOutputHeader();
		i++;
		try {

			searchresult = Action_Search.Search(driver, url, Search_p, Locaters);

			if (!searchresult.isEmpty() || searchresult != null) {

				search = (searchresult.contains(Product_name));

				if (search) {
					Assert.assertTrue(searchresult.contains(Product_name));
					Report.ReporterOutput(i + ". Search for the product for" + Search_p + " for " + browser,
							"Verify the Search result for the product" + Search_p, Search_p, Product_name, searchresult,
							"Pass", null);

				} else {
					Report.ReporterOutput(i + ". Search for the product" + Search_p + " for " + browser,
							"Verify the Search result for the product " + Search_p, Search_p, Product_name,
							searchresult, "Fail", null);

				}
			}

			else {
				Report.ReporterOutput(i + ". Search for product" + Search_p + " for " + browser,
						"Verify the Search result for the product " + Search_p, Search_p, Product_name, searchresult,
						"Fail", null);

				// throw new SkipException("Skipping this exception");
			}
		} catch (Exception e) {
			e.getCause();
		}
		Report.TableEnd();
	}

	// ----------------------------Select------------------------------------------------------
	@Parameters({ "browser", "driversyntax", "path" })
	@Test(enabled = true, dataProvider = "Search", priority = 1, singleThreaded = true)
	public void select_ProductName(String Search_p, String Locaters, String Product_name) throws Throwable {
		Report.ReporterOutputHeader();
		i++;
		try {
			searchresult = Action_Search.Search(driver, url, Search_p, Locaters);
			if ((searchresult != null || !(searchresult.isEmpty())) && (searchresult.contains(Product_name))) {
				product = pom_Search.item_name(driver, Locaters);
				if (product != null) {

					/*
					 * Point hoverItem =product.getLocation();
					 * ((JavascriptExecutor)driver).
					 * executeScript("return window.title;");
					 * ((JavascriptExecutor)driver).executeScript(
					 * "window.scrollBy(0,"+( hoverItem.getY())+");");
					 */
					String originalHandle = driver.getWindowHandle();
					try {
						product.click();
						productName = Action_Select.getProductName(driver, Search_p);
						if (!productName.isEmpty() || productName != null) {
							select = (productName.contains(Product_name));
							if (select) {
								Assert.assertTrue(productName.contains(Product_name));
								Report.ReporterOutput(i + ". Select for the product " + Search_p + " for " + browser,
										"Verify the Selection result for the product" + Search_p, Search_p,
										Product_name, productName, "Pass", null);
							} else {
								Report.ReporterOutput(i + ". Select for the product " + Search_p + " for " + browser,
										"Verify the Selection result for the product " + Search_p, Search_p,
										Product_name, productName, "Fail", null);
							}

						}
					} catch (Exception e) {

						for (String handle : driver.getWindowHandles()) {
							if (!handle.equals(originalHandle)) {
								driver.switchTo().window(handle);
								driver.close();
							}
						}

						driver.switchTo().window(originalHandle);

					}

					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,300)", "");
					try {
						Action_Select.Buynow_btn(driver);
						if (driver.getTitle().equals("Amazon Sign In")) {
							Action_Login.Signin(driver);
						}
					} catch (Exception e) {
						e.getCause();
						String originalHandle1 = driver.getWindowHandle();

						// Do something to open new tabs

						for (String handle : driver.getWindowHandles()) {
							if (!handle.equals(originalHandle1)) {
								driver.switchTo().window(handle);
								driver.close();
							}
						}

						driver.switchTo().window(originalHandle1);

					}
				//	if (driver.getTitle().equals("Select a delivery address")) {
						payment();
				/*	} else {
						Report.ReporterOutput(i + ". Select for the product " + Search_p + " for " + browser,
								"Verify the Selection result for the product" + Search_p, Search_p, Product_name,
								productName, "Fail", null);
						// throw new SkipException("Skipping this exception");
					}*/

					// String originalHandle = driver.getWindowHandle();

					// Do something to open new tabs

					for (String handle : driver.getWindowHandles()) {
						if (!handle.equals(originalHandle)) {
							driver.switchTo().window(handle);
							driver.close();
						}
					}

					driver.switchTo().window(originalHandle);
				} else {
					Report.ReporterOutput(i + ". Select for the product " + Search_p + " for " + browser,
							"Verify the Selection result for the product" + Search_p, Search_p, Product_name,
							productName, "Fail", null);
					// throw new SkipException("Skipping this exception");
				}
			} else {
				Report.ReporterOutput(i + ". Select for the product " + Search_p + " for " + browser,
						"Verify the Selection result for the product" + Search_p, Search_p, Product_name, productName,
						"Fail", null);
				// throw new SkipException("Skipping this exception");
			}
		} catch (Exception e) {

		}
		Report.TableEnd();
	}

	// @DataProvider(name="")
	@Test(enabled = false, dataProvider = "productdescxl", groups = { "Select" }, dependsOnGroups = { "Search" })
	public void select_Descripition() {
		String productDescription = Action_Select.getProductDescription(driver);
		if (!productDescription.isEmpty()) {
			Assert.assertEquals(productDescription, "", "The product item is not found");
		}
	}

	@DataProvider(name = "")
	@Test(enabled = false, dataProvider = "productPricexl", groups = { "Select" }, dependsOnGroups = {
			"Search" }, dependsOnMethods = { "select_Descripition" })
	public void select_productPrice() {
		String productPrice = Action_Select.getPrice(driver);
		if (!productPrice.isEmpty()) {
			Assert.assertEquals(productPrice, "", "The product item is not found");
		}
	}

	// @DataProvider(name="")
	@Test(enabled = false, dataProvider = "productoffersxl", groups = { "Select" }, dependsOnGroups = {
			"Search" }, dependsOnMethods = { "select_productPrice" })
	public void select_productOffers() {
		String productOffers = Action_Select.getProductOffers(driver);
		if (!productOffers.isEmpty()) {
			Assert.assertEquals(productOffers, "", "The product item is not found");
		}
	}

	// @DataProvider()
	@Test(enabled = false, dataProvider = "productRelatedxl", groups = { "Select" }, dependsOnGroups = {
			"Search" }, dependsOnMethods = { "select_productOffers" })
	public void select_productRelated() {
		String productRelated = Action_Select.getProductRelated(driver);
		if (!productRelated.isEmpty()) {
			Assert.assertEquals(productRelated, "", "The product item is not found");
		}
	}

	// ----------------------------Address--------------------------------------------

	@Test(enabled = false, /* dataProvider="Addressxl" */groups = { "Address" }, dependsOnGroups = { "login", "Search",
			"Select" })
	public void address() {
		List<String> abcd = Action_Address.getAddresss(driver);
		String ab = (String) abcd.toString().trim().subSequence(1, 88);
		if (!abcd.isEmpty() && !(abcd == null)) {
			Assert.assertEquals(ab,
					"Nikhil Waghmare, Flat 15 Modi baug, Development Street, PUNE, MAHARASHTRA 411005, India",
					"The address is invalid");
		}
	}

	// ----------------------------Payment-----------------------------------

	// @Test(dataProvider = "Search", groups = { "Payment" }, dependsOnGroups =
	// { /* "Search" */"Select" })
	public static void payment() {
	//	Action_Payment.payment_btn_click(driver);
		String payment_text = Action_Payment.verify_checkout(driver);
		Assert.assertEquals(payment_text, "Select a payment method", "paymentpage is not reached");
	}

	@AfterClass()
	public void finish() {
		driver.quit();

	}

	// DATAPROVIDERS-----------------------------------------------
	@DataProvider(name = "Search")
	public Object[][] searchdata() {
		String[][] objectList = null;
		String file = "G:\\Vikas- Shailesh - demo Framework\\TestData.xlsx";
		String Sheet = "Search";

		try {
			FileInputStream fs = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(fs);
			org.apache.poi.ss.usermodel.Sheet sh = wb.getSheet(Sheet);

			int totalNoOfRows = sh.getLastRowNum() - sh.getFirstRowNum();
			int totalcolumns = sh.getRow(1).getLastCellNum();

			objectList = new String[totalNoOfRows][totalcolumns];

			for (int i = 0; i < totalNoOfRows; ++i) {

				Row row = sh.getRow(i + 1);

				// for (int j = 0; j <= row.getLastCellNum()-1; j++) {

				for (int j = 0; j <= sh.getRow(0).getLastCellNum() - 1; j++) {
					objectList[i][j] = row.getCell(j).getStringCellValue().toString();

				}
				// System.out.println(arrayExcelData[i][0]
				// +" "+arrayExcelData[i][1]);

			}
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectList;

	}
}
