package com.qa.controller;

import com.qa.persistence.domain.Order;
import com.qa.services.CrudServices;

public class OrderController implements CrudController<Order> {

	private CrudServices<Order> orderService;

	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}

	@Override
	public void readAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

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
