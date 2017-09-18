package CommonObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonObjects {

	private static WebElement element = null;

		public static WebElement lnk_Sales(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id='leftNav']/ul/li[1]/a"));
		return element;

	}
		
	

	public static WebElement lnk_Sales_Plan(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='buy_section']/li[1]/a/span"));
		return element;

	}
	
	


	public static WebElement lnk_ExportToExcel(WebDriver driver) {

		element = driver.findElement(By.linkText("Export to Excel "));
		return element;
	}

	
	public static WebElement lnk_SearchCriteria(WebDriver driver) {

		element = driver.findElement(By.linkText("Search Criteria"));
		return element;
	}

	
	public static WebElement txtbox_Search(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='salesplangrid_filter']/label"));
		return element;
	}

	
	public static WebElement DropDownShowsRecord(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='salesplangrid_length']/label/select"));
		return element;
	}

	
	public static WebElement lnk_PaginationNext(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='salesplangrid_next']/a"));
		return element;
	}


	public static WebElement lnk_PaginationPrevious(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='salesplangrid_previous']/a"));
		return element;
	}

	/*

	* */
	public static WebElement Radiobutton(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='salesplangrid']/thead/tr/th[1]"));
		return element;
	}

	
	public static WebElement lnk_SortingOrder(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='salesplangrid']/thead/tr/th[2]"));
		return element;
	}


	public static WebElement btn_Edit(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='salesplangrid']/tbody/tr[1]/td[12]/a/span"));
		return element;
	}

	
	public static WebElement btn_Delete(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='11row']/span"));
		return element;
	}


	public static WebElement lnk_UploadFile(WebDriver driver) {

		element = driver.findElement(By.id("uploadFiles0"));
		return element;
	}

	
	public static WebElement btn_Remove(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='fileTable']/tbody/tr/td[2]/input"));
		return element;
	}

	
	public static WebElement btn_AddFile(WebDriver driver) {

		element = driver.findElement(By.id("addFile"));
		return element;
	}

	
	public static WebElement btn_Cancel(WebDriver driver) {

		element = driver.findElement(By.xpath("html/body/div[1]/div/div/div[3]/div/div[9]/div/button[2]"));
		return element;
	}
	
	
	public static WebElement btnpopup_Cancel(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='popup_cancel']"));
		return element;
	}

	
	public static WebElement btn_Save(WebDriver driver) {

		element = driver.findElement(By.id("save"));
		return element;
	}

	
	public static WebElement btn_AddProduct(WebDriver driver) {

		element = driver.findElement(By.id("addRow"));
		return element;
	}
 static WebElement lnk_Click(WebDriver driver) {

		element = driver.findElement(By.linkText("Click"));
		return element;
	}
	
	public static WebElement list_Currency(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='addEditSalesPlanForm']/div[2]/div[5]/label"));
		return element;
	}

	
	public static WebElement list_Customer(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='customerno']"));
		return element;
	}

	
	public static WebElement list_CustomerName(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='customername']"));
		return element;
	}

	
	public static WebElement list_SalesOrganizatione(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='salesorg']"));
		return element;
	}

	
	public static WebElement list_Region(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='region']"));
		return element;
	}

	
	public static WebElement list_PriceType(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='price']"));
		return element;
	}

	
	public static WebElement list_Incoterms(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='incotermsId']"));
		return element;
	}

	
	public static WebElement list_SalesPlan(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='salesplanid']"));
		return element;
	}

	
	public static WebElement list_Product(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='productId1_chosen']/a"));
		return element;
	}

	
	public static WebElement list_Product1(WebDriver driver) {

		element = driver.findElement(By
				.xpath(".//*[@id='productId2_chosen']/a"));
		return element;
	}


	public static WebElement list_Grain(WebDriver driver) {

		element = driver.findElement(By.xpath(".//*[@id='grain_chosen']/a"));
		return element;
	}

	
	public static WebElement txtbox_GrainPrice(WebDriver driver) {

		element = driver.findElement(By.id("gPrice1"));
		return element;
	}

	public static WebElement txtbox_GrainQuantity(WebDriver driver) {
		element = driver.findElement(By.id("qty1"));
		return element;
	}

	
	public static WebElement txtbox_TotalQuantity(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@id='totalQty1']"));
		return element;
	}

}
