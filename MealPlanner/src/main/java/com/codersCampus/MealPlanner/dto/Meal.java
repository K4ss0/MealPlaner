package com.codersCampus.MealPlanner.dto;

public class Meal {
	private String timeFrame;
	private int targetCalories;
	private String diet;
	private String exclude;
	public String getTimeFrame() {
		return timeFrame;
	}
	public void setTimeFrame(String timeFrame) {
		this.timeFrame = timeFrame;
	}
	public int getTargetCalories() {
		return targetCalories;
	}
	public void setTargetCalories(int targetCalories) {
		this.targetCalories = targetCalories;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	public String getExclude() {
		return exclude;
	}
	public void setExclude(String exclude) {
		this.exclude = exclude;
	}

}