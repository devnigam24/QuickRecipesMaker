package edu.fullerton.cpsc.cpscRecipe.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
import edu.fullerton.cpsc.cpscRecipe.exception.RecipeMakerException;
import edu.fullerton.cpsc.cpscRecipe.interfaces.CPSCRecipeController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSC476Util;


@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class AddRecipeController extends RecipeClass implements CPSCRecipeController{
	@RequestMapping(value = RecipeMakerConstants.ADD_THIS_RECIPE, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception {
		return this.handelPost(request, recipe, result);
	}
	
	@RequestMapping(value = RecipeMakerConstants.ADD_THIS_RECIPE, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception {
		if (true){//this.validateFormFields(recipe, result)) {
			MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159737.mlab.com:59737/recipe"); 
	        MongoClient client = new MongoClient(uri);
	        @SuppressWarnings("deprecation")
			DB db = client.getDB(uri.getDatabase());
	        DBCollection oneUser = db.getCollection(recipe.getRecipeName());
	        BasicDBObject[] recipeJson = CPSC476Util.getJSONObjectFromRecipeBean(recipe);
	        oneUser.insert(recipeJson);
	        
	        
	        BasicDBObject query = new BasicDBObject();
	    	query.put(RecipeMakerConstants.RECIPE_NAME, recipe.getRecipeName());
	    	query.put(RecipeMakerConstants.RECIPE_CREATED_BY, recipe.getCreatedBy());
	    	DBObject returnObj = oneUser.findOne(query);
	    	String recipeId = returnObj.get(RecipeMakerConstants.UNIQUE_ID).toString();
	    	
	    	mapRecipeToUser(request,recipeId,(UserBean)request.getSession().getAttribute(RecipeMakerConstants.USER_IN_SESSION));
	        client.close();
	        request.setAttribute("myCustomMessage","recipeAdded");
	        return RecipeMakerConstants.ADD_RECIPE_URL;
		} else {
			this.setDefaultValues(request, result);
			return RecipeMakerException.throwErrorOnSpecificPageWithoutMessage(request,RecipeMakerConstants.HOME_PAGE_URL);
		}
	}

	private void mapRecipeToUser(HttpServletRequest request, String recipeId, UserBean userBean) {
		MongoClientURI uri = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159747.mlab.com:59747/user");
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient(uri);
		@SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase());
		DBCollection oneUserCollection = db.getCollection(userBean.getUserName());

		BasicDBObject query = new BasicDBObject();
		query.put(RecipeMakerConstants.USER_NAME, userBean.getUserName());
		int newCount = userBean.getCreateRecipeCount() + 1;
		ArrayList<String> createdRecipe = userBean.getCreatedRecipe();
		createdRecipe.add(recipeId);
		BasicDBObject update1 = new BasicDBObject("$set",
				new BasicDBObject(RecipeMakerConstants.USER_CREATED_RECIPE_COUNT, newCount));
		BasicDBObject update2 = new BasicDBObject("$set",
				new BasicDBObject(RecipeMakerConstants.USER_CREATED_RECIPE, createdRecipe));
		WriteResult obj1 = oneUserCollection.update(query, update1);
		WriteResult obj2 = oneUserCollection.update(query, update2);
		System.out.println(obj1.getN());
		System.out.println(obj2.getN());
		client.close();
		CPSC476Util.setValuesInRequest(request, userBean);
	}

}
