package edu.fullerton.cpsc.cpscRecipe.beans;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;

public class RecipeBean {

	private String recipeName;
	private String imageUrl;
	private String moreInfoUrl;
	private ArrayList<String> ingredientsList;
	private ArrayList<String> dietLabels;
	private ArrayList<String> healthLabels;
	private Double calorieAmount;
	private String cookingTime;
	private String createdBy;
	private String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCreatedBy() {
		if (null == createdBy || "".equals(createdBy)) {
			createdBy = "EdmanApi";
		}
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

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
		if (null == ingredientsList) {
			ingredientsList = new ArrayList<String>();
		}
		return ingredientsList;
	}

	public void setIngredientsList(ArrayList<String> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}

	public void setIngredientsList(JSONArray ingredientsList) throws JSONException {
		this.ingredientsList = new ArrayList<String>();
		for (int i = 0; i < ingredientsList.length(); i++)
			this.ingredientsList.add(ingredientsList.get(i).toString());
	}

	public ArrayList<String> getDietLabels() {
		if (null == dietLabels) {
			dietLabels = new ArrayList<String>();
		}
		return dietLabels;
	}

	public void setDietLabels(ArrayList<String> dietLabels) {
		this.dietLabels = dietLabels;
	}

	public void setDietLabels(JSONArray dietLabels) throws JSONException {
		this.dietLabels = new ArrayList<String>();
		for (int i = 0; i < dietLabels.length(); i++)
			this.dietLabels.add(dietLabels.get(i).toString());
	}

	public ArrayList<String> getHealthLabels() {
		if (null == healthLabels) {
			healthLabels = new ArrayList<String>();
		}
		return healthLabels;
	}

	public void setHealthLabels(ArrayList<String> healthLabel) {
		this.healthLabels = healthLabel;
	}

	public void setHealthLabels(JSONArray healthLabel) throws JSONException {
		this.healthLabels = new ArrayList<String>();
		for (int i = 0; i < healthLabel.length(); i++)
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
