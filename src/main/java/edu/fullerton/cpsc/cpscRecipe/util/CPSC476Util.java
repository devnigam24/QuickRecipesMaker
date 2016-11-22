/**
 * 
 */
package edu.fullerton.cpsc.cpscRecipe.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fullerton.cpsc.cpscRecipe.DAO.MongoDAO;
import edu.fullerton.cpsc.cpscRecipe.beans.DataBaseBean;
import edu.fullerton.cpsc.cpscRecipe.beans.DataBases;
import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;

/**
 * @author Devvrat Nigam
 *
 */
public class CPSC476Util {
	
	final static ApplicationContext ac = new ClassPathXmlApplicationContext("edu.fullerton.cpsc.cpscRecipe.beans.xmls.Beans.xml");
	
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
	public static DataBases getDataBaseName(String beanId) {
		DataBases obj = (DataBases) ac.getBean(beanId);
		return obj;
	}
	
	public static void main(String[] args) {
		CPSC476Util u = new CPSC476Util();
		u.getDatabaseBeanObject("mongoID");
	}
}
