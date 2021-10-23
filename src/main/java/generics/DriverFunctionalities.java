package generics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFunctionalities{
	
	public static void pageRefresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	public static void waitForPageLoad(WebDriver driver){
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
	public static void scroll(WebElement element, WebDriver _driver){
		((JavascriptExecutor)_driver).executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static void scrollpageDown(WebDriver _driver)
	{
		((JavascriptExecutor)_driver).executeScript("scroll(0,100)");
	}
	
	public static void scrollpageRight(WebDriver _driver)
	{
		((JavascriptExecutor)_driver).executeScript("scroll(100,0)");
	}

	
	public static void expWaitforElementVisibility(WebDriver driver, WebElement element)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();		
		}		
	}
	
	public static void expWaitforAllelementVisibility(WebDriver driver , List<WebElement> element)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	public static void expWaitforElementClickable(WebDriver driver, WebElement element)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	} 
	
	public static void expWaitforElementInvisibility(WebDriver driver, WebElement element)
	{
		try {
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();		
		}		
	} 
 
	
	public static WebDriver implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}
	
	
	
	
	
}
