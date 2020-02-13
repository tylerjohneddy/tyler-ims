package com.qa.utils;

/**
 * @author Tyler
 *
 */
public class Config {

	private String username;
	private String password;

	private String url = "jdbc:mysql://35.230.149.143/inventory_management";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


}
