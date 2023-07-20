package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStamp {

	public static String addTimeStamp()
	{
		DateTimeFormatter formatedDateTime = DateTimeFormatter.ofPattern("ddMMYY_HHmmss");
		String timeStampString = LocalDateTime.now().format(formatedDateTime);
		
		return timeStampString;
	}
	
}
