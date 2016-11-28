package edu.fullerton.cpsc.cpscRecipe.util;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;

public class CPSCMailUtil {
	
	private MailSender mymailSender;
	
	public void setMymailSender(MailSender mymailSender) {
		this.mymailSender = mymailSender;
	}

	public String getRecipeQueryString(RecipeBean recipe, HttpServletRequest request) {		
		String shareUrl = RecipeMakerConstants.RECIPE_NAME+"="+recipe.getRecipeName()+"&"
				 +RecipeMakerConstants.IMAGE_URL+"="+recipe.getImageUrl()+"&"
				 +RecipeMakerConstants.MORE_INF_OURL+"="+recipe.getMoreInfoUrl()+"&"
				 +RecipeMakerConstants.INGREDIENTS_LIST+"="+recipe.getIngredientsList()+"&"
				 +RecipeMakerConstants.DIET_LABELS+"="+recipe.getDietLabels()+"&"
				 +RecipeMakerConstants.HEALTH_LABEL+"="+recipe.getHealthLabels()+"&"
				 +RecipeMakerConstants.COOKING_TIME+"="+recipe.getCookingTime()+"&"
				 +RecipeMakerConstants.CALORIE_AMOUNT+"="+recipe.getCalorieAmount()+"&"
				 +RecipeMakerConstants.RECIPE_CREATED_BY+"="+recipe.getCreatedBy()+"&"
				 +RecipeMakerConstants.UNIQUE_ID+"="+recipe.get_id();
		return shareUrl;
	}
	
	public void sendMail(String from, String to, String subject, String msg) throws MessagingException {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mymailSender.send(message);
	}
}
