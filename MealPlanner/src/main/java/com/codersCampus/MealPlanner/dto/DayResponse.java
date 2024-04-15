package com.codersCampus.MealPlanner.dto;

import java.util.List;

public class DayResponse {
	private List<Meal> meals;
	
	public List<Meal> getMeals() {
		return meals;
	}
	
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
}
