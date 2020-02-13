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
	public static final Logger logger = Logger.getLogger(ItemController.class);

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
			logger.info(item);
		}
	}

	@Override
	public Item readOne(Item item) {

		return itemService.readOne(new Item(item.getId()));
	}

	/**
	 *
	 */
	@Override
	public Item create() {
		logger.info("Please enter a name of item:");
		String name = getInput();
		logger.info("Please enter an item value:");
		double value = Double.parseDouble(getInput());
		Item item = itemService.create(new Item(name, value));
		logger.info("Item created");
		return item;

	}

	@Override
	public Item update() {
		Item item = null;
		try {
			logger.info("Please Enter Item ID to update:");
			Long id = Long.parseLong(getInput());
			logger.info("Please enter a name:");
			String name = getInput();
			logger.info("Please enter a value:");
			Double value = Double.parseDouble(getInput());
			item = new Item(id, name, value);
			itemService.update(item);
		} catch (NumberFormatException e) {
			logger.error(e.toString());
			logger.info("An error occured while completeing the action, please check the log files");
		}
		return item;

	}

	/**
	 *
	 */
	@Override
	public void delete() {
		logger.info("Please Enter Item ID to delete:");
		Long id = Long.parseLong(getInput());
		itemService.delete(new Item(id));
	}

}
