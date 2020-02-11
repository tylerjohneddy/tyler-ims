package com.qa.utils;

/**
 * @author Tyler
 *
 */
public class Config {

	private static String username;
	private static String password;

	private static String url = "jdbc:mysql://35.230.149.143/inventory_management";

	private Config() {

	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Config.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Config.password = password;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		Config.url = url;
	}

}
