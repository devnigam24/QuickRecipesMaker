package edu.fullerton.cpsc.cpscRecipe.exception;

import javax.servlet.http.HttpServletRequest;

import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;

public class RecipeMakerException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String throwErrorWithoutPage(HttpServletRequest request){
		return "error";
	}
	
	public static String throwErrorOnSpecificPage(HttpServletRequest request,String page,String errorMessage){
		request.setAttribute(RecipeMakerConstants.IS_FORM_VALIDATION_ERROR, Boolean.TRUE);
		request.setAttribute(RecipeMakerConstants.IS_FORM_VALIDATION_MESSAGE, errorMessage);
		request.setAttribute(RecipeMakerConstants.PAGE_FRAGMENT_TO_OPEN, page);
		return page;		
	}

	public static String throwErrorOnSpecificPageWithoutMessage(HttpServletRequest request, String page) {
		request.setAttribute(RecipeMakerConstants.IS_FORM_VALIDATION_ERROR, Boolean.TRUE);
		request.setAttribute(RecipeMakerConstants.PAGE_FRAGMENT_TO_OPEN, page);
		return page;
	}
}
