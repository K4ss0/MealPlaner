package com.codersCampus.MealPlanner.dto;

public class Nutrients {
	private double calories;
	private double carbohydrates;
	private double fat;
	private double protein;

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	@Override
	public String toString() {
		return "Nutrients{" + "calories=" + calories + ", carbohydrates=" + carbohydrates + ", fat=" + fat
				+ ", protein=" + protein + '}';
	}

}