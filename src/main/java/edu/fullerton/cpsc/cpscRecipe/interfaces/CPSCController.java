/**
 * 
 */
package edu.fullerton.cpsc.cpscRecipe.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.fullerton.cpsc.cpscRecipe.exception.RecipeMakerException;

/**
 * @author Devvrat Nigam
 *
 */
public abstract interface CPSCController{
	
	/* 
	 * handles post request
	 */
	abstract String handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	/* 
	 * handles post request
	 */
	abstract String handelPost(HttpServletRequest request, HttpServletResponse response) throws Exception;

}