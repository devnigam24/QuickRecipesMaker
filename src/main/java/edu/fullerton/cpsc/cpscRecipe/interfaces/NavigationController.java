package edu.fullerton.cpsc.cpscRecipe.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface NavigationController {

	abstract String editThisProfile(HttpServletRequest request) throws Exception;

	abstract String createNewRecipe(HttpServletRequest request) throws Exception;

	abstract String findThisRecipe(HttpServletRequest request) throws Exception;

	abstract String shareThisRecipe(HttpServletRequest request) throws Exception;

	abstract String getFollowers(HttpServletRequest request) throws Exception;

	abstract String getFavoritesRecipe(HttpServletRequest request) throws Exception;

	abstract String logut(HttpServletRequest request) throws Exception;

}
