package Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pom.pom_Search;


public class Action_Search {
	public static String Search(WebDriver driver, String url,String Search_p, String Locaters) {
		driver.get(url);
		pom_Search.search_box(driver).sendKeys(Search_p); //to be parameterized
		pom_Search.go_btn(driver).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String item=pom_Search.item_name(driver,Locaters).getText();
		return item;
		//expected to be parameterized 
		}

}
