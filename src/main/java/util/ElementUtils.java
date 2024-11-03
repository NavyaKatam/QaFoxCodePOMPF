package util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element,int durationInSeconds) {
		
		WebElement webElement = waitForAnElementToBeClickable(element,durationInSeconds);
		webElement.click();
		
	}
	
	public WebElement waitForAnElementToBeClickable(WebElement element,int durationInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(element)); 
		
	}
	
    public WebElement waitForAnElementToBeVisible(WebElement element,int durationInSeconds) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		return wait.until(ExpectedConditions.visibilityOf(element)); 
		
	}
	
	public void enterTextIntoElement(WebElement element,int durationInSeconds,String textToBeEntered) {
		
		WebElement webElement = waitForAnElementToBeClickable(element,durationInSeconds);
		webElement.click();
		webElement.sendKeys(textToBeEntered);
		
	}
	
	public boolean dispalyStatusOfElement(WebElement element) {
		
		return element.isDisplayed();
		
	}
	
	public String retrieveTextFromElement(WebElement element,int durationInSeconds) {
		
		WebElement webElement = waitForAnElementToBeVisible(element,durationInSeconds);
		return webElement.getText();
		
	}
	
	public boolean isElementInSelectedState(WebElement element,int durationInSeconds) {
		
		WebElement webElement = waitForAnElementToBeVisible(element,durationInSeconds);
		return webElement.isSelected();
		
	}
		
	
}
