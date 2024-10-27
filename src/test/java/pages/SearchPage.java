package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductSearchMessage;
	
	public boolean isValidProductDisplayed() {
		return validProduct.isDisplayed();
	}
	
	public String getNoProductSearchMessage() {
		return noProductSearchMessage.getText();
	}

}
