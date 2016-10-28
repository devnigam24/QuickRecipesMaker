package edu.fullerton.cpsc.cpsc462.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.fullerton.cpsc.cpsc462.interfaces.CPSCController;

@Controller
@RequestMapping("app")
public class AssetsController{
	
	@RequestMapping(value="includes", method=RequestMethod.GET)
	public String handleInclude(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return this.handelAssets(req, res);
	}
	
	@RequestMapping(value="assets", method=RequestMethod.GET)
	public String handelAssets(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return null;
	}

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res, String viewName)
			throws Exception {
		return null;
	}

}
