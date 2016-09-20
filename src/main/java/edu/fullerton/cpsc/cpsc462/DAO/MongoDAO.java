package edu.fullerton.cpsc.cpsc462.DAO;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import edu.fullerton.cpsc.cpsc462.beans.UserBean;
import edu.fullerton.cpsc.cpsc462.util.CPSC476Util;

public class MongoDAO extends DAO {
	private static final Logger logger = Logger.getLogger(MongoDAO.class.getName());
	private MongoClient mongoClient;
	private MongoDatabase db;
	private final String serverName;
	private final int portNumber;
	private final String signUpdatabaseName;

	public MongoDAO() {
		this.serverName = CPSC476Util.getDatabaseBeanObject("mongoID").getServerName();
		this.portNumber = CPSC476Util.getDatabaseBeanObject("mongoID").getPortNumber();
		this.signUpdatabaseName = CPSC476Util.getDataBaseName("databaseID").getLoginCollection();
		this.db = getMongoClient(serverName, portNumber);
	}

	private MongoDatabase getMongoClient(String serverName, int portNumber) {
		try {
			// To connect to mongodb server
			this.mongoClient = new MongoClient(serverName, portNumber);
			logger.log(Level.INFO, "Connect to " + this.mongoClient.getClass() + " successfully");

			if (super.getMongoClientForUser(mongoClient)) {
				// Now connect to your databases
				this.db = mongoClient.getDatabase(signUpdatabaseName);
				logger.log(Level.INFO, "Connect to " + db.getName() + " successfully");
				return db;
			} else {
				return null;
			}

		} catch (Exception e) {
			logger.log(Level.ERROR, e.getClass().getName() + ": " + e.getMessage());
			return null;
		}
	}

	public void createThisUserCollection(String CollectionName) {
		try {
			if (this.db != null) {
				db.createCollection(CollectionName);
				logger.log(Level.INFO, "collection created " + db.getCollection(CollectionName) + " Successfully");
			}
			super.createThisUserCollection(CollectionName);
		} catch (Exception e) {
			logger.log(Level.ERROR, e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * @param userEmail
	 * @param signupcredentials
	 */
	private void insertValues(String collectionName, UserBean UserBean) {
		Document oneEntery = new Document();

		oneEntery.append("firstName", UserBean.getUserFirstName());
		oneEntery.append("lastNAme", UserBean.getUserLastName());
		oneEntery.append("emailID", UserBean.getUserEmailID());
		oneEntery.append("userName", UserBean.getUserName());

		try {
			if (this.db != null)
				this.db.getCollection(collectionName).insertOne(oneEntery);
		} catch (Exception e) {
			logger.log(Level.ERROR, e.getClass().getName() + ": " + e.getMessage());
		}
		// super.insertLoginValues(collectionName, UserBean);
	}

	public static void main(String[] args) {
		MongoDAO m = new MongoDAO();
		m.insertValues("someCollectionName3", new UserBean());
	}
}
