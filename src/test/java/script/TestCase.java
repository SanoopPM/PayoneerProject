package script;

import org.testng.annotations.Test;

import generics.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class TestCase extends BaseTest {
	
	@Test(enabled=true)
	public void Test_Login() {
		LoginPage lp = new LoginPage(driver);
		lp.navigateToLoginPage();
		lp.login();
//		HomePage hp = new HomePage(driver);
//		hp.validateHomePage();
//		hp.logout();
//		lp.validateSignInPage();
	}
	
	@Test(enabled=false)
	public void Test_CreateFolder() {
		LoginPage lp = new LoginPage(driver);
		lp.navigateToLoginPage();
		lp.login();
		HomePage hp = new HomePage(driver);
		hp.validateHomePage();
		hp.minimizePopUpMenu();
		hp.clickNewButton();
		hp.addNew("Folder");
		hp.createFolder();
	}
	
	@Test(enabled=false)
	public void Test_FileUpload() {
		LoginPage lp = new LoginPage(driver);
		lp.navigateToLoginPage();
		lp.login();
		HomePage hp = new HomePage(driver);
		hp.validateHomePage();
		hp.minimizePopUpMenu();
		hp.clickNewButton();
		hp.addNew("File Upload");
		hp.uploadFile("D:\\Workspace_Oxy\\PayoneerProject\\Inputdata\\Dummy.txt");
	}

}
