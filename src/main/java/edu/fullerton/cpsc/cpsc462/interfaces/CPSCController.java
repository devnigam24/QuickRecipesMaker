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

/**
 * @author Devvrat Nigam
 *
 */
public abstract interface CPSCController{
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	void handleGet(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	void handelPost(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	/* 
	 * handles get and post followed request
	 */
	ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res,String viewName) throws Exception;

}
