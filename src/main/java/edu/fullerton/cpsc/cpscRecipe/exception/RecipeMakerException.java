package edu.fullerton.cpsc.cpscRecipe.exception;

import javax.servlet.http.HttpServletRequest;

public class RecipeMakerException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String throwErrorWithoutPage(HttpServletRequest request){
		return "error";
	}
}
