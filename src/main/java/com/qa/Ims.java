package com.qa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.qa.controller.Action;
import com.qa.controller.CrudController;
import com.qa.controller.CustomerController;
import com.qa.controller.ItemController;
import com.qa.controller.OrderController;
import com.qa.persistence.dao.CustomerDaoMysql;
import com.qa.persistence.dao.ItemDaoMysql;
import com.qa.persistence.dao.OrderDaoMysql;
import com.qa.persistence.domain.Domain;
import com.qa.services.CustomerServices;
import com.qa.services.ItemServices;
import com.qa.services.OrderServices;
import com.qa.utils.Config;
import com.qa.utils.Utils;

/**
 * @author Tyler
 *
 */
public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);
	/**
	 * @return
	 */
	public String getInput() {
		return Utils.getInput();
	}


	/**
	 * 
	 */
	public void imsSystem() {
		LOGGER.info("What is your username");
		Config.setUsername(getInput());
		LOGGER.info("What is your password");
		Config.setPassword(getInput());
		boolean exit = true;
		while (exit) {

			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			Domain domain = Domain.getDomain();
			if(domain.toString().equals("STOP")) {
				System.exit(0);
			}
			LOGGER.info(String.format("What would you like to do with %s :", domain.name().toLowerCase()));

			Action.printActions();
			Action action = Action.getAction();

			switch (domain) {
			case CUSTOMER:
				CustomerController customerController = new CustomerController(
						new CustomerServices(new CustomerDaoMysql()));
				doAction(customerController, action);
				break;
			case ITEM:
				ItemController itemController = new ItemController(new ItemServices(new ItemDaoMysql()));
				doAction(itemController, action);
				break;
			case ORDER:
				OrderController orderController = new OrderController(new OrderServices(new OrderDaoMysql()));
				doAction(orderController, action);
				break;
			case STOP:
				exit = false;
				break;
				
			}
		}

	}

	/**
	 * @param crudController
	 * @param action
	 */
	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		}
	}


}
