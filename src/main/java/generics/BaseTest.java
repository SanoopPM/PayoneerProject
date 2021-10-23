package generics;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	public WebDriver driver;
	
	public static String dateformat;
	
	public static String currentMonth;
	
	
	
	@BeforeSuite (alwaysRun=true)
	public void Prelaunch() throws IOException
	{
		PropertyConfigurator.configure("./Inputdata/log4j.properties");
		Date date=new Date();
		
		DateFormat Simple_date_format = new SimpleDateFormat("dd-MM-yyyy HH-mmaa");		
		dateformat = Simple_date_format.format(date);
		
		
	}
	

	
	//lauching browser..
	@BeforeClass (alwaysRun=true)
	public void precondition() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\exefiles\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("http://www.box.com/");
		driver.manage().window().maximize();
	}
		
	
	//closing browser	
	@AfterClass (alwaysRun=true)
	public void postcondition()
	{	
		System.out.println("Closing browser");
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.quit();
	}

}
