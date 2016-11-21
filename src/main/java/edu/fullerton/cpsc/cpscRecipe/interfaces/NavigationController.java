package edu.fullerton.cpsc.cpscRecipe.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface NavigationController {

	abstract String editThisProfile(HttpServletRequest request, HttpServletResponse response) throws Exception;

	abstract String createNewRecipe(HttpServletRequest request, HttpServletResponse response) throws Exception;

	abstract String findThisRecipe(HttpServletRequest request, HttpServletResponse response) throws Exception;

	abstract String shareThisRecipe(HttpServletRequest request, HttpServletResponse response) throws Exception;

	abstract String getFollowers(HttpServletRequest request, HttpServletResponse response) throws Exception;

	abstract String getFavoritesRecipe(HttpServletRequest request, HttpServletResponse response) throws Exception;

	abstract String logut(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
