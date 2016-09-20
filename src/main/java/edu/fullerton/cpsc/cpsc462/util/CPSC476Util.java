/**
 * 
 */
package edu.fullerton.cpsc.cpsc462.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fullerton.cpsc.cpsc462.DAO.MongoDAO;
import edu.fullerton.cpsc.cpsc462.beans.DataBaseBean;
import edu.fullerton.cpsc.cpsc462.beans.Databases;
import edu.fullerton.cpsc.cpsc462.beans.UserBean;

/**
 * @author Devvrat Nigam
 *
 */
public class CPSC476Util {
	
	final static ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
	
	/**
	 * @param beanId
	 * @return
	 */
	public static UserBean getUserBeanObject(String beanId){		
		UserBean obj = (UserBean) ac.getBean(beanId);
		return obj;
	}

	/**
	 * @param beanId
	 * @return
	 */
	public static DataBaseBean getDatabaseBeanObject(String beanId) {
		DataBaseBean obj = (DataBaseBean) ac.getBean(beanId);
		return obj;
	}

	/**
	 * @param string
	 * @return
	 */
	public static Databases getDataBaseName(String beanId) {
		Databases obj = (Databases) ac.getBean(beanId);
		return obj;
	}
	
	public static void main(String[] args) {
		CPSC476Util u = new CPSC476Util();
		u.getDatabaseBeanObject("mongoID");
	}
}
