/**
 * 
 */
package edu.fullerton.cpsc.cpscRecipe.util;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

import com.mongodb.BasicDBObject;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;

/**
 * @author Devvrat Nigam
 *
 */
public class CPSC476Util {

	public static BasicDBObject[] getJSONObjectFromUserBean(UserBean thisUserBean) {
		BasicDBObject userJson = new BasicDBObject();
		ArrayList<String> createdRecipeList =  new ArrayList<String>();
		HashMap<String,String> sharedRecipeMap =  new HashMap<String,String>();
		ArrayList<String> followersList =  new ArrayList<String>();
		ArrayList<String> followingList =  new ArrayList<String>();
		ArrayList<String> favouriteRecipeList =  new ArrayList<String>();
		
        userJson.put("firstName", thisUserBean.getUserFirstName());
        userJson.put("lastName", thisUserBean.getUserLastName());
        userJson.put("userName", thisUserBean.getUserName());
        userJson.put("emailId", thisUserBean.getUserEmailID());
        userJson.put("password", thisUserBean.getPassword());
        userJson.put("aboutMe", "");        
        userJson.put("createRecipeCount", 0);
        userJson.put("createdRecipe", createdRecipeList);
        userJson.put("sharedRecipeCount", 0);
        userJson.put("sharedRecipes", sharedRecipeMap);
        userJson.put("followersCount", 0);
        userJson.put("followersList", followersList);
        userJson.put("followingCount", 0);
        userJson.put("followingList", followingList);
        userJson.put("favouriteRecipeCount", 0);
        userJson.put("favouriteRecipeList", favouriteRecipeList);

        final BasicDBObject[] UserData = {userJson};
        return UserData;
        
        
        
	}}
