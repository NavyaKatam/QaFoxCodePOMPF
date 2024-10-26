package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
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
		
		firstNameField.sendKeys(firstNameText);
	
	}
	
	public void enterLastName(String lastNameText) {
		
		lastNameField.sendKeys(lastNameText);
		
	}
	
	public void enterEmailAddress(String emailText) {
		
		emailField.sendKeys(emailText);
		
	}
	
	public void enterTelephoneNumber(String telephoneText) {
		
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {

		passwordField.sendKeys(passwordText);
		
	}
	
	public void enterConfirmPassword(String passwordText) {

		passwordConfirmField.sendKeys(passwordText);
		
	}
	
	public void selectYesNewsletterOption() {
		yesNewsletterOption.click();
	}
	
	public void selectNoNewsletterOption() {
		
		noNewsletterOption.click();
	}
	
	public void selectPrivacyPolicyOption() {
		
		privacyPolicyField.click();
		
	}
	
	public WebDriver clickOnContinueButton() {
		
		continueButton.click();
		return driver;
	}
	
	
	
}
