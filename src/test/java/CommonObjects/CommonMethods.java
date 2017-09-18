package CommonObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	
	public static WebElement waitForElement(WebElement element, WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,1000);
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	
	public static List<WebElement> waitForElements(List<WebElement> elements,
			WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,300);
			return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public static Set<WebElement> waitForUniqueElements(List<WebElement> list,
			WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 300);
			return (Set<WebElement>) wait.until(ExpectedConditions
					.visibilityOfAllElements((List<WebElement>) list));
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}
	
	public static Alert waitForAlertPresent(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			return wait.until(ExpectedConditions.alertIsPresent());
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}

	
	public static WebElement waitForElementClickable(WebElement element,
			WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,700);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}

	
	public static boolean waitForTextIsPresentInElement(WebElement element,
			WebDriver driver, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			return wait.until(ExpectedConditions.textToBePresentInElementValue(
					element, text));
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(e.getMessage());
		}
	}

	
	/*public static String dynamicValues(List<WebElement> searchedElements) {
		int maxIndex = 0;
		String newDynamicElements = null;
		for (int i = 0; i < searchedElements.size(); i++) {
			if (!waitForElements(searchedElements, Constant.driver).get(0).getText()
					.equals("")) {
				maxIndex = Integer.parseInt(waitForElements(searchedElements,
						Constant.driver).get(0).getText().replaceAll("[^0-9]", ""));
				
				if(maxIndex+1 != Integer.parseInt(searchedElements.get(i).getText().replaceAll("[^0-9]", ""))) {
				newDynamicElements = searchedElements.get(0).getText().replaceAll(
						"\\d+.*", Integer.toString(++maxIndex));
				break;
				}
			} else {
				newDynamicElements = searchedElements.get(0).getText().replaceAll(
						"\\d+.*", Integer.toString(maxIndex++));
			}
		}
		return newDynamicElements;
	}*/

	
	public static String Random =null;
	
	@SuppressWarnings("unused")
	public static String getID(){

		  int n=351;
		 double d=0;          
		      
		   int num=1;  
		   {                    
		while(true)          
		{   
		    
		int final_limit=10000; //Specifiy the maximum limit          
		d=Math.random()*final_limit;          
		 num=(int)d;          
		Random=String.valueOf(num);
		//System.out.println(Random);
		break;          
		         
		}
		         
		return Random;  

		//This will return random number every time you run within 10000(specified limit)     
		}   
		    
		} 
	
	
}
