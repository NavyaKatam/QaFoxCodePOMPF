package temp;

import java.io.FileReader;
import java.util.Properties;

public class PropFilesDemo {

	public static void main(String[] args) {
		
		Properties prop = null;
		
		try {
			prop = new Properties();
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\java\\temp\\experiment.properties");
			prop.load(fr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("name"));  // Arun Motoori
		System.out.println(prop.getProperty("experience")); // 18
		System.out.println(prop.getProperty("place")); // Hyderabad
		System.out.println(prop.getProperty("working")); // false

	}

}
