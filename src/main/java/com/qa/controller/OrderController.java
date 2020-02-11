package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;
import com.qa.services.CrudServices;
import com.qa.utils.Utils;

public class OrderController implements CrudController<Order> {
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;
	private CrudServices<Item> itemService;

	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}

	@Override
	public void readAll() {
		for (String order : orderService.readAll()) {
			LOGGER.info(order.toString());
		}
	}

	@Override
	public void readOne() {
		Long id = Long.parseLong(Utils.getInput());
		orderService.readOne(new Order(id));
	}

	@Override
	public void create() {
		LOGGER.info("Please enter a the customers ID:");
		Long customerId = Long.parseLong(Utils.getInput());
		Long[][] item = null;
		Long itemId = null;
		int itemQuantity = 0;

		for (Long i = 1L; i != -1; i = Long.parseLong(Utils.getInput())) {
			LOGGER.info("Please enter a the item ID to add:");
			itemId = Long.parseLong(Utils.getInput());
			itemService.readOne(new Item(itemId));
			LOGGER.info("Please enter a the item ID to add:");
			itemId = Long.parseLong(Utils.getInput());

		}
		orderService.create(new Order(customerId, item));
		LOGGER.info("Order created");

		// "INSERT INTO item_order VALUES(null,order_id,item_id,quantity);"
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter a the order ID:");
		Long orderId = Long.parseLong(Utils.getInput());
		LOGGER.info("Please enter a the item ID:");
		Long itemId = Long.parseLong(Utils.getInput());
		LOGGER.info("Please enter a the new quanitity:");
		Long itemQuantity = Long.parseLong(Utils.getInput());
		return null;

		// orderService.update(new Order(orderId,itemId,itemQuantity));
	}

	@Override
	public void delete() {
		LOGGER.info("Please Enter Order ID to delete:");
		Long id = Long.parseLong(Utils.getInput());
		LOGGER.info("Confirm deletion of : ");
		orderService.readOne(new Order(id));
		if (id == Long.parseLong(Utils.getInput())) {
			orderService.delete(new Order(id));
		}
	}

}
