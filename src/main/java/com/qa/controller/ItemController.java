package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.persistence.domain.Item;
import com.qa.services.CrudServices;
import com.qa.services.ItemServices;
import com.qa.utils.Utils;

public class ItemController implements CrudController<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		// TODO Auto-generated constructor stub
		this.itemService = itemService;
	}

	@Override
	public void readAll() {
		for (String item : itemService.readAll()) {
			LOGGER.info(item.toString());
		}
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		LOGGER.info("Please enter a first name:");
		String name = Utils.getInput();
		LOGGER.info("Please enter a surname:");
		double value = Double.parseDouble(Utils.getInput());
		LOGGER.info("Please enter a surname:");
		int inStock = Integer.parseInt((Utils.getInput()));
		itemService.create(new Item(name, value, inStock));
		LOGGER.info("Customer created");

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
