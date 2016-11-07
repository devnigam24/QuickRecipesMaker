/**
 * 
 */
package edu.fullerton.cpsc.cpscRecipe.beans;

/**
 * @author Devvrat Nigam
 *
 */
public class UserBean {
	private String userName;
	private char[] password;
	private String userFirstName;
	private String userLastName;
	private String userEmailID;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmailID() {
		return userEmailID;
	}

	public void setUserEmailID(String userEmailID) {
		this.userEmailID = userEmailID;
	}
	
	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

}
