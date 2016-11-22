package edu.fullerton.cpsc.cpscRecipe.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSC476Util;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class SignUpController implements CPSCController{

	@RequestMapping(value = RecipeMakerConstants.SIGN_UP_THIS_USER_URL, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.handelPost(request, response);
	}
	
	@RequestMapping(value = RecipeMakerConstants.SIGN_UP_THIS_USER_URL, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userFirstName = request.getParameter("firstName");
		String userLastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String userEmailID = request.getParameter("email");
		
		if("".equals(userFirstName) && null == userFirstName){
			
		}
		UserBean thisUserBean = new UserBean(userName, password, userFirstName, userLastName, userEmailID);
		//mongodb://nimesh5:nimesh5@ds159767.mlab.com:59767/quickrecipemaker
		MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159767.mlab.com:59767/quickrecipemaker"); 
        MongoClient client = new MongoClient(uri);
        @SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase());
        DBCollection oneUser = db.getCollection(userName);
        BasicDBObject[] userData = CPSC476Util.getJSONObjectFromUserBean(thisUserBean);
        oneUser.insert(userData);
        client.close();
        return RecipeMakerConstants.DASHBOARD_PAGE;
	}

}
