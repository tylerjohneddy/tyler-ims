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
	public static final Logger logger = Logger.getLogger(OrderController.class);

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
			logger.info(order);
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
		logger.info("Please enter a the customers ID:");
		Long customerId = Long.parseLong(getInput());
		ArrayList<Item> itemList = new ArrayList<>();
		Long itemId = 0L;

		while (true) {
			logger.info("Please enter a the item ID to add, enter -1 to complete order:");
			itemId = Long.parseLong(getInput());
			if (itemId == -1) {
				break;
			}
			ItemController itemController = new ItemController(itemServices);
			try {
				Item item = itemController.readOne(new Item(itemId));
				if (item.getId() > 0) {

					logger.info("Please enter a the item  to quantity add:");
					item.setQuantity(Long.parseLong(getInput()));
					itemList.add(item);
				}
			}

			catch (Exception e) {
				Utils.errorPrint(e);

			}

		}
		
		return orderService.create(new Order(customerId, itemList));
		

	}

	/**
	 *
	 */
	@Override
	public Order update() {
		logger.info("Please enter the order ID:");
		Order order = new Order(Long.parseLong(getInput()));
		logger.info("Please enter the item ID:");
		Item item = new Item(Long.parseLong(getInput()));
		logger.info("Please enter the new quantity:");
		item.setQuantity(Long.parseLong(getInput()));
		ArrayList<Item> items = new ArrayList<>();
		items.add(item);
		order.setItemList(items);
		return orderService.update(order);

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
		logger.info("Please Enter Order ID to delete:");
		Long id = Long.parseLong(getInput());
		logger.info("Confirm deletion of : ");
		orderService.readOne(new Order(id));
		if (id == Long.parseLong(getInput())) {
			orderService.delete(new Order(id));
		}
	}

}
