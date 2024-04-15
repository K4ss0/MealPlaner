package com.codersCampus.MealPlanner.dto;

import java.util.List;

public class WeekResponse {
	private List<DayResponse> days;
	
	public List<DayResponse> getDays(){
		return days;	
	}
	
	public void setDays(List<DayResponse> days) {
		this.days = days;
	}

}
