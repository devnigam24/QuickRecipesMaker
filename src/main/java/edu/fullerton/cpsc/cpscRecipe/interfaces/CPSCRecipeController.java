/**
 * 
 */
package edu.fullerton.cpsc.cpscRecipe.interfaces;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;

/**
 * @author Devvrat Nigam
 *
 */
public abstract interface CPSCRecipeController {

	/*
	 * handles post request
	 */
	abstract String handleGet(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception;

	/*
	 * handles post request
	 */
	abstract String handelPost(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception;

}
