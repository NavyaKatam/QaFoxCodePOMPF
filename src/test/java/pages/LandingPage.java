package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
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
		myAccountDropMenu.click();
	}
	
	public WebDriver selectRegisterOption() {
		registerOption.click();
		return driver;
	}
	
	public WebDriver selectLoginOption() {
		loginOption.click();
		return driver;
	}
	
	public void enterSearhTerm(String searchTermText) {
		searchBoxField.sendKeys(searchTermText);
	}
	
	public WebDriver clickOnSearchButton() {
		searchButton.click();
		return driver;
	}

}
