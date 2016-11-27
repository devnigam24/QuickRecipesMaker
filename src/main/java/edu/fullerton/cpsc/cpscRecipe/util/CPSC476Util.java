/**
 * 
 */
package edu.fullerton.cpsc.cpscRecipe.util;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;

/**
 * @author Devvrat Nigam
 *
 */
public class CPSC476Util {

	public static BasicDBObject getJSONObjectFromUserBean(UserBean thisUserBean) {
		BasicDBObject userJson = new BasicDBObject();
		userJson.put(RecipeMakerConstants.USER_FIRST_NAME, thisUserBean.getUserFirstName());
		userJson.put(RecipeMakerConstants.USER_LAST_NAME, thisUserBean.getUserLastName());
		userJson.put(RecipeMakerConstants.USER_NAME, thisUserBean.getUserName());
		userJson.put(RecipeMakerConstants.USER_EMAIL_ID, thisUserBean.getUserEmailID());
		userJson.put(RecipeMakerConstants.USER_PASSWORD, thisUserBean.getPassword());
		userJson.put(RecipeMakerConstants.USER_ABOUT_ME, thisUserBean.getAboutMe());
		userJson.put(RecipeMakerConstants.USER_CREATED_RECIPE_COUNT, thisUserBean.getCreateRecipeCount());
		userJson.put(RecipeMakerConstants.USER_CREATED_RECIPE, thisUserBean.getCreatedRecipe());
		userJson.put(RecipeMakerConstants.USER_SHARED_RECIPE_COUNT, thisUserBean.getSharedRecipeCount());
		userJson.put(RecipeMakerConstants.USER_SHARED_RECIPE, thisUserBean.getSharedRecipes());
		userJson.put(RecipeMakerConstants.USER_FOLLOWERS_COUNT, thisUserBean.getFollowersCount());
		userJson.put(RecipeMakerConstants.USER_FOLLOWERS_LIST, thisUserBean.getFollowingList());
		userJson.put(RecipeMakerConstants.USER_FOLLOWING_COUNT, thisUserBean.getFollowingCount());
		userJson.put(RecipeMakerConstants.USER_FOLLOWING_LIST, thisUserBean.getFollowingList());
		userJson.put(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_COUNT, thisUserBean.getFavouriteRecipeCount());
		userJson.put(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_LIST, thisUserBean.getFavouriteRecipeList());
		userJson.put(RecipeMakerConstants.UNIQUE_ID, thisUserBean.get_id());
		return userJson;

	}

	public static UserBean getUserBeanObjectFronJSON(DBObject returnObj) {
		UserBean user =  new UserBean();
		user.setUserFirstName(returnObj.get(RecipeMakerConstants.USER_FIRST_NAME).toString());
		user.setUserLastName(returnObj.get(RecipeMakerConstants.USER_LAST_NAME).toString());
		user.setUserName(returnObj.get(RecipeMakerConstants.USER_NAME).toString());
		user.setUserEmailID(returnObj.get(RecipeMakerConstants.USER_EMAIL_ID).toString());
		user.setPassword(returnObj.get(RecipeMakerConstants.USER_PASSWORD).toString());
		user.setAboutMe(returnObj.get(RecipeMakerConstants.USER_ABOUT_ME).toString());
		
		user.setCreateRecipeCount((Integer)returnObj.get(RecipeMakerConstants.USER_CREATED_RECIPE_COUNT));
		user.setCreatedRecipe((ArrayList<String>)returnObj.get(RecipeMakerConstants.USER_CREATED_RECIPE));
		
		user.setSharedRecipeCount((Integer)returnObj.get(RecipeMakerConstants.USER_SHARED_RECIPE_COUNT));		
		user.setSharedRecipes((HashMap<String, String>) returnObj.get(RecipeMakerConstants.USER_SHARED_RECIPE));
		
		user.setFollowersCount((Integer)returnObj.get(RecipeMakerConstants.USER_FOLLOWERS_COUNT));
		user.setFollowersList((ArrayList<String>) returnObj.get(RecipeMakerConstants.USER_FOLLOWERS_LIST));
		
		user.setFollowingCount((Integer)returnObj.get(RecipeMakerConstants.USER_FOLLOWING_COUNT));
		user.setFollowersList((ArrayList<String>) returnObj.get(RecipeMakerConstants.USER_FOLLOWING_LIST));
		
		user.setFavouriteRecipeCount((Integer)returnObj.get(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_COUNT));
		user.setFavouriteRecipeList((ArrayList<String>) returnObj.get(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_LIST));
		user.set_id(returnObj.get(RecipeMakerConstants.UNIQUE_ID).toString());
		
		return user;
	}

