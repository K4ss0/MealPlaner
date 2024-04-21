package com.codersCampus.MealPlanner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.codersCampus.MealPlanner.dto.DayResponse;
import com.codersCampus.MealPlanner.dto.WeekResponse;

@RestController
public class MealPlannerController {

	private final RestTemplate restTemplate;

	public MealPlannerController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/mealplanner/day")
	public ResponseEntity<String> getDayMeals(@RequestParam String targetCalories,
	                                          @RequestParam String diet,
	                                          @RequestParam String exclude) {
	    String url = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
	            .queryParam("apiKey", "3983e0cd9c7e4a3d8b494af19d77aaf1")
	            .queryParam("timeFrame", "day")
	            .queryParam("targetCalories", targetCalories)
	            .queryParam("diet", diet)
	            .queryParam("exclude", exclude)
	            .build()
	            .toUriString();

	    try {
	        DayResponse response = restTemplate.getForObject(url, DayResponse.class);
	        String htmlResponse = ResponseFormatter.formatDayResponseAsHtml(response);
	        return ResponseEntity.ok(htmlResponse);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}

	@GetMapping("/mealplanner/week")
	public ResponseEntity<String> getWeekMeals(@RequestParam String targetCalories,
	                                           @RequestParam String diet,
	                                           @RequestParam String exclude) {
	    String url = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
	            .queryParam("apiKey", "3983e0cd9c7e4a3d8b494af19d77aaf1")
	            .queryParam("timeFrame", "week")
	            .queryParam("targetCalories", targetCalories)
	            .queryParam("diet", diet)
	            .queryParam("exclude", exclude)
	            .build()
	            .toUriString();

	    try {
	        WeekResponse response = restTemplate.getForObject(url, WeekResponse.class);
	        String htmlResponse = ResponseFormatter.formatWeekResponseAsHtml(response);
	        return ResponseEntity.ok(htmlResponse);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
}