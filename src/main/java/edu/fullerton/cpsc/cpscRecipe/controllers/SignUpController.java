package edu.fullerton.cpsc.cpscRecipe.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.classes.SignUpSuperClass;
import edu.fullerton.cpsc.cpscRecipe.exception.RecipeMakerException;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSC476Util;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class SignUpController extends SignUpSuperClass implements CPSCController{

	@RequestMapping(value = RecipeMakerConstants.SIGN_UP_THIS_USER_URL, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request,UserBean userBean,BindingResult result) throws Exception {
		return this.handelPost(request, userBean, result);
	}
	
	@RequestMapping(value = RecipeMakerConstants.SIGN_UP_THIS_USER_URL, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request,UserBean userBean,BindingResult result) throws Exception {		
		if (this.validateFormFields(userBean, result)) {
			MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159767.mlab.com:59767/quickrecipemaker"); 
	        MongoClient client = new MongoClient(uri);
	        @SuppressWarnings("deprecation")
			DB db = client.getDB(uri.getDatabase());
	        DBCollection oneUser = db.getCollection(userBean.getUserName());
	        BasicDBObject[] userData = CPSC476Util.getJSONObjectFromUserBean(userBean);
	        oneUser.insert(userData);
	        client.close();
	        request.setAttribute(RecipeMakerConstants.USER_IN_SESSION, userData);
	        return RecipeMakerConstants.DASHBOARD_PAGE;
		} else {
			this.setDefaultValues(request, result);
			return RecipeMakerException.throwErrorOnSpecificPageWithoutMessage(request,RecipeMakerConstants.HOME_PAGE_URL);
		}
	}

	public Object getValuesFromRequest(HttpServletRequest request) {
		String userFirstName = request.getParameter(RecipeMakerConstants.USER_FIRST_NAME);
		String userLastName = request.getParameter(RecipeMakerConstants.USER_LAST_NAME);
		String userName = request.getParameter(RecipeMakerConstants.USER_NAME);
		String password = request.getParameter(RecipeMakerConstants.USER_PASSWORD);
		String userEmailID = request.getParameter(RecipeMakerConstants.USER_EMAIL_ID);
		UserBean object = new UserBean(userName, password, userFirstName, userLastName, userEmailID);
		return (UserBean)object;
	}

	

}
