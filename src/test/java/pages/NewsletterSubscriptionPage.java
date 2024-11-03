package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;
import util.Utilities;

public class NewsletterSubscriptionPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public NewsletterSubscriptionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='0']")
	private WebElement noNewsletterOption;
	
	public boolean isYesNewsletterOptionSelected() {
		return elementUtils.isElementInSelectedState(yesNewsletterOption,Utilities.EXPLICIT_WAIT_TIME);
	}
	
	public boolean isNoNewsletterOptionSelected() {
		return elementUtils.isElementInSelectedState(noNewsletterOption,Utilities.EXPLICIT_WAIT_TIME);
	}

}
