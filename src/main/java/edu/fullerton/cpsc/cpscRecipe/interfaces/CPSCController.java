package edu.fullerton.cpsc.cpscRecipe.interfaces;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CPSCController {
	
	String doPost(HttpServletRequest request) throws Exception;
	String doGet(HttpServletRequest request) throws Exception;

}
