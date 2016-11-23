package edu.fullerton.cpsc.cpscRecipe.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCController;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class LoginController implements CPSCController{

	@RequestMapping(value = RecipeMakerConstants.LOG_IN_THIS_USER, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, UserBean userBean,BindingResult result) throws Exception {
		return handelPost(request, userBean, result);
	}

	@RequestMapping(value = RecipeMakerConstants.LOG_IN_THIS_USER, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, UserBean userBean,BindingResult result) throws Exception {		
		MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159767.mlab.com:59767/quickrecipemaker"); 
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
        	System.out.println(returnObj);
        }
        
		return RecipeMakerConstants.DASHBOARD_PAGE;
	}

	public Object getValuesFromRequest(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserBean object = new UserBean(userName, password);
		return (UserBean)object;
	}

	public void setDefaultValues(HttpServletRequest request, BindingResult result) {
		// TODO Auto-generated method stub
		
	}

}
