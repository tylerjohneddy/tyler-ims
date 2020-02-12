package com.qa.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.persistence.dao.ItemDaoMysql;
import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;
import com.qa.services.CrudServices;
import com.qa.services.ItemServices;
import com.qa.utils.Utils;

/**
 * @author Tyler
 *
 */
public class OrderController implements CrudController<Order> {
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderService;
	private CrudServices<Item> itemServices;

	/**
	 * @param orderService
	 */
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
		this.itemServices = new ItemServices(new ItemDaoMysql());
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
		for (String order : orderService.readAll()) {
			LOGGER.info(order);
		}
	}

	/**
	 *
	 */
	@Override
	public Order readOne(Order order) {
		Long id = Long.parseLong(getInput());
		return orderService.readOne(new Order(id));
	}

	/**
	 *
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a the customers ID:");
		Long customerId = Long.parseLong(getInput());
		ArrayList<Item> itemList = new ArrayList<>();
		Long itemId = 0L;

		while (true) {
			LOGGER.info("Please enter a the item ID to add, enter -1 to complete order:");
			itemId = Long.parseLong(getInput());
			if (itemId == -1) {
				break;
			}
			ItemController itemController = new ItemController(itemServices);
			Item item = itemController.readOne(new Item(itemId));

			// itemService.readOne(new Item(itemId));
			LOGGER.info("Please enter a the item  to quantity add:");
			item.setQuantity(Long.parseLong(getInput()));
			itemList.add(item);

		}

		return orderService.create(new Order(customerId, itemList));

	}

	/**
	 *
	 */
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

	public Order update(Order order) {

		return orderService.update(order);

		// orderService.update(new Order(orderId,itemId,itemQuantity));
	}

	/**
	 *
	 */
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
