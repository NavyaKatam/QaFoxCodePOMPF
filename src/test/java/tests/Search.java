package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.LandingPage;
import pages.SearchPage;

public class Search extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver = openApplicationURLIntheBrowser(prop.getProperty("browser"));
	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifySearchWithExistingProduct() {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterSearhTerm(prop.getProperty("validProductSearchKey"));
		driver = landingPage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(!searchPage.isValidProductDisplayed());
		
	}
	
	@Test(priority=2,dependsOnMethods="verifySearchWithExistingProduct")
	public void verifySearchWithNonExistingProduct() {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.enterSearhTerm(prop.getProperty("nonExisitingProductSearchKey"));
		driver = landingPage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		String expectedNoProductMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getNoProductSearchMessage(),expectedNoProductMessage);
		
	}
	
	@Test(priority=3)
	public void verifySearchWithoutEnteringAnyProduct() {
		
		int i=5;
		
		if(i==5) {
			throw new SkipException("Test got skipped as the value of i got 5");
		}
		
		LandingPage landingPage = new LandingPage(driver);
		driver = landingPage.clickOnSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		String expectedNoProductMessage = "There is no product that matches the search criteria.";
		Assert.assertEquals(searchPage.getNoProductSearchMessage(),expectedNoProductMessage);
		
	}

}
