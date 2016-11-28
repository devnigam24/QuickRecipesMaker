package edu.fullerton.cpsc.cpscRecipe.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCRecipeController;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class PublicRecipeShow implements CPSCRecipeController{

	@RequestMapping(value = RecipeMakerConstants.GUEST_RECIPE_SHOW, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, RecipeBean rb, BindingResult result) throws Exception {		
		rb.set_id(request.getParameter(RecipeMakerConstants.UNIQUE_ID));
		rb.setCreatedBy(request.getParameter(RecipeMakerConstants.RECIPE_CREATED_BY));
		rb.setRecipeName(request.getParameter(RecipeMakerConstants.RECIPE_NAME));
		rb.setImageUrl(request.getParameter(RecipeMakerConstants.IMAGE_URL));
		rb.setMoreInfoUrl(request.getParameter(RecipeMakerConstants.MORE_INF_OURL));
		/*rb.setIngredientsList(request.getParameter(RecipeMakerConstants.INGREDIENTS_LIST));
		rb.setDietLabels(request.getParameter(RecipeMakerConstants.DIET_LABELS)));
		rb.setHealthLabels(request.getParameter(RecipeMakerConstants.HEALTH_LABEL));*/
		if(null != request.getParameter(RecipeMakerConstants.CALORIE_AMOUNT))
		rb.setCalorieAmount(Double.parseDouble(request.getParameter(RecipeMakerConstants.CALORIE_AMOUNT)));
	    rb.setCookingTime(request.getParameter(RecipeMakerConstants.COOKING_TIME));
	    ArrayList<RecipeBean> searchRecipeResultArrayList = new ArrayList<RecipeBean>();
	    searchRecipeResultArrayList.add(rb);
		request.setAttribute(RecipeMakerConstants.SEARCH_RECIPE_RESULT_ARRAYLIST,searchRecipeResultArrayList);
		return RecipeMakerConstants.TOP_SEARCH_RECIPE;
	}

	@RequestMapping(value = RecipeMakerConstants.GUEST_RECIPE_SHOW, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception {
		return this.handleGet(request, recipe, result);
	}
	
	

}
