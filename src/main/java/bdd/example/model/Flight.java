package bdd.example.model;

import java.util.Calendar;

public class Flight {

	private Calendar datetime;

	public Flight(Calendar datetime) {
		Calendar newCalendar = Calendar.getInstance();
		newCalendar.setTime(datetime.getTime());
		this.datetime = newCalendar;
	}

	public Calendar getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Calendar datetime) {
		this.datetime = datetime;
	}

}
