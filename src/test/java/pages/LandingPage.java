package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;
import util.Utilities;

public class LandingPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void clickOnMyAccountDropMenu() {
		elementUtils.clickOnElement(myAccountDropMenu,Utilities.EXPLICIT_WAIT_TIME);
	}
	
	public RegisterPage selectRegisterOption() {
		elementUtils.clickOnElement(registerOption,Utilities.EXPLICIT_WAIT_TIME);
		return new RegisterPage(driver);
	}
	
	public LoginPage selectLoginOption() {
		elementUtils.clickOnElement(loginOption,Utilities.EXPLICIT_WAIT_TIME);
		return new LoginPage(driver);
	}
	
	public void enterSearhTerm(String searchTermText) {
		elementUtils.enterTextIntoElement(searchBoxField,Utilities.EXPLICIT_WAIT_TIME,searchTermText);
	}
	
	public SearchPage clickOnSearchButton() {
		elementUtils.clickOnElement(searchButton,Utilities.EXPLICIT_WAIT_TIME);
		return new SearchPage(driver);
	}

}
