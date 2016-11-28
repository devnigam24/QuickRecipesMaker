package edu.fullerton.cpsc.cpscRecipe.controllers;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
// [END simple_includes]

import java.io.UnsupportedEncodingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
// [END multipart_includes]

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCController;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCRecipeController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSCMailUtil;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class ShareRecipeController extends CPSCMailUtil implements CPSCRecipeController{
	
	private static final Logger logger = Logger.getLogger(DashBoardController.class);

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
		String mailBody = createMailBodyForRecipe(recipe,request);
		return null;
	}

	
	
	
}
