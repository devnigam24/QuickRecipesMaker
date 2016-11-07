package edu.fullerton.cpsc.cpscRecipe.classes;

import javax.servlet.http.HttpServletRequest;

public class RecipeClass {

		void message(String message){
			System.out.println(message);
		}

		public Boolean checkPreConditions(HttpServletRequest request) {
			return Boolean.TRUE;
		}
}
