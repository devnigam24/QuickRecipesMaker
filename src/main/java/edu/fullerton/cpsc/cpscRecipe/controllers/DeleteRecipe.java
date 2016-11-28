package edu.fullerton.cpsc.cpscRecipe.controllers;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeClass;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCRecipeController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSCUtil;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class DeleteRecipe extends RecipeClass implements CPSCRecipeController{
	
	private static final Logger logger = Logger.getLogger(LeftNavigationController.class);
	
	@RequestMapping(value = RecipeMakerConstants.DELETE_THIS_RECIPE, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception {
		return this.handelPost(request, recipe, result);
	}

	@RequestMapping(value = RecipeMakerConstants.DELETE_THIS_RECIPE, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception {
		String userName = request.getParameter(RecipeMakerConstants.USER_NAME);
		MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159747.mlab.com:59747/user"); 
        @SuppressWarnings("resource")
		MongoClient client = new MongoClient(uri);
        @SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase());
        if(db.getCollectionNames().contains(userName)){
        	DBCollection oneUserCollection = db.getCollection(userName);
        	BasicDBObject query = new BasicDBObject();
        	query.put(RecipeMakerConstants.USER_NAME, userName);
        	DBObject returnObj = oneUserCollection.findOne(query);
        	ArrayList<String> createdRecipeList = (ArrayList<String>)returnObj.get(RecipeMakerConstants.USER_CREATED_RECIPE);
        	int createdRecipeCount = (Integer) returnObj.get(RecipeMakerConstants.USER_CREATED_RECIPE_COUNT) - 1;
        	String recipeId = request.getParameter(RecipeMakerConstants.RECIPE_TO_DELETE);
    		createdRecipeList.remove(recipeId);
    		BasicDBObject update1 = new BasicDBObject("$set",new BasicDBObject(RecipeMakerConstants.USER_CREATED_RECIPE,createdRecipeList));
    		BasicDBObject update2 = new BasicDBObject("$set",new BasicDBObject(RecipeMakerConstants.USER_CREATED_RECIPE_COUNT,createdRecipeCount));
    		WriteResult obj1 = oneUserCollection.update(query, update1);
    		WriteResult obj2 = oneUserCollection.update(query, update2);
    		client.close();
    		UserBean ub = (UserBean)request.getSession().getAttribute(RecipeMakerConstants.USER_IN_SESSION);
    		if(ub.getUserName().equals(userName)){
    			ub.setCreatedRecipe(createdRecipeList);
    			ub.setCreateRecipeCount(createdRecipeCount);
    		}
    		request.getSession().setAttribute(RecipeMakerConstants.USER_IN_SESSION,ub);
    		CPSCUtil.setValuesInRequest(request, ub);
    		request.setAttribute(RecipeMakerConstants.CREATED_RECIPES_LIST, fetchAllRecipeOfUser(createdRecipeList));
        }
        return RecipeMakerConstants.GET_MY_CREATED_RECIPES;
	}

	
}