	public static ArrayList<RecipeBean> getRecipeArrayList(JSONObject recipeJson) throws JSONException {
		ArrayList<RecipeBean> searchRecipeList = new ArrayList<RecipeBean>();
		JSONArray hits = recipeJson.getJSONArray("hits");
		JSONObject recipeObject;
		for(int i=0;i<hits.length();i++){
			RecipeBean newBean = new RecipeBean();
			recipeObject = hits.getJSONObject(i).getJSONObject("recipe");
			newBean.setRecipeName(recipeObject.get("label").toString());
			newBean.setImageUrl(recipeObject.get("image").toString());
			newBean.setMoreInfoUrl(recipeObject.get("url").toString());
			newBean.setIngredientsList(recipeObject.getJSONArray("ingredientLines"));
			newBean.setDietLabels(recipeObject.getJSONArray("dietLabels"));
			newBean.setHealthLabels(recipeObject.getJSONArray("healthLabels"));
			newBean.setCalorieAmount(Double.parseDouble(recipeObject.get("calories").toString()) / 
									Double.parseDouble(recipeObject.get("yield").toString()));
			searchRecipeList.add(newBean);
		}		
		return searchRecipeList;
	}

	public static String getRandomCookingTime(int l, int m) {
			java.util.Random r = new java.util.Random();
			int randomNum = r.nextInt(m-l) + l;
			return String.valueOf(randomNum);
	}

	public static BasicDBObject[] getJSONObjectFromRecipeBean(RecipeBean thisRecipe) {
		BasicDBObject RecipeJson = new BasicDBObject();
		RecipeJson.put(RecipeMakerConstants.RECIPE_NAME, thisRecipe.getRecipeName());
		RecipeJson.put(RecipeMakerConstants.IMAGE_URL,thisRecipe.getImageUrl());
		RecipeJson.put(RecipeMakerConstants.MORE_INF_OURL, thisRecipe.getMoreInfoUrl());
		RecipeJson.put(RecipeMakerConstants.INGREDIENTS_LIST, thisRecipe.getIngredientsList());
		RecipeJson.put(RecipeMakerConstants.DIET_LABELS, thisRecipe.getDietLabels());
		RecipeJson.put(RecipeMakerConstants.COOKING_TIME, thisRecipe.getCookingTime());
		RecipeJson.put(RecipeMakerConstants.CALORIE_AMOUNT, thisRecipe.getCalorieAmount());	
		if(null != thisRecipe.getCreatedBy() && "".equals(thisRecipe.getCreatedBy())){
			RecipeJson.put(RecipeMakerConstants.RECIPE_CREATED_BY, thisRecipe.getCreatedBy());
		}else{
			RecipeJson.put(RecipeMakerConstants.RECIPE_CREATED_BY, "EdmanApi");
		}				
		final BasicDBObject[] recipeData = { RecipeJson };
		return recipeData;

	}

	public static void setValuesInRequest(HttpServletRequest request, UserBean userBean) {
		if(null != userBean){
			request.setAttribute(RecipeMakerConstants.USER_FIRST_NAME, userBean.getUserFirstName());
			request.setAttribute(RecipeMakerConstants.USER_LAST_NAME, userBean.getUserLastName());
			request.setAttribute(RecipeMakerConstants.USER_EMAIL_ID, userBean.getUserEmailID());
			request.setAttribute(RecipeMakerConstants.USER_ABOUT_ME, userBean.getAboutMe());
			request.setAttribute(RecipeMakerConstants.USER_NAME, userBean.getUserName());
			request.setAttribute(RecipeMakerConstants.USER_PASSWORD, userBean.getPassword());
			request.setAttribute(RecipeMakerConstants.USER_FAVOURTITE_RECIPE_LIST, userBean.getFavouriteRecipeList());
			request.setAttribute(RecipeMakerConstants.USER_CREATED_RECIPE, userBean.getCreatedRecipe());
			request.setAttribute(RecipeMakerConstants.UNIQUE_ID, userBean.get_id());
		}		
	}
}
