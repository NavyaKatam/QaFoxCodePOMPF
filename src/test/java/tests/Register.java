package tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.LandingPage;
import pages.NewsletterSubscriptionPage;
import pages.RegisterPage;
import util.Utilities;

public class Register {
	
	WebDriver driver;
	Properties prop;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void setup() {
		
		prop = Utilities.loadPropertiesFile();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("appURL"));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		driver = landingPage.selectRegisterOption();
		
	}

	@Test(priority=1)
	public void verifyRegistingAccountUsingMandtoryFields() {
	    
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectPrivacyPolicyOption();
		driver = registerPage.clickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.isAccountSuccessPageDisplayed());
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailsSix = "contact us";
		
		String actualProperDetails = accountSuccessPage.getProperContentDisplayed();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));
		
		driver = accountSuccessPage.clickOnContinueButton();
		
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.navigatedToAccountPage());
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountUsingAllFields() {
	
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesNewsletterOption();
		registerPage.selectPrivacyPolicyOption();
		driver = registerPage.clickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.isAccountSuccessPageDisplayed());
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailsSix = "contact us";
		
		String actualProperDetails = accountSuccessPage.getProperContentDisplayed();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));
		
		driver = accountSuccessPage.clickOnContinueButton();
		
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.navigatedToAccountPage());
		
	}
	
	@Test(priority=3)
	public void verifyRegisterationBySayingYesToNewsletter() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesNewsletterOption();
		registerPage.selectPrivacyPolicyOption();
		driver = registerPage.clickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.isAccountSuccessPageDisplayed());
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailsSix = "contact us";
		
		String actualProperDetails = accountSuccessPage.getProperContentDisplayed();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));
		
		driver = accountSuccessPage.clickOnContinueButton();
		
		AccountPage accountPage = new AccountPage(driver);
		
		Assert.assertTrue(accountPage.navigatedToAccountPage());
		
		driver = accountPage.clickOnSubscribeUnscribeToNewsletterOption();
		
		NewsletterSubscriptionPage newsletterSubscriptionPage = new NewsletterSubscriptionPage(driver);
		Assert.assertTrue(newsletterSubscriptionPage.isYesNewsletterOptionSelected());
		
	}
	
	@Test(priority=4)
	public void verifyRegisterationBySayingNoToNewsletter() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNoNewsletterOption();
		registerPage.selectPrivacyPolicyOption();
		driver = registerPage.clickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
		Assert.assertTrue(accountSuccessPage.isAccountSuccessPageDisplayed());
		
		String expectedProperDetailsOne = "Your Account Has Been Created!";
		String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
		String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetailsSix = "contact us";
		
		String actualProperDetails = accountSuccessPage.getProperContentDisplayed();
		
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
		Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));
		
		driver = accountSuccessPage.clickOnContinueButton();
		
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.navigatedToAccountPage());
		
		driver = accountPage.clickOnSubscribeUnscribeToNewsletterOption();
		NewsletterSubscriptionPage newsletterSubscriptionPage = new NewsletterSubscriptionPage(driver);
		Assert.assertTrue(newsletterSubscriptionPage.isNoNewsletterOptionSelected());
		
	}

}
