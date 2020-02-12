package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Item;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

/**
 * @author Tyler
 *
 */
public class ItemController implements CrudController<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	/**
	 * @param itemService
	 */
	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}

	/**
	 * @return
	 */
	public String getInput() {
		return Utils.getInput();
	}

	/**
	 *
	 */
	@Override
	public void readAll() {
		for (String item : itemService.readAll()) {
			LOGGER.info(item);
		}
	}

	/**
	 *
	 */
	@Override
	public void readOne() {
		Long id = Long.parseLong(getInput());
		itemService.readOne(new Item(id));
	}

	/**
	 *
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter a name of item:");
		String name = getInput();
		LOGGER.info("Please enter an item value:");
		double value = Double.parseDouble(getInput());
		Item item = itemService.create(new Item(name, value));
		LOGGER.info("Item created");
		return item;

	}

	/**
	 *
	 */
	@Override
	public Item update() {
		try {
			LOGGER.info("Please Enter Item ID to update:");
			Long id = Long.parseLong(getInput());
			LOGGER.info("Please enter a name:");
			String name = Utils.getInput();
			LOGGER.info("Please enter a value:");
			Double value = Double.parseDouble(getInput());
			itemService.update(new Item(id, name, value));
		} catch (NumberFormatException e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completeing the action, please check the log files");
		}
		return null;

	}

	/**
	 *
	 */
	@Override
	public void delete() {
		LOGGER.info("Please Enter Item ID to delete:");
		Long id = Long.parseLong(getInput());
		itemService.delete(new Item(id));
	}

}
