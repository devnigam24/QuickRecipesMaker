package edu.fullerton.cpsc.cpsc462.DAO;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDAO extends DAO{
	private static final Logger logger = Logger.getLogger(MongoDAO.class.getName());
	private MongoClient mongoClient;
	private MongoDatabase db;

	private String serverName;
	private int portNumber;
	private String dataBaseName;
	ApplicationContext applicationcontextobject =  new ClassPathXmlApplicationContext("Beans.xml");

	/**
	 * @param serverName
	 *            the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/**
	 * @param portNumber
	 *            the portNumber to set
	 */
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	/**
	 * @param dataBaseName
	 *            the dataBaseName to set
	 */
	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}
	
	public void setMongoConnection(String host,int port){
		this.mongoClient = new MongoClient(host, port);
		logger.log(Level.INFO, "Connect to " + this.mongoClient.getClass() + " successfully");
	}
}
