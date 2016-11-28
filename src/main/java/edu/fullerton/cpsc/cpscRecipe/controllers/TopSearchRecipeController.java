package edu.fullerton.cpsc.cpscRecipe.controllers;

import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.util.CPSCUtil;

@Controller
@RequestMapping(RecipeMakerConstants.APP_URL)
public class TopSearchRecipeController{
	
	@RequestMapping(value = RecipeMakerConstants.TOP_SEARCH_RECIPE, method = RequestMethod.GET)
	public String handleGet(HttpServletRequest request) throws Exception {
		return handelPost(request);
	}

	@RequestMapping(value = RecipeMakerConstants.TOP_SEARCH_RECIPE, method = RequestMethod.POST)
	public String handelPost(HttpServletRequest request) throws Exception {
		String searchQuery = request.getParameter("searchQueries");
		if(null != searchQuery || !"".equals(searchQuery)){
			searchQuery = "chicken";
		}
			String urlToHit = "https://api.edamam.com/search?q="+URLEncoder.encode(searchQuery, "UTF-8")+
					"&app_id=3e85c661&app_key=f9af7085b7825964d3ea39d7e33877ee&from=0&to=6";
			JSONObject recipeJson = new JSONObject(IOUtils.toString(new URL(urlToHit), Charset.forName("UTF-8")));
			request.setAttribute(RecipeMakerConstants.SEARCH_RECIPE_RESULT_ARRAYLIST,
					CPSCUtil.getRecipeArrayList(recipeJson));
			return RecipeMakerConstants.TOP_SEARCH_RECIPE;		
	}

}
