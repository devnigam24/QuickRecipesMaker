package edu.fullerton.cpsc.cpscValidator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.fullerton.cpsc.cpscRecipe.beans.UserBean;
import edu.fullerton.cpsc.cpscRecipe.classes.RecipeMakerConstants;
import edu.fullerton.cpsc.cpscRecipe.exception.ErrorAndMessages;

public class SignUpPageValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	public boolean supports(Class<?> clazz) {
		return clazz.equals(UserBean.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.empty.userName",
				ErrorAndMessages.USERNAMENULL);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.empty.userPassword",
				ErrorAndMessages.PASSWORDNULL);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userFirstName", "error.empty.userFirstName",
				ErrorAndMessages.USERFIRSTNAMENULL);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLastName", "error.empty.userLastName",
				ErrorAndMessages.USERLASTNAMENULL);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmailID", "error.empty.userEmail",
				ErrorAndMessages.EMAILNULL);
		UserBean credentials = (UserBean) target;
		if (!credentials.getUserEmailID().matches(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			errors.rejectValue("userEmailID", "error.invalid.userEmail");
		}
	}

}
