package com.recipe.user;

import java.util.ArrayList;
import java.util.HashMap;

public class UserBean {
	private String userName;
	private String password;
	private String userFirstName;
	private String userLastName;
	private String userEmailID;
	private String aboutMe;
	private int createRecipeCount;
	private ArrayList<String> createdRecipe;
	private int sharedRecipeCount;
	private HashMap<String, String> sharedRecipes;
	private int followersCount;
	private ArrayList<String> followersList;
	private int followingCount;
	private ArrayList<String> followingList;
	private int favouriteRecipeCount;
	private ArrayList<String> favouriteRecipeList;
	private String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getAboutMe() {
		if (null == aboutMe) {
			aboutMe = "";
		}
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public int getCreateRecipeCount() {
		return createRecipeCount;
	}

	public void setCreateRecipeCount(int createRecipeCount) {
		this.createRecipeCount = createRecipeCount;
	}

	public ArrayList<String> getCreatedRecipe() {
		if (null == createdRecipe) {
			createdRecipe = new ArrayList<String>();
		}
		return createdRecipe;
	}

	public void setCreatedRecipe(ArrayList<String> createdRecipe) {
		this.createdRecipe = createdRecipe;
	}

	public int getSharedRecipeCount() {
		return sharedRecipeCount;
	}

	public void setSharedRecipeCount(int sharedRecipeCount) {
		this.sharedRecipeCount = sharedRecipeCount;
	}

	public HashMap<String, String> getSharedRecipes() {
		if (null == sharedRecipes) {
			sharedRecipes = new HashMap<String, String>();
		}
		return sharedRecipes;
	}

	public void setSharedRecipes(HashMap<String, String> sharedRecipes) {
		this.sharedRecipes = sharedRecipes;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public ArrayList<String> getFollowersList() {
		if (null == followersList) {
			followersList = new ArrayList<String>();
		}
		return followersList;
	}

	public void setFollowersList(ArrayList<String> followersList) {
		this.followersList = followersList;
	}

	public int getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}

	public ArrayList<String> getFollowingList() {
		if (null == followingList) {
			followingList = new ArrayList<String>();
		}
		return followingList;
	}

	public void setFollowingList(ArrayList<String> followingList) {
		this.followingList = followingList;
	}

	public int getFavouriteRecipeCount() {
		return favouriteRecipeCount;
	}

	public void setFavouriteRecipeCount(int favouriteRecipeCount) {
		this.favouriteRecipeCount = favouriteRecipeCount;
	}

	public ArrayList<String> getFavouriteRecipeList() {
		if (null == favouriteRecipeList) {
			favouriteRecipeList = new ArrayList<String>();
		}
		return favouriteRecipeList;
	}

	public void setFavouriteRecipeList(ArrayList<String> favouriteRecipeList) {
		this.favouriteRecipeList = favouriteRecipeList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmailID() {
		return userEmailID;
	}

	public void setUserEmailID(String userEmailID) {
		this.userEmailID = userEmailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
