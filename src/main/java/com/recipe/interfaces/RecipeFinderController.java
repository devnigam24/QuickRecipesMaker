package com.recipe.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface RecipeFinderController {
	
	String handelGet(HttpServletRequest request);
	String handelPost(HttpServletRequest request);

}
