package ds_Group_Project;

import java.time.LocalDateTime;

public class DateTime {
	private LocalDateTime timestamp;
	
	//sets the date and time to the current date and time
	public DateTime() { timestamp = LocalDateTime.now(); }
	
	//Accessors
	public int GetYear() { return timestamp.getYear(); }
	public int GetMonth() { return timestamp.getMonthValue(); }
	public int GetDay() { return timestamp.getDayOfMonth(); }
	public int GetHour() { return timestamp.getHour(); }
	public int GetMinute() { return timestamp.getMinute(); }
	
	@Override
	public String toString() {
		return timestamp.getYear() + "/" + timestamp.getMonthValue() + "/" 
				+ timestamp.getDayOfMonth() + "  " + timestamp.getHour() 
				+ ":" + timestamp.getMinute();
	}
}
