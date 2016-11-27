package edu.fullerton.cpsc.cpscRecipe.DAO;

import com.mongodb.MongoClient;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;

public abstract interface RecipeDAOInterface {
	
	abstract MongoClient getMongoClient(String serverName, int portNumber);
	
	abstract Boolean createThisCollection(String collectionName);
	
	abstract Boolean insertSignUpValues(UserBean userBean);

}
