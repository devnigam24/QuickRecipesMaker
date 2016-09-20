package edu.fullerton.cpsc.cpsc462.DAO;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import edu.fullerton.cpsc.cpsc462.beans.UserBean;
import edu.fullerton.cpsc.cpsc462.util.CPSC476Util;

public class DAO {
	private static final Logger logger = Logger.getLogger(DAO.class.getName());
	private MongoDatabase db;

	final private String logindataBaseName;

	public DAO() {
		this.logindataBaseName = CPSC476Util.getDataBaseName("databaseID").getLoginCollection();
	}

	protected Boolean getMongoClientForUser(MongoClient mongoClient) {
		try {
			// Now connect to your databases
			this.db = mongoClient.getDatabase(logindataBaseName);
			logger.log(Level.INFO, "Connect to " + db.getName() + " successfully");
			return Boolean.TRUE;

		} catch (Exception e) {
			logger.log(Level.ERROR, e.getClass().getName() + ": " + e.getMessage());
			return Boolean.FALSE;
		}
	}

	/**
	 * @param db
	 * @param collectionName
	 */
	public void createThisUserCollection(String collectionName) {
		try {
			if (this.db != null) {
				db.createCollection(collectionName);
				logger.log(Level.INFO, "collection created " + db.getCollection(collectionName) + " Successfully");
			}
		} catch (Exception e) {
			logger.log(Level.ERROR, e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * @param userName
	 * @param signupcredentials
	 */
	public void insertLoginValues(String userName, UserBean userbean) {
		Document signUpDocument = new Document();
		signUpDocument.append("userName", userbean.getUserName());
		signUpDocument.append("emailID", userbean.getUserEmailID());
		db.getCollection(userName).insertOne(signUpDocument);
	}

}