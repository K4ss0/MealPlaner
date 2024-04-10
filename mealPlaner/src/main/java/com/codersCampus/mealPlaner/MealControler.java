package com.codersCampus.mealPlaner;

import org.springframework.web.bind.annotation.GetMapping;

public class MealControler {

	
	@GetMapping("mealplanner/week")
	public ResponseEntitiy<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions)
	
	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions)
}
