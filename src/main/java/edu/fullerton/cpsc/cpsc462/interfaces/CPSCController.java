/**
 * 
 */
package edu.fullerton.cpsc.cpsc462.interfaces;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.fullerton.cpsc.cpsc462.exception.Cpsc476Exception;

/**
 * @author Devvrat Nigam
 *
 */
public abstract interface CPSCController{
	
	/* 
	 * handles post request
	 */
	String handleGet(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	/* 
	 * handles post request
	 */
	String handelPost(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	/* 
	 * handles get and post followed request
	 */
	ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res,String viewName) throws Exception;

}
