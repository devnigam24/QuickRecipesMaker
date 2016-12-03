/**
 * 
 */
package com.recipe.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.recipe.constants.RecipeFinderConstants;
import com.recipe.interfaces.RecipeFinderController;

/**
 * @author Devvrat Nigam
 *
 */
@Controller
@RequestMapping(RecipeFinderConstants.APP_URL)
public class DashBoardController extends RecipeController implements RecipeFinderController{

	@RequestMapping(value = RecipeFinderConstants.HOME_PAGE_URL, method = RequestMethod.GET)
	public String handelGet(HttpServletRequest request) {
		if(!isUserinSession(request)){
			return RecipeFinderConstants.HOME_PAGE_URL;
		}else{
			return RecipeFinderConstants.DASHBOARD_PAGE_URL; 
		}
	}

	@RequestMapping(value = RecipeFinderConstants.HOME_PAGE_URL, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request) {
		return this.handelGet(request);
	}
	
	
}