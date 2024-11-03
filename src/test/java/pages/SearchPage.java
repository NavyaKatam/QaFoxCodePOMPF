package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;
import util.Utilities;

public class SearchPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductSearchMessage;
	
	public boolean isValidProductDisplayed() {
		return elementUtils.dispalyStatusOfElement(validProduct);
	}
	
	public String getNoProductSearchMessage() {
		return elementUtils.retrieveTextFromElement(noProductSearchMessage,Utilities.EXPLICIT_WAIT_TIME);
	}

}
