package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

public class CustomerController implements CrudController<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerService;

	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}

	public String getInput() {
		return Utils.getInput();
	}

	@Override
	public void readAll() {
		for (String customer : customerService.readAll()) {
			LOGGER.info(customer);
		}
	}

	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name:");
		String firstName = getInput();
		LOGGER.info("Please enter a surname:");
		String surname = getInput();
		Customer customer = customerService.create(new Customer(firstName, surname));
		LOGGER.info("Customer created");
		return customer;
	}

	@Override
	public Customer update() {
		LOGGER.info("Please Enter Customer ID to update:");
		Long id = Long.parseLong(getInput());
		LOGGER.info("Please enter a first name:");
		String firstName = getInput();
		LOGGER.info("Please enter a surname:");
		String surname = getInput();
		return customerService.update(new Customer(id, firstName, surname));
		 

	}

	@Override
	public void delete() {
		LOGGER.info("Please Enter Customer ID to delete:");
		readOne();
		LOGGER.info("To Confirm Please Enter Customer ID again to delete:");
		Long id = Long.parseLong(getInput());
		customerService.delete(new Customer(id));

	}

	@Override
	public void readOne() {
		Long id = Long.parseLong(getInput());
		customerService.readOne(new Customer(id));

	}

}
