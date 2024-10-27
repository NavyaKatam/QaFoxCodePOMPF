package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import util.Utilities;

public class Base {
	
	public Properties prop;
	WebDriver driver;
	
	public Base() {
		prop = Utilities.loadPropertiesFile();
	}
	
	public WebDriver openApplicationURLIntheBrowser(String browserName) {
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}else if(browserName.equals("ie")){
			driver = new InternetExplorerDriver();
		}else if(browserName.equals("safari")) {
			driver = new SafariDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("appURL"));
		
		return driver;
		
	}

}
