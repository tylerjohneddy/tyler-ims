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

	public String getInput() {
		return Utils.getInput();
	}

	@Override
	public void readAll() {
		for (String order : orderService.readAll()) {
			LOGGER.info(order);
		}
	}

	@Override
	public void readOne() {
		Long id = Long.parseLong(getInput());
		orderService.readOne(new Order(id));
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a the customers ID:");
		Long customerId = Long.parseLong(getInput());
		Long[][] item = null;
		Long itemId = null;
		Long itemQuantity = 0L;

		for (Long i = 1L; i != -1; i = Long.parseLong(getInput())) {
			LOGGER.info("Please enter a the item ID to add:");
			itemId = Long.parseLong(getInput());
			itemService.readOne(new Item(itemId));
			LOGGER.info("Please enter a the item ID to add:");
			itemId = Long.parseLong(getInput());
			LOGGER.info("Please enter a the item  to quantity add:");
			itemQuantity = Long.parseLong(getInput());

		}
		orderService.create(new Order(customerId, item));
		LOGGER.info("Order created");
		return null;

		// "INSERT INTO item_order VALUES(null,order_id,item_id,quantity);"
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter a the order ID:");
		Long orderId = Long.parseLong(getInput());
		LOGGER.info("Please enter a the item ID:");
		Long itemId = Long.parseLong(getInput());
		LOGGER.info("Please enter a the new quanitity:");
		Long itemQuantity = Long.parseLong(getInput());
		return null;

		// orderService.update(new Order(orderId,itemId,itemQuantity));
	}

	@Override
	public void delete() {
		LOGGER.info("Please Enter Order ID to delete:");
		Long id = Long.parseLong(getInput());
		LOGGER.info("Confirm deletion of : ");
		orderService.readOne(new Order(id));
		if (id == Long.parseLong(getInput())) {
			orderService.delete(new Order(id));
		}
	}

}
