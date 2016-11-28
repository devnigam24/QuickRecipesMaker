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
import edu.fullerton.cpsc.cpscRecipe.util.CPSCUtil;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class FavouriteUnFavouriteController extends RecipeClass implements CPSCRecipeController{
	
	@RequestMapping(value = RecipeMakerConstants.FAVOURITE_UNFAVOURITE_ACTION, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception {
		return this.handelPost(request, recipe, result);
	}
	
	@RequestMapping(value = RecipeMakerConstants.FAVOURITE_UNFAVOURITE_ACTION, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request, RecipeBean recipe, BindingResult result) throws Exception {
		if (true) {// this.validateFormFields(recipe, result)) {
			if (request.getParameter("action").equals("searchResults")) {
				MongoClientURI uri = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159737.mlab.com:59737/recipe");
				MongoClient client = new MongoClient(uri);
				@SuppressWarnings("deprecation")
				DB db = client.getDB(uri.getDatabase());
				DBCollection oneUser = db.getCollection(recipe.getRecipeName());
				BasicDBObject[] recipeJson = CPSCUtil.getJSONObjectFromRecipeBean(recipe);
				oneUser.insert(recipeJson);

				BasicDBObject query = new BasicDBObject();
				query.put(RecipeMakerConstants.RECIPE_NAME, recipe.getRecipeName());
				query.put(RecipeMakerConstants.RECIPE_CREATED_BY, recipe.getCreatedBy());
				DBObject returnObj = oneUser.findOne(query);
				String recipeId = returnObj.get(RecipeMakerConstants.UNIQUE_ID).toString();

				mapRecipeToUserFavouriteList(request, recipeId,
						(UserBean) request.getSession().getAttribute(RecipeMakerConstants.USER_IN_SESSION));
				client.close();
				request.setAttribute("myCustomMessage", "recipeAdded");
				LeftNavigationController obj = new LeftNavigationController();
				return obj.getFavoritesRecipe(request);
			} else if (request.getParameter("action").equals("favourite")) {
				MongoClientURI uri = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159737.mlab.com:59737/recipe");
				MongoClient client = new MongoClient(uri);
				@SuppressWarnings("deprecation")
				DB db = client.getDB(uri.getDatabase());
				DBCollection oneUser = db.getCollection(recipe.getRecipeName());

				BasicDBObject query = new BasicDBObject();
				query.put(RecipeMakerConstants.RECIPE_NAME, recipe.getRecipeName());
				query.put(RecipeMakerConstants.RECIPE_CREATED_BY, recipe.getCreatedBy());
				DBObject returnObj = oneUser.findOne(query);
				String recipeId = returnObj.get(RecipeMakerConstants.UNIQUE_ID).toString();

				mapRecipeToUserFavouriteList(request, recipeId,
						(UserBean) request.getSession().getAttribute(RecipeMakerConstants.USER_IN_SESSION));
				client.close();
				request.setAttribute("myCustomMessage", "recipeAdded");
				LeftNavigationController obj = new LeftNavigationController();
				return obj.getFavoritesRecipe(request);
			} else if (request.getParameter("action").equals("unfavourite")) {
				String userName = (String) request.getParameter(RecipeMakerConstants.USER_NAME);
				MongoClientURI uri = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159747.mlab.com:59747/user");
				@SuppressWarnings("resource")
				MongoClient client = new MongoClient(uri);
				@SuppressWarnings("deprecation")
				DB db = client.getDB(uri.getDatabase());
				if (db.getCollectionNames().contains(userName)) {
					DBCollection oneUserCollection = db.getCollection(userName);
					BasicDBObject query = new BasicDBObject();
					query.put(RecipeMakerConstants.USER_NAME, userName);
					DBObject returnObj = oneUserCollection.findOne(query);
					ArrayList<String> createdRecipeList = (ArrayList<String>) returnObj
							.get(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_LIST);
					int createdRecipeCount = (Integer) returnObj.get(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_COUNT)
							- 1;
					String recipeId = request.getParameter(RecipeMakerConstants.RECIPE_TO_DELETE);
					createdRecipeList.remove(recipeId);
					BasicDBObject update1 = new BasicDBObject("$set",
							new BasicDBObject(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_LIST, createdRecipeList));
					BasicDBObject update2 = new BasicDBObject("$set",
							new BasicDBObject(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_COUNT, createdRecipeCount));
					WriteResult obj1 = oneUserCollection.update(query, update1);
					WriteResult obj2 = oneUserCollection.update(query, update2);
					client.close();
					UserBean ub = (UserBean) request.getSession().getAttribute(RecipeMakerConstants.USER_IN_SESSION);
					if (ub.getUserName().equals(userName)) {
						ub.setFavouriteRecipeList(createdRecipeList);
						ub.setFavouriteRecipeCount(createdRecipeCount);
					}
					request.getSession().setAttribute(RecipeMakerConstants.USER_IN_SESSION, ub);
					CPSCUtil.setValuesInRequest(request, ub);
					request.setAttribute(RecipeMakerConstants.CREATED_RECIPES_LIST,
							fetchAllRecipeOfUser(createdRecipeList));
					return RecipeMakerConstants.RECIPE_FAV_LIST;
				}
			}else if(request.getParameter("action").equals("signUp")){
				request.setAttribute(RecipeMakerConstants.CUSTOM_MESSAGE, "Guest Users are not authorised!! You need to create an account or Log in!!");
				return RecipeMakerConstants.TOP_SEARCH_RECIPE;
			}
		} else {
			this.setDefaultValues(request, result);
			return RecipeMakerException.throwErrorOnSpecificPageWithoutMessage(request,
					RecipeMakerConstants.HOME_PAGE_URL);
		}
		return null;

	}

	private void mapRecipeToUserFavouriteList(HttpServletRequest request, String recipeId, UserBean userBean) {
		MongoClientURI uri = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159747.mlab.com:59747/user");
		@SuppressWarnings("resource")
		MongoClient client = new MongoClient(uri);
		@SuppressWarnings("deprecation")
		DB db = client.getDB(uri.getDatabase());
		DBCollection oneUserCollection = db.getCollection(userBean.getUserName());

		BasicDBObject query = new BasicDBObject();
		query.put(RecipeMakerConstants.USER_NAME, userBean.getUserName());
		int newCount = userBean.getFavouriteRecipeCount() + 1;
		ArrayList<String> createdRecipe = userBean.getFavouriteRecipeList();
		createdRecipe.add(recipeId);
		BasicDBObject update1 = new BasicDBObject("$set",
				new BasicDBObject(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_COUNT, newCount));
		BasicDBObject update2 = new BasicDBObject("$set",
				new BasicDBObject(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_LIST, createdRecipe));
		WriteResult obj1 = oneUserCollection.update(query, update1);
		WriteResult obj2 = oneUserCollection.update(query, update2);
		System.out.println(obj1.getN());
		System.out.println(obj2.getN());
		client.close();
		CPSCUtil.setValuesInRequest(request, userBean);		
	}

}
