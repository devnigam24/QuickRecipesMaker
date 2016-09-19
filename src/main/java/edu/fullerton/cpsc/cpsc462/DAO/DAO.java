package edu.fullerton.cpsc.cpsc462.DAO;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DAO {
	private static final Logger logger = Logger.getLogger(DAO.class.getName());
	private MongoDatabase db;
	private String dataBaseName;
	ApplicationContext applicationcontextobject =  new ClassPathXmlApplicationContext("Beans.xml");
	MongoDAO myDao = (MongoDAO) applicationcontextobject.getBean(arg0)
	
	public DAO() {
		return;
	}

	protected Boolean getMongoClientForUser(MongoClient mongoClient) {
		try {
			// Now connect to your databases
			this.db = mongoClient.getDatabase(dataBaseName);
			logger.log(Level.INFO, "Connect to " + db.getName() + " successfully");
			return Boolean.TRUE;

		} catch (Exception e) {
			logger.log(Level.ERROR, e.getClass().getName() + ": " + e.getMessage());
			return Boolean.FALSE;
		}
	}
}
