package com.cs;

import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;

public class LoginInfo {
	String url;
	String userName;
	String password;
	RedmineManager rm;

	public LoginInfo(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;

	}

	public void login() {
		rm = RedmineManagerFactory.createWithUserAuth(this.url, this.userName, this.password);
	}

	public RedmineManager getRedmineManager() throws LoginException {
		if (rm == null) {
			throw new LoginException("Please Login frist!");
		}
		return rm;
	}

}
class LoginException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException(String errMsg) {
		super(errMsg);
	}
	
}
