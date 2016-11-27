package edu.fullerton.cpsc.cpscRecipe.controllers;

import javax.servlet.http.HttpServletRequest;

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
import edu.fullerton.cpsc.cpscRecipe.classes.SignUpLoginSuperClass;
import edu.fullerton.cpsc.cpscRecipe.exception.RecipeMakerException;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCUserController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSC476Util;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class SignUpController extends SignUpLoginSuperClass implements CPSCUserController{

	@RequestMapping(value = RecipeMakerConstants.SIGN_UP_THIS_USER_URL, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request,UserBean userBean,BindingResult result) throws Exception {
		return this.handelPost(request, userBean, result);
	}
	
	@RequestMapping(value = RecipeMakerConstants.SIGN_UP_THIS_USER_URL, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request,UserBean userBean,BindingResult result) throws Exception {		
		if (this.validateFormFields(userBean, result)) {
			MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159747.mlab.com:59747/user"); 
	        MongoClient client = new MongoClient(uri);
	        @SuppressWarnings("deprecation")
			DB db = client.getDB(uri.getDatabase());
	        DBCollection oneUser = db.getCollection(userBean.getUserName());
	        final BasicDBObject[] UserData = { CPSC476Util.getJSONObjectFromUserBean(userBean) };
	        oneUser.insert(UserData);
	        client.close();
	        request.setAttribute(RecipeMakerConstants.USER_IN_SESSION, CPSC476Util.getUserBeanObjectFronJSON(CPSC476Util.getJSONObjectFromUserBean(userBean)));
			CPSC476Util.setValuesInRequest(request,CPSC476Util.getUserBeanObjectFronJSON(CPSC476Util.getJSONObjectFromUserBean(userBean)));
	        return RecipeMakerConstants.DASHBOARD_PAGE;
		} else {
			this.setDefaultValues(request, result);
			return RecipeMakerException.throwErrorOnSpecificPageWithoutMessage(request,RecipeMakerConstants.HOME_PAGE_URL);
		}
	}

	

}
