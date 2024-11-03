package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.LandingPage;
import pages.NewsletterSubscriptionPage;
import pages.RegisterPage;
import util.Utilities;

public class RegisterTest extends Base {
	
	public WebDriver driver;
	LandingPage landingPage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;
	NewsletterSubscriptionPage newsletterSubscriptionPage;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver = openApplicationURLIntheBrowser(prop.getProperty("browser"));
		landingPage = new LandingPage(driver);
		landingPage.clickOnMyAccountDropMenu();
		registerPage = landingPage.selectRegisterOption();
		
	}

	@Test(priority=1)
	public void verifyRegistingAccountUsingMandtoryFields() {
	    
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickOnContinueButton();
		
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
		
		accountPage = accountSuccessPage.clickOnContinueButton();
		
		Assert.assertTrue(accountPage.navigatedToAccountPage());
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringAccountUsingAllFields() {
	
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesNewsletterOption();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickOnContinueButton();
	
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
		
		AccountPage accountPage = accountSuccessPage.clickOnContinueButton();
		
		Assert.assertTrue(accountPage.navigatedToAccountPage());
		
	}
	
	@Test(priority=3)
	public void verifyRegisterationBySayingYesToNewsletter() {
		
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectYesNewsletterOption();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickOnContinueButton();
	
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
		
		accountPage = accountSuccessPage.clickOnContinueButton();
		
		Assert.assertTrue(accountPage.navigatedToAccountPage());
		
		newsletterSubscriptionPage = accountPage.clickOnSubscribeUnscribeToNewsletterOption();
	
		Assert.assertTrue(newsletterSubscriptionPage.isYesNewsletterOptionSelected());
		
	}
	
	@Test(priority=4,enabled=false)
	public void verifyRegisterationBySayingNoToNewsletter() {
		
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateNewEmail());
		registerPage.enterTelephoneNumber(prop.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.selectNoNewsletterOption();
		registerPage.selectPrivacyPolicyOption();
		accountSuccessPage = registerPage.clickOnContinueButton();
	
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
		
		accountPage = accountSuccessPage.clickOnContinueButton();
		
	
		Assert.assertTrue(accountPage.navigatedToAccountPage());
		
		newsletterSubscriptionPage = accountPage.clickOnSubscribeUnscribeToNewsletterOption();
		
		Assert.assertTrue(newsletterSubscriptionPage.isNoNewsletterOptionSelected());
		
	}

}
