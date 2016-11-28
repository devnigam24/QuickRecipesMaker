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
import com.mongodb.WriteResult;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.exception.RecipeMakerException;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCUserController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSCUtil;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class UpdateProfileController implements CPSCUserController{
	
	@RequestMapping(value = RecipeMakerConstants.UPDATE_PROFILE, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, UserBean userBean, BindingResult result) throws Exception {
		return this.handelPost(request, userBean, result);
	}
	
	@RequestMapping(value = RecipeMakerConstants.UPDATE_PROFILE, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, UserBean userBean, BindingResult result) throws Exception {		
		MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159747.mlab.com:59747/user"); 
        @SuppressWarnings("resource")
		MongoClient client = new MongoClient(uri);
        @SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase());
        if(db.getCollectionNames().contains(userBean.getUserName())){
        	DBCollection oneUserCollection = db.getCollection(userBean.getUserName());
        	BasicDBObject query = new BasicDBObject();
        	query.put(RecipeMakerConstants.USER_NAME, userBean.getUserName());
        	BasicDBObject update1 = new BasicDBObject("$set",new BasicDBObject(RecipeMakerConstants.USER_FIRST_NAME,userBean.getUserFirstName()));
        	BasicDBObject update2 = new BasicDBObject("$set",new BasicDBObject(RecipeMakerConstants.USER_LAST_NAME,userBean.getUserLastName()));
        	BasicDBObject update3 = new BasicDBObject("$set",new BasicDBObject(RecipeMakerConstants.USER_EMAIL_ID,userBean.getUserEmailID()));
        	BasicDBObject update4 = new BasicDBObject("$set",new BasicDBObject(RecipeMakerConstants.USER_ABOUT_ME,userBean.getAboutMe()));
        	BasicDBObject update5 = new BasicDBObject("$set",new BasicDBObject(RecipeMakerConstants.USER_PASSWORD,userBean.getPassword()));
        	WriteResult obj1 = oneUserCollection.update(query, update1);
        	WriteResult obj2 = oneUserCollection.update(query, update2);
        	WriteResult obj3 = oneUserCollection.update(query, update3);
        	WriteResult obj4 = oneUserCollection.update(query, update4);
        	WriteResult obj5 = oneUserCollection.update(query, update5);
        	client.close();
        	CPSCUtil.setValuesInRequest(request, userBean);
        	request.getSession().setAttribute(RecipeMakerConstants.USER_IN_SESSION, userBean);
	        return RecipeMakerConstants.EDIT_PROFILE_URL;
		} else {
			return RecipeMakerException.throwErrorOnSpecificPageWithoutMessage(request,RecipeMakerConstants.HOME_PAGE_URL);
		}
	}

}
