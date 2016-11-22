package edu.fullerton.cpsc.cpscRecipe.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCController;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class LoginController implements CPSCController{

	@RequestMapping(value = RecipeMakerConstants.LOG_IN_THIS_USER, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return handelPost(request, response);
	}

	@RequestMapping(value = RecipeMakerConstants.LOG_IN_THIS_USER, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159767.mlab.com:59767/quickrecipemaker"); 
        MongoClient client = new MongoClient(uri);
        @SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase());
        if(db.getCollectionNames().contains(userName)){
        	DBCollection oneUserCollection = db.getCollection(userName);
        	BasicDBObject query = new BasicDBObject();
        	query.put("userName", userName);
        	query.put("password", password);
        	DBObject returnObj = oneUserCollection.findOne(query);
        	System.out.println(returnObj);
        }
        
		return RecipeMakerConstants.DASHBOARD_PAGE;
	}

}
