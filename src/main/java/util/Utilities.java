package util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int EXPLICIT_WAIT_TIME = 30;
	public static final int IMPLICIT_WAIT_TIME = 3;
	
	public static String generateNewEmail() {
		
		Date date = new Date();
		String dateString = date.toString();
		String dateStringWithoutSpaces = dateString.replaceAll("\\s","");
		String dateStringWithoutSpacesAndColons = dateStringWithoutSpaces.replaceAll("\\:","");
		String emailWithTimestamp = dateStringWithoutSpacesAndColons+"@gmail.com";
		return emailWithTimestamp;

	}
	
	public static Properties loadPropertiesFile() {
		
		Properties prop = null;
		
		try {
			prop = new Properties();
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ApplicationData.properties");
			prop.load(fr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	public static Object[][] getTestData(MyXLSReader xls_received, String testName, String sheetName) throws Exception{
		
		MyXLSReader xls = xls_received;
	
		String testCaseName = testName;
		
		String testDataSheet = sheetName;
		
		int testStartRowNumber=1;		
		
		while(!(xls.getCellData(testDataSheet, 1, testStartRowNumber).equals(testCaseName))){
			
			testStartRowNumber++;
			
		}
		
		int columnStartRowNumber = testStartRowNumber+1;
		int dataStartRowNumber = testStartRowNumber+2;
		
		int rows=0;
		while(!(xls.getCellData(testDataSheet, 1, dataStartRowNumber+rows).equals(""))){
			
			rows++;
			
		}
		
		//Total number of columns in the required test
		int columns=1;
		
		while(!(xls.getCellData(testDataSheet, columns, columnStartRowNumber).equals(""))){
			
			columns++;
			
		}
		
		Object[][] obj = new Object[rows][1];
		
		HashMap<String,String> map = null;
		
		//Reading the data in the test
		for(int i=0,row=dataStartRowNumber;row<dataStartRowNumber+rows;row++,i++){
			
			map = new HashMap<String,String>();
			
			for(int j=0,column=1;column<columns;column++,j++){
				
				String key=xls.getCellData(testDataSheet, column, columnStartRowNumber);
				
				String value=xls.getCellData(testDataSheet, column, row);
				
				map.put(key,value);
				
			}
			
			obj[i][0]=map;
		
		}	
		
		return obj;
	
	}
	
	public static String takeScreenshot(WebDriver driver,String testName) {
		
		TakesScreenshot tsDriver = (TakesScreenshot)driver;
		File screenshotFile = tsDriver.getScreenshotAs(OutputType.FILE);
		
		String screenshotFilePath = null;
		
		try {
			Properties prop = Utilities.loadPropertiesFile();
			screenshotFilePath = System.getProperty("user.dir")+prop.getProperty("screenshotsPath")+testName+".png";
			FileHandler.copy(screenshotFile,new File(screenshotFilePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return screenshotFilePath;
		
	}

}
