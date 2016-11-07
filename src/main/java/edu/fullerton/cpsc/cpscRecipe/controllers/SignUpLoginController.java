package edu.fullerton.cpsc.cpscRecipe.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCController;

@Controller
@RequestMapping(RecipeMakerConstants.SIGNUP_LOGIN_CONTROLLER_URL)
public class SignUpLoginController implements CPSCController{

	public String handleGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String handelPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
