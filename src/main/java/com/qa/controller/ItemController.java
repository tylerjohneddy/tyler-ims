package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Item;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

public class ItemController implements CrudController<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}

	@Override
	public void readAll() {
		for (String item : itemService.readAll()) {
			LOGGER.info(item.toString());
		}
	}

	public void readOne() {
		Long id = Long.parseLong(Utils.getInput());
		itemService.readOne(new Item(id));
	}

	@Override
	public void create() {
		LOGGER.info("Please enter a name of item:");
		String name = Utils.getInput();
		LOGGER.info("Please enter an item value:");
		double value = Double.parseDouble(Utils.getInput());
		LOGGER.info("Please enter stock amount:");
		int inStock = Integer.parseInt((Utils.getInput()));
		itemService.create(new Item(name, value, inStock));
		LOGGER.info("Item created");

	}

	@Override
	public void update() {
		try {
			LOGGER.info("Please Enter Item ID to update:");
			Long id = Long.parseLong(Utils.getInput());
			LOGGER.info("Please enter a name:");
			String name = Utils.getInput();
			LOGGER.info("Please enter a value:");
			Double value = Double.parseDouble(Utils.getInput());
			LOGGER.info("Please enter new stock count");
			int inStock = Integer.parseInt(Utils.getInput());
			itemService.update(new Item(name, value, inStock));
		} catch (NumberFormatException e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completeing the action, please check the log files");
		}

	}

	@Override
	public void delete() {
		LOGGER.info("Please Enter Item ID to delete:");
		Long id = Long.parseLong(Utils.getInput());
		itemService.delete(new Item(id));
	}

}
