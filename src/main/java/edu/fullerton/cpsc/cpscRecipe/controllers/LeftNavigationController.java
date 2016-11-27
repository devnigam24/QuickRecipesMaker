package edu.fullerton.cpsc.cpscRecipe.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeClass;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.exception.RecipeMakerException;
import edu.fullerton.cpsc.cpscRecipe.interfaces.NavigationController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSC476Util;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class LeftNavigationController extends RecipeClass implements NavigationController{
	
	private static final Logger logger = Logger.getLogger(LeftNavigationController.class);
	
	@RequestMapping(value = RecipeMakerConstants.EDIT_PROFILE_URL, method = RequestMethod.GET)
	public String editThisProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.EDIT_PROFILE_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.ADD_RECIPE_URL, method = RequestMethod.GET)
	public String createNewRecipe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.ADD_RECIPE_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.RECIPE_SEARCH_URL, method = RequestMethod.GET)
	public String findThisRecipe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.RECIPE_SEARCH_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.GET_MY_CREATED_RECIPES, method = RequestMethod.GET)
	public String shareThisRecipe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.GET_MY_CREATED_RECIPES;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.GET_FOLLOWING_URL, method = RequestMethod.GET)
	public String getFollowers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.GET_FOLLOWING_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.RECIPE_DETAILS_FAV_URL, method = RequestMethod.GET)
	public String getFavoritesRecipe(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.RECIPE_DETAILS_FAV_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.LOGOUT, method = RequestMethod.GET)
	public String logut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		request.setAttribute(RecipeMakerConstants.CUSTOM_MESSAGE,"You have been successfully loggged out");
		return RecipeMakerConstants.HOME_PAGE_URL;
	}

}
