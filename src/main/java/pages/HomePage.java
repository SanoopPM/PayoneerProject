package pages;

import static org.junit.Assert.assertFalse;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;
import generics.DriverFunctionalities;

public class HomePage {
	
	private static String JACOB_32_PATHNAME = "C:\\Users\\pmsanoop\\eclipse-workspace\\PayoneerProject\\jacob\\jacob-1.19-x86.dll";

	private static String JACOB_32_PATHNAME_OLD = "C:\\Users\\pmsanoop\\eclipse-workspace\\PayoneerProject\\jacob\\jacob-1.18-M2-x86.dll";

	WebDriver driver;

	@FindBy(className="ProfileButton-avatar")
	private WebElement profileBtn;

	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logoutBtn;

	@FindBy(className="OnboardingTrackerActions-actionIcon")
	private WebElement popUpMenuMinimize;

	@FindBy(xpath="//*[text()='New']")
	private WebElement newButton;

	@FindBy(name="folder-name")
	private WebElement folderName;

	@FindBy(name="invite-permission")
	private WebElement folderInvitePermission;

	@FindBy(xpath="//button[.='Create']")
	private WebElement folderCreateBtn;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}

	public void validateHomePage() {
		try {
			DriverFunctionalities.expWaitforElementVisibility(driver, profileBtn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		try {
			profileBtn.click();
			DriverFunctionalities.expWaitforElementVisibility(driver, logoutBtn);
			logoutBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void minimizePopUpMenu() {
		DriverFunctionalities.expWaitforElementVisibility(driver, popUpMenuMinimize);
		popUpMenuMinimize.click();
	}

	public void clickNewButton() {
		try {
			Thread.sleep(5000);
			DriverFunctionalities.expWaitforElementVisibility(driver, newButton);
			newButton.click();
		} catch (Exception e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	public void addNew(String value) {
		try {
			Thread.sleep(5000);

			driver.findElement(By.xpath("//li[.='"+value+"']")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void createFolder() {
		try {
			Thread.sleep(5000);
			folderName.sendKeys("TestingSanoop");
			Select s = new Select(folderInvitePermission);
			s.selectByValue("Editor");
			folderCreateBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadFile(String pathoffile) {
		try {
			Runtime.getRuntime().exec(new String[]{"D:\\Workspace_Oxy\\PayoneerProject\\src\\main\\resources\\AutoItScript\\Fileupload.exe",pathoffile});

			System.out.println("File upload END");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
