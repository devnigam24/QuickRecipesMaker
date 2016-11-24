package edu.fullerton.cpsc.cpscRecipe.controllers;

import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.classes.SignUpLoginSuperClass;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSC476Util;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class SearchRecipeFromFormController extends SignUpLoginSuperClass {

	@RequestMapping(value = RecipeMakerConstants.SEARCH_RECIPE, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request) throws Exception {
		return this.handelPost(request);
	}

	@RequestMapping(value = RecipeMakerConstants.SEARCH_RECIPE, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request) throws Exception {
		String ingredientsList = request.getParameter(RecipeMakerConstants.INGREDIENTS_LIST);
		if (null == ingredientsList || ingredientsList.equals("")) {
			ingredientsList = "chicken,onions";
		}
		String calorieAmount = request.getParameter(RecipeMakerConstants.CALORIE_AMOUNT);
		if (null == calorieAmount || calorieAmount.equals("")) {
			calorieAmount = "gte 250";
		}
		String cookingTime = request.getParameter(RecipeMakerConstants.COOKING_TIME);
		if (null == cookingTime || cookingTime.equals("")) {
			cookingTime = "2";
		}

		String urlToHit = "https://api.edamam.com/search?q=" + URLEncoder.encode(ingredientsList, "UTF-8")
				+ "&calories=" + URLEncoder.encode(calorieAmount, "UTF-8")
				+ "&app_id=3e85c661&app_key=f9af7085b7825964d3ea39d7e33877ee&from=0&to=1";
		JSONObject recipeJson = new JSONObject(IOUtils.toString(new URL(urlToHit), Charset.forName("UTF-8")));
		request.setAttribute(RecipeMakerConstants.SEARCH_RECIPE_RESULT_ARRAYLIST,
				CPSC476Util.getRecipeArrayList(recipeJson));
		return RecipeMakerConstants.SEARCH_RECIPE_RESULT;
	}

}
