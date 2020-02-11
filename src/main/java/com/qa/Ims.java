package com.qa;

import org.apache.log4j.Logger;

import com.qa.controller.*;
import com.qa.persistence.dao.*;
import com.qa.persistence.domain.Domain;
import com.qa.services.*;
import com.qa.utils.Config;
import com.qa.utils.Utils;


public class Ims {

	public static final Logger LOGGER = Logger.getLogger(Ims.class);

	public void imsSystem() {
		LOGGER.info("What is your username");
		Config.username = Utils.getInput();
		LOGGER.info("What is your password");
		Config.password = Utils.getInput();

		LOGGER.info("Which entity would you like to use?");
		Domain.printDomains();

		Domain domain = Domain.getDomain();
		LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

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
			break;
		}

	}

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
