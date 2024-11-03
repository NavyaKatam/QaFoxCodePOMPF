package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;
import util.Utilities;

public class RegisterPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='0']")
	private WebElement noNewsletterOption; 
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	public void enterFirstName(String firstNameText) {
		elementUtils.enterTextIntoElement(firstNameField,Utilities.EXPLICIT_WAIT_TIME,firstNameText);	
	}
	
	public void enterLastName(String lastNameText) {
		elementUtils.enterTextIntoElement(lastNameField,Utilities.EXPLICIT_WAIT_TIME,lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		elementUtils.enterTextIntoElement(emailField,Utilities.EXPLICIT_WAIT_TIME,emailText);
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		elementUtils.enterTextIntoElement(telephoneField,Utilities.EXPLICIT_WAIT_TIME,telephoneText);
	}
	
	public void enterPassword(String passwordText) {
        elementUtils.enterTextIntoElement(passwordField,Utilities.EXPLICIT_WAIT_TIME,passwordText);
	}
	
	public void enterConfirmPassword(String passwordText) {
		elementUtils.enterTextIntoElement(passwordConfirmField,Utilities.EXPLICIT_WAIT_TIME,passwordText);
	}
	
	public void selectYesNewsletterOption() {
		elementUtils.clickOnElement(yesNewsletterOption,Utilities.EXPLICIT_WAIT_TIME);
	}
	
	public void selectNoNewsletterOption() {
		elementUtils.clickOnElement(noNewsletterOption,Utilities.EXPLICIT_WAIT_TIME);
	}
	
	public void selectPrivacyPolicyOption() {
		elementUtils.clickOnElement(privacyPolicyField,Utilities.EXPLICIT_WAIT_TIME);
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		elementUtils.clickOnElement(continueButton,Utilities.EXPLICIT_WAIT_TIME);
		return new AccountSuccessPage(driver);
	}
	
	
	
}
