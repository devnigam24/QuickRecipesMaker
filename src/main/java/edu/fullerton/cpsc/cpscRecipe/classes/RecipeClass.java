package edu.fullerton.cpsc.cpscRecipe.classes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.util.CPSC476Util;

public class RecipeClass {

		void message(String message){
			System.out.println(message);
		}

		public Boolean checkPreConditions(HttpServletRequest request) {
			CPSC476Util.setValuesInRequest(request, (UserBean)request.getSession().getAttribute(RecipeMakerConstants.USER_IN_SESSION));
			return Boolean.TRUE;
		}
		
		public void setDefaultValues(HttpServletRequest request,BindingResult result){
			
		}
}
