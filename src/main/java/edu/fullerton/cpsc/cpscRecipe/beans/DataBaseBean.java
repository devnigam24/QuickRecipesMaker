/**
 * 
 */
package edu.fullerton.cpsc.cpscRecipe.beans;

/**
 * @author Devvrat Nigam
 *
 */
public class DataBaseBean {

	private String serverName;
	private int portNumber;
	private String dataBaseName;

	/**
	 * @return the serverName
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * @param serverName
	 *            the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/**
	 * @return the portNumber
	 */
	public int getPortNumber() {
		return portNumber;
	}

	/**
	 * @param portNumber
	 *            the portNumber to set
	 */
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	/**
	 * @return the signUpdatabaseName
	 */
	public String getDataBaseName() {
		return dataBaseName;
	}

	/**
	 * @param signUpdatabaseName
	 *            the signUpdatabaseName to set
	 */
	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

}
