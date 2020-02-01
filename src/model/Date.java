package model;

import java.io.Serializable;

public class Date implements Serializable {
	
	int day, month, year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Date(String date) {
		String[] dt = date.split("[/-]");
		this.day = Integer.parseInt(dt[0]);
		this.month = Integer.parseInt(dt[1]);
		this.year = Integer.parseInt(dt[2]);
	}
	
	@Override
	public String toString() {
		return day + "/" + month + "/" + year; 
	}
}

