package com.codersCampus.MealPlanner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.codersCampus.MealPlanner.dto.DayResponse;
import com.codersCampus.MealPlanner.dto.WeekResponse;

@RestController
public class MealPlannerController {

	private final RestTemplate restTemplate;

	public MealPlannerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String timeFrame, String targetCalories, String diet,
			String exclude) {
		String url = "https://api.spoonacular.com/mealplanner/generate?apiKey=3983e0cd9c7e4a3d8b494af19d77aaf1&timeFrame=day"
				+ "&targetCalories=" + targetCalories + "&diet=" + diet + "&exclude=" + exclude;
		DayResponse response = restTemplate.getForObject(url, DayResponse.class);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String timeFrame, String targetCalories, String diet,
			String exclude) {
		String url = "https://api.spoonacular.com/mealplanner/generate?apiKey=3983e0cd9c7e4a3d8b494af19d77aaf1&timeFrame=week"
				 + "&targetCalories=" + targetCalories + "&diet=" + diet + "&exclude=" + exclude;
		WeekResponse Response = restTemplate.getForObject(url,WeekResponse.class);
		return ResponseEntity.ok(Response);
	}
}
