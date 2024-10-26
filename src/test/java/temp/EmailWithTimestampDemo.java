package temp;

import java.util.Date;

public class EmailWithTimestampDemo {

	public String generateNewEmail() {
		
		Date date = new Date();
		String dateString = date.toString();
		String dateStringWithoutSpaces = dateString.replaceAll("\\s","");
		String dateStringWithoutSpacesAndColons = dateStringWithoutSpaces.replaceAll("\\:","");
		String emailWithTimestamp = dateStringWithoutSpacesAndColons+"@gmail.com";
		return emailWithTimestamp;

	}

}
