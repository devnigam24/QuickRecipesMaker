package edu.fullerton.cpsc.cpscRecipe.classes;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.bson.types.ObjectId;
import org.springframework.validation.BindingResult;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import edu.fullerton.cpsc.cpscRecipe.beans.RecipeBean;
import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.util.CPSCUtil;

public class RecipeClass {

	void message(String message) {
		System.out.println(message);
	}

	public Boolean checkPreConditions(HttpServletRequest request) {
		CPSCUtil.setValuesInRequest(request,
				(UserBean) request.getSession().getAttribute(RecipeMakerConstants.USER_IN_SESSION));
		return Boolean.TRUE;
	}

	public void setDefaultValues(HttpServletRequest request, BindingResult result) {

	}

	public ArrayList<RecipeBean> fetchAllRecipeOfUser(ArrayList<String> createdRecipe) {
		if(createdRecipe.size() <= 0){
			return new ArrayList<RecipeBean>();
		}else{
			MongoClientURI uri = new MongoClientURI("mongodb://nimesh5:nimesh5@ds159737.mlab.com:59737/recipe");
			MongoClient client = new MongoClient(uri);
			@SuppressWarnings("deprecation")
			DB db = client.getDB(uri.getDatabase());
			ArrayList<RecipeBean> AllRecipes = new ArrayList<RecipeBean>();
			Iterator recipes = createdRecipe.iterator();
			while (recipes.hasNext()) {
				BasicDBObject query = new BasicDBObject();
				query.put("_id", new ObjectId(recipes.next().toString()));
				Iterator collectionIterator = db.getCollectionNames().iterator();
				while (collectionIterator.hasNext()) {
					DBCollection collectiontofind = db.getCollection(collectionIterator.next().toString());
					DBObject returnObj = collectiontofind.findOne(query);
					if (returnObj != null)
						AllRecipes.add(CPSCUtil.getRecipeBeanObjectFromJson(returnObj));
				}
			}
			client.close();
			return AllRecipes;			
		}
	}

}
