package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;
import util.Utilities;

public class LoginPage {
	
	WebDriver driver;
	ElementUtils elementUtils;	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Login']")
	private WebElement loginBreadcrumbOption;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement warningMessage;
	
	public boolean naviagedToLoginPage() {
		return elementUtils.dispalyStatusOfElement(loginBreadcrumbOption);
	}
	
	public void enterEmailAddress(String emailText) {
		elementUtils.enterTextIntoElement(emailAddressField,Utilities.EXPLICIT_WAIT_TIME,emailText);
	}
	
	public void enterPassword(String passwordText) {
		elementUtils.enterTextIntoElement(passwordField,Utilities.EXPLICIT_WAIT_TIME,passwordText);
	}
	
	public AccountPage clickOnLoginButton() {
		elementUtils.clickOnElement(loginButton,Utilities.EXPLICIT_WAIT_TIME);
		return new AccountPage(driver);
	}
	
	public String getWarningMessage() {
		return elementUtils.retrieveTextFromElement(warningMessage,Utilities.EXPLICIT_WAIT_TIME);
	}

}
