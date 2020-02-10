package com.qa;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.services.CustomerServices;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);
	
	public static void main(String[] args) {
		
		
		Ims ims = new Ims();
		ims.imsSystem();
	}

}
