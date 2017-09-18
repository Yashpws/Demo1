package Actions;

import pom.pom_Login;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//import CommonObjects.Constant;

public class Action_Login {

	static String url = "http://www.amazon.in/";
	static WebElement user;
	static WebElement password;
	static String u= "Nikhilwil@gmail.com";
	static String p = "Nikhil!#";
	public static void Signout(WebDriver driver) {

		user= pom_Login.signin_l(driver);
		user.sendKeys(u);
		WebElement password = pom_Login.signin_lp(driver);
		password.sendKeys(p);
		WebElement btn = pom_Login.signin_btn(driver);
		btn.click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement next = pom_Login.signin_next_page(driver);
		Assert.assertEquals(next.getText(), "Nikhil Waghmare", "Delivery address page is not loaded");
		

	}

	
	public static void Signin(WebDriver driver) {

		user= pom_Login.signin_l(driver);
		user.clear();
		user.sendKeys(u);
		password = pom_Login.signin_lp(driver);
		password.sendKeys(p);
		WebElement btn = pom_Login.signin_btn(driver);
		btn.click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		WebElement next = pom_Login.signin_next_page(driver);
		Assert.assertEquals(next.getText(), "Nikhil Waghmare", "Delivery address page is not loaded");
		

	}

}
