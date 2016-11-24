package edu.fullerton.cpsc.cpscRecipe.DAO;

import org.apache.log4j.Logger;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;

public class MongoDAO implements RecipeDAOInterface{
	private static final Logger logger = Logger.getLogger(MongoDAO.class.getName());
	private MongoClient mongoClient;
	private MongoDatabase db;
	private String serverName;
	private int portNumber;
	private String dataBaseName;

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public void setDb(MongoDatabase db) {
		this.db = db;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

	public MongoClient getMongoClient(String serverName,int portNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean createThisCollection(String collectionName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean insertSignUpValues(UserBean userBean) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
