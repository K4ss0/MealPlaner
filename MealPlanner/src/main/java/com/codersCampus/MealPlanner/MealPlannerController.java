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
	    public ResponseEntity<DayResponse> getDayMeals(@RequestParam String targetCalories, @RequestParam String diet, @RequestParam String exclude) {
	        String url = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
	                .queryParam("apiKey", "3983e0cd9c7e4a3d8b494af19d77aaf1")
	                .queryParam("timeFrame", "day")
	                .queryParam("targetCalories", "1500")
	                .queryParam("diet", "ketogenic")
	                .queryParam("exclude", "shellfish")
	                .build()
	                .toUriString();

	        try {
	            DayResponse response = restTemplate.getForObject(url, DayResponse.class);
	            System.out.println("Day Response: " + response);
	            return ResponseEntity.ok(response);
	        } catch (Exception e) {
	            // Handle exceptions
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    @GetMapping("/mealplanner/week")
	    public ResponseEntity<WeekResponse> getWeekMeals(@RequestParam String targetCalories, @RequestParam String diet, @RequestParam String exclude) {
	        String url = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
	                .queryParam("apiKey", "3983e0cd9c7e4a3d8b494af19d77aaf1")
	                .queryParam("timeFrame", "week")
	                .queryParam("targetCalories", "6000")
	                .queryParam("diet", "ketogenic")
	                .queryParam("exclude", "shellfish")
	                .build()
	                .toUriString();

	        try {
	            WeekResponse response = restTemplate.getForObject(url, WeekResponse.class);
	            System.out.println("Week Response: " + response);
	            return ResponseEntity.ok(response);
	        } catch (Exception e) {
	            // Handle exceptions
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	}