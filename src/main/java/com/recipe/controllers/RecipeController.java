package com.recipe.controllers;

import javax.servlet.http.HttpServletRequest;

import com.recipe.constants.RecipeFinderConstants;

public class RecipeController {
	
	protected Boolean isUserinSession(HttpServletRequest request){
		if(request.getSession().getAttribute(RecipeFinderConstants.USER_IN_SESSION) != null){
			return Boolean.TRUE;
		}else{
			return Boolean.FALSE;
		}		
	}

}
