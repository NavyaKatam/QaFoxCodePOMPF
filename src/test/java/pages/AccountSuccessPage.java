package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;
import util.Utilities;

public class AccountSuccessPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="Logout")
	private WebElement logoutOption; 
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Success']")
	private WebElement accountSuccessBreadcrumbOption;
	
	@FindBy(id="content")
	private WebElement successPageContent;
	
	@FindBy(linkText="Continue")
	private WebElement continueButton; 
	
	public boolean isUserLoggedIn() {
		return elementUtils.dispalyStatusOfElement(logoutOption);
	}
	
	public boolean isAccountSuccessPageDisplayed() {
		return elementUtils.dispalyStatusOfElement(accountSuccessBreadcrumbOption);
	}
	
	public String getProperContentDisplayed() {
		return elementUtils.retrieveTextFromElement(successPageContent,Utilities.EXPLICIT_WAIT_TIME);
	}
	
	public AccountPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton,Utilities.EXPLICIT_WAIT_TIME);
		return new AccountPage(driver);
	}

}
