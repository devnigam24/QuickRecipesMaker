package edu.fullerton.cpsc.cpscRecipe.classes;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import edu.fullerton.cpsc.cpscValidator.SignUpPageValidator;

public class SignUpLoginSuperClass {
	
	@Autowired
	@Qualifier("signUpFormValidator")
	private SignUpPageValidator formValidator;

	void message(String message){
		System.out.println(message);
	}

	public Boolean checkPreConditions(HttpServletRequest request) {
		return Boolean.TRUE;
	}
	
	public Boolean validateFormFields(Object className, BindingResult result) {
		formValidator.validate(className, result);
		if (result.hasErrors()) {
			return Boolean.FALSE;
		}else{
			return Boolean.TRUE;
		}
	}
	
	public void setDefaultValues(HttpServletRequest request, BindingResult result) {
		List<String> ErrorCodesArrayList = new ArrayList<String>();
		for (Object object : result.getAllErrors()) {
		    if(object instanceof FieldError) {
		        FieldError fieldError = (FieldError) object;
		        ErrorCodesArrayList.add(fieldError.getCode());
		    }else if(object instanceof ObjectError) {
		        ObjectError objectError = (ObjectError) object;
		        ErrorCodesArrayList.add(objectError.getCode());
		    }
		}		
		request.setAttribute(RecipeMakerConstants.ERROR_LIST, ErrorCodesArrayList);	
	}
	
}
