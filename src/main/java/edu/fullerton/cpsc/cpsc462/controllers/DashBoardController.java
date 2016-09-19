/**
 * 
 */
package edu.fullerton.cpsc.cpsc462.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.fullerton.cpsc.cpsc462.beans.UserBean;
import edu.fullerton.cpsc.cpsc462.interfaces.CPSCController;

/**
 * @author Devvrat Nigam
 *
 */
@Controller
@RequestMapping("app")
public class DashBoardController implements CPSCController {

	private static final Logger logger = Logger.getLogger(DashBoardController.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res, String viewName)
			throws Exception {
		logger.info("Entered in handle request");
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");
		UserBean obj = (UserBean) ac.getBean("userBeanID");
		obj.getUserName();
		System.out.println(viewName.trim());
		return new ModelAndView("dashboard");
	}

	@RequestMapping(value = "dashboard.htm", method = RequestMethod.GET)
	public String handleGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("Entered in get request");
		return "dashboard";
	}

	@Override
	@RequestMapping(value = "dashboard.htm", method = RequestMethod.POST)
	public String handelPost(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("Entered in post request");
		return null;
	}
}
