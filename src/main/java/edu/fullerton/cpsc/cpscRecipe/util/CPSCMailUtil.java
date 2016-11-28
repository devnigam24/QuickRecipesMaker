package edu.fullerton.cpsc.cpscRecipe.util;

import javax.servlet.http.HttpServletRequest;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;

public class CPSCMailUtil {
	
	protected void createMailBody(){
		
	}
	
	protected String createMailBodyForRecipe(RecipeBean recipe, HttpServletRequest request) {		
		String shareUrl = RecipeMakerConstants.APP_URL+"/"+RecipeMakerConstants.GUEST_RECIPE_SHOW+
				"?"+RecipeMakerConstants.RECIPE_NAME+"="+recipe.getRecipeName();
		return shareUrl;
	}

}
