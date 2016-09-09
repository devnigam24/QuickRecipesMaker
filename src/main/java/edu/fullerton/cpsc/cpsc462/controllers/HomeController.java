/**
 * 
 */
package edu.fullerton.cpsc.cpsc462.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("/first")
public class HomeController implements CPSCController{

	/* (non-Javadoc)
	 * @see edu.fullerton.cpsc.cpsc462.interfaces.CPSCController#handleGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void handleGet(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("handel get");
		ApplicationContext ac = new ClassPathXmlApplicationContext("Beans.xml");		
		UserBean obj = (UserBean)ac.getBean("userBeanID");
		obj.getUserName();
		
		handleRequest(req, res, "anotherTest");		
	}

	/* (non-Javadoc)
	 * @see edu.fullerton.cpsc.cpsc462.interfaces.CPSCController#handelPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void handelPost(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
	}

	/* (non-Javadoc)
	 * @see edu.fullerton.cpsc.cpsc462.interfaces.CPSCController#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res, String viewName) throws Exception {
		ModelAndView mv = new ModelAndView(viewName);
		System.out.println("object returned");
		return mv;
	}
	
}
