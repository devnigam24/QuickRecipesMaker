package edu.fullerton.cpsc.cpscRecipe.controllers;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeClass;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.exception.RecipeMakerException;
import edu.fullerton.cpsc.cpscRecipe.interfaces.NavigationController;
import edu.fullerton.cpsc.cpscRecipe.util.CPSCUtil;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class LeftNavigationController extends RecipeClass implements NavigationController{
	
	private static final Logger logger = Logger.getLogger(LeftNavigationController.class);
	
	@RequestMapping(value = RecipeMakerConstants.EDIT_PROFILE_URL, method = RequestMethod.GET)
	public String editThisProfile(HttpServletRequest request) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.EDIT_PROFILE_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.ADD_RECIPE_URL, method = RequestMethod.GET)
	public String createNewRecipe(HttpServletRequest request) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.ADD_RECIPE_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.RECIPE_SEARCH_URL, method = RequestMethod.GET)
	public String findThisRecipe(HttpServletRequest request) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.RECIPE_SEARCH_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.GET_MY_CREATED_RECIPES, method = RequestMethod.GET)
	public String shareThisRecipe(HttpServletRequest request) throws Exception {
		if (super.checkPreConditions(request)) {
			UserBean ub = (UserBean) request.getSession().getAttribute(RecipeMakerConstants.USER_IN_SESSION);
			request.setAttribute(RecipeMakerConstants.CREATED_RECIPES_LIST, fetchAllRecipeOfUser(ub.getCreatedRecipe()));
		} else {
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
		return RecipeMakerConstants.GET_MY_CREATED_RECIPES;
	}

	@RequestMapping(value = RecipeMakerConstants.GET_FOLLOWING_URL, method = RequestMethod.GET)
	public String getFollowers(HttpServletRequest request) throws Exception {
		if(super.checkPreConditions(request)){
			return RecipeMakerConstants.GET_FOLLOWING_URL;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.RECIPE_FAV_LIST, method = RequestMethod.GET)
	public String getFavoritesRecipe(HttpServletRequest request) throws Exception {
		if(super.checkPreConditions(request)){
			MongoClientURI uri  = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159737.mlab.com:59737/recipe"); 
	        MongoClient client = new MongoClient(uri);
	        @SuppressWarnings("deprecation")
			DB db = client.getDB(uri.getDatabase());
			UserBean ub = (UserBean) request.getSession().getAttribute(RecipeMakerConstants.USER_IN_SESSION);
			ArrayList<String> favouriteRecipe = ub.getFavouriteRecipeList();			
			ArrayList<RecipeBean> AllRecipes = new ArrayList<RecipeBean>();			
			Iterator recipes = favouriteRecipe.iterator();
			while(recipes.hasNext()){
				BasicDBObject query = new BasicDBObject();
				query.put("_id", new ObjectId(recipes.next().toString()));
				Iterator collectionIterator = db.getCollectionNames().iterator();
				while(collectionIterator.hasNext()){					
		        	DBCollection collectiontofind = db.getCollection(collectionIterator.next().toString());
					DBObject returnObj = collectiontofind.findOne(query);
					if(returnObj != null)
					AllRecipes.add(CPSCUtil.getRecipeBeanObjectFromJson(returnObj));
				}
			}
        	client.close();
	        request.getSession().setAttribute(RecipeMakerConstants.CREATED_RECIPES_LIST,AllRecipes);			
			return RecipeMakerConstants.RECIPE_FAV_LIST;
		}else{
			return RecipeMakerException.throwErrorWithoutPage(request);
		}
	}
	
	@RequestMapping(value = RecipeMakerConstants.LOGOUT, method = RequestMethod.GET)
	public String logut(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		request.setAttribute(RecipeMakerConstants.CUSTOM_MESSAGE,"You have been successfully loggged out");
		return RecipeMakerConstants.HOME_PAGE_URL;
	}

}
