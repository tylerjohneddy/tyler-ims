package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.utils.Utils;

/**
 * @author Tyler
 * Action is a collection of commands that are used to select functionality. 
 *
 */
public enum Action {

	CREATE("To save a new item into the database"), READ("To read an item from the database"),
	UPDATE("To change an item already in the database"), DELETE("To remove an item from the database"),
	RETURN("To return to domain selection");

	public static final Logger LOGGER = Logger.getLogger(Action.class);

	private String description;

	/**
	 * @param description
	 */
	Action(String description) {
		this.description = description;
	}

	/**
	 * @return
	 * Returns a string with the name and description of each action.
	 */
	public String description() {
		return String.format("%-10s : %s", this.name(),this.description);
	}

	/**
	 * Prints all actions 
	 */
	public static void printActions() {
		for (Action action : Action.values()) {
			LOGGER.info(action.description());
		}
	}

	/**
	 * Returns a action based on user input.
	 * if user input is incorrect it asks for the input again.
	 * @return Action
	 */
	public static Action getAction() {
		Action action;
		while (true) {
			try {
				action = Action.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return action;
	}

}
