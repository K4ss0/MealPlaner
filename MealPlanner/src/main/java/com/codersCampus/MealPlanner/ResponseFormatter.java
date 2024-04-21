package com.codersCampus.MealPlanner;

import com.codersCampus.MealPlanner.dto.DayResponse;
import com.codersCampus.MealPlanner.dto.Meal;
import com.codersCampus.MealPlanner.dto.Nutrients;
import com.codersCampus.MealPlanner.dto.WeekResponse;

import java.util.List;
import java.util.Map;

public class ResponseFormatter {

    public static String formatDayResponseAsHtml(DayResponse response) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><body>");
        htmlBuilder.append("<h1>Daily Meal Plan</h1>");

        List<Meal> meals = response.getMeals();
        Nutrients nutrients = response.getNutrients();

        htmlBuilder.append("<h2>Meals</h2>");
        htmlBuilder.append("<ul>");
        for (Meal meal : meals) {
            htmlBuilder.append("<li>").append(meal.getTitle()).append("</li>");
        }
        htmlBuilder.append("</ul>");

        htmlBuilder.append("<h2>Nutrients</h2>");
        htmlBuilder.append("<ul>");
        htmlBuilder.append("<li>Calories: ").append(nutrients.getCalories()).append("</li>");
        htmlBuilder.append("<li>Carbohydrates: ").append(nutrients.getCarbohydrates()).append("</li>");
        htmlBuilder.append("<li>Fat: ").append(nutrients.getFat()).append("</li>");
        htmlBuilder.append("<li>Protein: ").append(nutrients.getProtein()).append("</li>");
        htmlBuilder.append("</ul>");

        htmlBuilder.append("</body></html>");
        return htmlBuilder.toString();
    }

    public static String formatWeekResponseAsHtml(WeekResponse response) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html><body>");
        htmlBuilder.append("<h1>Weekly Meal Plan</h1>");

        Map<String, DayResponse> week = response.getWeek();

        for (Map.Entry<String, DayResponse> entry : week.entrySet()) {
            htmlBuilder.append("<h2>").append(entry.getKey()).append("</h2>");
            htmlBuilder.append(formatDayResponseAsHtml(entry.getValue()));
        }

        htmlBuilder.append("</body></html>");
        return htmlBuilder.toString();
    }
}
