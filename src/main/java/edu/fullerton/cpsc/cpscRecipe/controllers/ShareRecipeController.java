package edu.fullerton.cpsc.cpscRecipe.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCRecipeController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSCMailUtil;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class ShareRecipeController{
	
	@RequestMapping(value = RecipeMakerConstants.SHARE_THIS_RECIPE, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception {
		return this.handelPost(request, recipe, result);
	}

	@RequestMapping(value = RecipeMakerConstants.SHARE_THIS_RECIPE, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception {
		String mailRecipient = request.getParameter("shareEmailId");
		if(null == recipe.getCreatedBy() || recipe.getCreatedBy().equals("")){
			recipe.setCreatedBy("EdmanApi");
		}		
		this.sendMail(mailRecipient,recipe,request);
		request.setAttribute(RecipeMakerConstants.CUSTOM_MESSAGE, "Mail Sent Successfully");
		return RecipeMakerConstants.DASHBOARD_PAGE_AJAX;
	}
	
	public void sendMail(String mailRecipient, RecipeBean recipe, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		CPSCMailUtil util = (CPSCMailUtil)ac.getBean("mailSenderClass");
		String queryString = util.getRecipeQueryString(recipe,request);
		String mmailMessage = "Your friend wants to share a recipe with you just click the below link!!\n\n\n";
		String urlToSend = mmailMessage + "https://quick-recipe-maker.herokuapp.com/app/guestRecipeShow?" + queryString;
		util.sendMail("quickerecipemaker@gmail.com", mailRecipient, "Qucik Recipe Maker", urlToSend);
	}
	
}
