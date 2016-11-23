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
	private String password;
	private String userFirstName;
	private String userLastName;
	private String userEmailID;
	
	public UserBean(){}
	
	public UserBean(String userName,String password,String userFirstName,String userLastName,String userEmailID){
		this.userName=userName;
		this.password=password;
		this.userFirstName=userFirstName;
		this.userLastName=userLastName;
		this.userEmailID=userEmailID;
	}
	
	public UserBean(String userName,String password){
		this.userName=userName;
		this.password=password;
	}

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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
