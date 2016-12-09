package edu.fullerton.cpsc.cpscRecipe.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.classes.SignUpLoginSuperClass;
import edu.fullerton.cpsc.cpscRecipe.exception.RecipeMakerException;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCUserController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSCUtil;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class LoginController extends SignUpLoginSuperClass implements CPSCUserController{

	@RequestMapping(value = RecipeMakerConstants.LOG_IN_THIS_USER, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, UserBean userBean,BindingResult result) throws Exception {
		return handelPost(request, userBean, result);
	}

	@RequestMapping(value = RecipeMakerConstants.LOG_IN_THIS_USER, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, UserBean userBean,BindingResult result) throws Exception {		
		MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159747.mlab.com:59747/user"); 
        @SuppressWarnings("resource")
		MongoClient client = new MongoClient(uri);
        @SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase());
        if(db.getCollectionNames().contains(userBean.getUserName())){
        	DBCollection oneUserCollection = db.getCollection(userBean.getUserName());
        	BasicDBObject query = new BasicDBObject();
        	query.put("userName", userBean.getUserName());
        	query.put("password", userBean.getPassword());
        	DBObject returnObj = oneUserCollection.findOne(query);
        	if(returnObj != null){
        		userBean = CPSCUtil.getUserBeanObjectFronJSON(returnObj);
        		client.close();
            	request.getSession().setAttribute(RecipeMakerConstants.USER_IN_SESSION, userBean);
            	CPSCUtil.setValuesInRequest(request, userBean);
    	        return RecipeMakerConstants.DASHBOARD_PAGE;
        	}else{
        		request.setAttribute("myCustomMessage", "Username not found in system You need to sign up first!!");
        		client.close();
    	        return RecipeMakerConstants.HOME_PAGE_URL;
        	}
        	
		} else {
			request.setAttribute("myCustomMessage", "Username not found in system You need to sign up first!!");
			return RecipeMakerException.throwErrorOnSpecificPageWithoutMessage(request,RecipeMakerConstants.HOME_PAGE_URL);
		}
        
	}

}
