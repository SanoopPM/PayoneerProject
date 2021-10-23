package pages;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.DriverFunctionalities;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(linkText="Log in")
	private WebElement loginHomeBtn;
	
	@FindBy(id="login-email")
	private WebElement emailIdTxtBox;
	
	@FindBy(id="login-submit")
	private WebElement nextBtn;
	
	@FindBy(id="password-login")
	private WebElement passwordTxtBox;
	
	@FindBy(id="login-submit-password")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void validateSignInPage() {
		try {
			DriverFunctionalities.expWaitforElementVisibility(driver, emailIdTxtBox);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void navigateToLoginPage() {
		try {
			loginHomeBtn.click();
		} catch (Exception e) {
			assertFalse(true, "Login home page not visible");
		}
	}
	
	public void login() {		
		try {
			DriverFunctionalities.expWaitforElementVisibility(driver, emailIdTxtBox);
			emailIdTxtBox.sendKeys("sanoop.p.mohan@gmail.com");
			nextBtn.click();
			Thread.sleep(5000);
			DriverFunctionalities.expWaitforElementVisibility(driver, passwordTxtBox);
			passwordTxtBox.sendKeys("Blacksnow@1989");
//			loginBtn.click();
		} catch (Exception e) {
			assertFalse(true, "Login to application failed");
		}		
	}
	

}
