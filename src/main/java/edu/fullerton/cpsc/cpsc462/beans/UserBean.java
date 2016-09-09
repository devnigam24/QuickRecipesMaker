/**
 * 
 */
package edu.fullerton.cpsc.cpsc462.beans;

/**
 * @author Devvrat Nigam
 *
 */
public class UserBean {
	private String userName;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		System.out.println("your username  "+userName);
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
