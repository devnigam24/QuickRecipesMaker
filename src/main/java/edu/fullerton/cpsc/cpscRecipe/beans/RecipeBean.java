package edu.fullerton.cpsc.cpscRecipe.beans;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

public class RecipeBean {
	
	private String recipeName;
	private String imageUrl;
	private String moreInfoUrl;
	private ArrayList<String> ingredientsList;
	private ArrayList<String> dietLabels;
	private ArrayList<String> healthLabels;
	private Double calorieAmount;
	private String cookingTime;
	
	
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getMoreInfoUrl() {
		return moreInfoUrl;
	}
	public void setMoreInfoUrl(String moreInfoUrl) {
		this.moreInfoUrl = moreInfoUrl;
	}
	public ArrayList<String> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(ArrayList<String> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	public void setIngredientsList(JSONArray ingredientsList) throws JSONException {
		this.ingredientsList = new ArrayList<String>();
		for(int i=0;i<ingredientsList.length();i++)
			this.ingredientsList.add(ingredientsList.get(i).toString());
	}
	public ArrayList<String> getDietLabels() {
		return dietLabels;
	}
	public void setDietLabels(ArrayList<String> dietLabels) {
		this.dietLabels = dietLabels;
	}
	public void setDietLabels(JSONArray dietLabels) throws JSONException {
		this.dietLabels = new ArrayList<String>();
		for(int i=0;i<dietLabels.length();i++)
			this.dietLabels.add(dietLabels.get(i).toString());
	}
	public ArrayList<String> getHealthLabel() {
		return healthLabels;
	}
	public void setHealthLabel(ArrayList<String> healthLabel) {
		this.healthLabels = healthLabel;
	}
	public void setHealthLabel(JSONArray healthLabel) throws JSONException {
		this.healthLabels = new ArrayList<String>();
		for(int i=0;i<healthLabel.length();i++)
			this.healthLabels.add(healthLabel.get(i).toString());
	}
	public Double getCalorieAmount() {
		return calorieAmount;
	}
	public void setCalorieAmount(Double calorieAmount) {
		this.calorieAmount = calorieAmount;
	}
	public String getCookingTime() {
		return cookingTime;
	}
	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}
}
