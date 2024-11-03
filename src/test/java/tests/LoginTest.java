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

public class LoginTest extends Base {
	
	public WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@BeforeMethod
	public void setup() {
		
		driver = openApplicationURLIntheBrowser(prop.getProperty("browser"));
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		loginPage = landingPage.selectLoginOption();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="dataSupplier1")
	public void verifyLoginUsingValidCredentials(HashMap<String,String> hMap) {
	    
		Assert.assertTrue(loginPage.naviagedToLoginPage());
		loginPage.enterEmailAddress(hMap.get("Username"));
		loginPage.enterPassword(hMap.get("Password"));
		accountPage = loginPage.clickOnLoginButton();
	
		Assert.assertTrue(accountPage.isUserLoggedIn());
		Assert.assertTrue(accountPage.navigatedToAccountPage());
	
	}
	
	@DataProvider(name="dataSupplier1")
	public Object[][] supplyTestDataOne() {
		MyXLSReader xlsReader = null;
		Object[][] data = null;
		try {
			prop = Utilities.loadPropertiesFile();
			xlsReader = new MyXLSReader(System.getProperty("user.dir")+prop.getProperty("excelFilePath"));
			data = Utilities.getTestData(xlsReader,"LoginTest","TestData");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@Test(priority=2)
	public void verifyLoginUsingInvalidCredentials() {
		
		loginPage.enterEmailAddress(Utilities.generateNewEmail());
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String acutalWarningMessage = loginPage.getWarningMessage();
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		
	}
	
	@Test(priority=3)
	public void verifyLoginUsingInvalidEmailAndValidPassword() {
	
		loginPage.enterEmailAddress(Utilities.generateNewEmail());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String acutalWarningMessage = loginPage.getWarningMessage();
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		
	}
	
	@Test(priority=4)
	public void verifyLoginUsingValidEmailAndInvalidPassword() {
	
		loginPage.enterEmailAddress(prop.getProperty("validEmailTwo"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String acutalWarningMessage = loginPage.getWarningMessage();
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutCredentials() {
	
		loginPage.clickOnLoginButton();
		
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		String acutalWarningMessage = loginPage.getWarningMessage();
		Assert.assertTrue(acutalWarningMessage.contains(expectedWarningMessage));
		
	}
	
	

}
