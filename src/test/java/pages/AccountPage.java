package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;
import util.Utilities;

public class AccountPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	private WebElement subscribeUnsubscribeNewsletterOption;
	
	@FindBy(linkText="Logout")
	private WebElement logoutOption;
	
	public boolean navigatedToAccountPage() {
		return elementUtils.dispalyStatusOfElement(editYourAccountInformationOption);
	}
	
	public NewsletterSubscriptionPage clickOnSubscribeUnscribeToNewsletterOption(){
		elementUtils.clickOnElement(subscribeUnsubscribeNewsletterOption,Utilities.EXPLICIT_WAIT_TIME);
		return new NewsletterSubscriptionPage(driver);
	}
	
	public boolean isUserLoggedIn() {
		return elementUtils.dispalyStatusOfElement(logoutOption);
	}
}
