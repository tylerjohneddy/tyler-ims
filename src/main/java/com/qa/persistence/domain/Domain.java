package com.qa.persistence.domain;

import org.apache.log4j.Logger;

import com.qa.utils.Utils;

/**
 * @author Tyler
 *
 */
public enum Domain {

	CUSTOMER("Information about customers"),
	ITEM("Individual Items"),
	ORDER("Purchases of items"),
	STOP("To close the application");
	
	public static final Logger LOGGER = Logger.getLogger(Domain.class);

	private String description;
	
	/**
	 * @param description
	 */
	private Domain(String description) {
		this.description = description;
	}
	
	/**
	 * @return
	 */
	public String description() {
		return String.format("%-10s : %-30s",this.name(),this.description);
	}
	
	/**
	 * 
	 */
	public static void printDomains() {
		for (Domain domain : Domain.values()) {
			LOGGER.info(domain.description());
		}
	}
	
	/**
	 * @return
	 */
	public static Domain getDomain() {
		Domain domain;
		while (true) {
			try {
				domain = Domain.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return domain;
	}
	
}
