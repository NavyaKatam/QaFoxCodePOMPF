package util;

import java.io.FileReader;
import java.util.Date;
import java.util.Properties;

public class Utilities {
	

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

}
