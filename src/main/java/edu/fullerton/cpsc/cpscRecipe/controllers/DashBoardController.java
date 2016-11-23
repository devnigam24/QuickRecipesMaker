/**
 * 
 */
package edu.fullerton.cpsc.cpscRecipe.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeClass;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.exception.RecipeMakerException;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCController;

/**
 * @author Devvrat Nigam
 *
 */
@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class DashBoardController extends RecipeClass implements CPSCController{

	private static final Logger logger = Logger.getLogger(DashBoardController.class);
	
	@RequestMapping(value = RecipeMakerConstants.HOME_PAGE_URL, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, UserBean userBean,BindingResult result) throws Exception {
		logger.log(Level.INFO, "handleGet enterd Successfully" );
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.HOME_PAGE_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
		
	}
	
	@RequestMapping(value = RecipeMakerConstants.HOME_PAGE_URL, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request,UserBean userBean,BindingResult result) throws Exception {
		return null;
	}

	public Object getValuesFromRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDefaultValues(HttpServletRequest request, BindingResult result) {
		// TODO Auto-generated method stub
		
	}
	
}
