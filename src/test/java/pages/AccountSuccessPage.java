package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
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
		
		return logoutOption.isDisplayed();
	}
	
	public boolean isAccountSuccessPageDisplayed() {
		
		return accountSuccessBreadcrumbOption.isDisplayed();
	}
	
	public String getProperContentDisplayed() {
		
		
		return successPageContent.getText();
		
	}
	
	public WebDriver clickOnContinueButton() {
		
		continueButton.click();
		return driver;
	}

}
