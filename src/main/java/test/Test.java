/**
 * 
 */
package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fullerton.cpsc.cpsc462.DAO.MongoDAO;
import edu.fullerton.cpsc.cpsc462.beans.UserBean;
import edu.fullerton.cpsc.cpsc462.util.CPSC476Util;

/**
 * @author Devvrat Nigam
 *
 */
public class Test {
	
	public static void main(String[] args) {
		System.out.println("started");
		UserBean ub = new UserBean();
		ub.setUserEmailID("999999999999999999999");
		ub.setUserName("000000000000000");
		MongoDAO m = new MongoDAO();
		m.createThisUserCollection(CPSC476Util.getUserBeanObject("userBeanID").getUserName());
		m.insertLoginValues(CPSC476Util.getUserBeanObject("userBeanID").getUserName(), ub);
		System.out.println("end");
	}

}
