package tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.LandingPage;
import pages.LoginPage;
import util.MyXLSReader;
import util.Utilities;

public class Login extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = openApplicationURLIntheBrowser(prop.getProperty("browser"));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		driver = landingPage.selectLoginOption();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="dataSupplier1")
	public void verifyLoginUsingValidCredentials(HashMap<String,String> hMap) {
	
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.naviagedToLoginPage());
		loginPage.enterEmailAddress(hMap.get("Username"));
		loginPage.enterPassword(hMap.get("Password"));
		loginPage.clickOnLoginButton();
		
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.isUserLoggedIn());
		Assert.assertTrue(accountPage.navigatedToAccountPage());
	
	}
	
	@DataProvider(name="dataSupplier1")
	public Object[][] supplyTestDataOne() {
		MyXLSReader xlsReader = null;
		Object[][] data = null;
		try {
			xlsReader = new MyXLSReader(System.getProperty("user.dir")+"\\src\\test\\resources\\TutorialsNinjaData.xlsx");
			data = Utilities.getTestData(xlsReader,"LoginTest","TestData");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(priority=2)
	public void verifyLoginUsingInvalidCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(Utilities.generateNewEmail());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String acutalWarningMessage = loginPage.getWarningMessage();
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		
	}
	
	@Test(priority=3)
	public void verifyLoginUsingInvalidEmailAndValidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(Utilities.generateNewEmail());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String acutalWarningMessage = loginPage.getWarningMessage();
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		
	}
	
	@Test(priority=4)
	public void verifyLoginUsingValidEmailAndInvalidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmailTwo"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String acutalWarningMessage = loginPage.getWarningMessage();
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();
		
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String acutalWarningMessage = loginPage.getWarningMessage();
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		
	}
	
	

}
