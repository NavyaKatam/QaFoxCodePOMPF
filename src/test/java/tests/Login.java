package tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.LandingPage;
import pages.LoginPage;
import util.Utilities;

public class Login {
	
	Properties prop;
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		prop = Utilities.loadPropertiesFile();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("appURL"));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		driver = landingPage.selectLoginOption();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="dataSupplier1")
	public void verifyLoginUsingValidCredentials(String email,String password) {
	
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.naviagedToLoginPage());
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.isUserLoggedIn());
		Assert.assertTrue(accountPage.navigatedToAccountPage());
	
	}
	
	@DataProvider(name="dataSupplier1")
	public Object[][] supplyTestDataOne() {
		Object[][] data = {{"amotooribatch1@gmail.com","abcde"},
				{"amotooribatch11@gmail.com","fghij"},
				{"amotooribatch111@gmail.com","klmno"}};
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
