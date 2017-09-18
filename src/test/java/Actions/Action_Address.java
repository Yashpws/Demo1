package Actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pom.pom_Address;

public class Action_Address {

	static List<WebElement> address;
	static int addresslines;

	public static void Deliver_btn(WebDriver driver) {
		pom_Address.deliver_btn(driver).click();

	}

	public static List<String> getAddresss(WebDriver driver) {
		address = pom_Address.Delivery_details(driver);
		List<String> abc=new ArrayList<String>();
		System.out.println(address);
		addresslines = address.size();
		for (WebElement ele : address) {
			ele.getText().toString().trim();
			System.out.println(ele.getText().toString().trim());
			abc.add(ele.getText().toString().trim());
		}
		return abc;

	}

}
