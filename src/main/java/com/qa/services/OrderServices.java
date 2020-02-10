package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;

import com.qa.persistence.domain.Order;


public class OrderServices implements CrudServices<Order> {
	Dao<Order> orderDao;
	
	public OrderServices(Dao<Order> OrderDao) {
		this.orderDao = OrderDao;
	}

	@Override
	public List<String> readAll() {
		return orderDao.readAll();
	}

	@Override
	public void create(Order order) {
		orderDao.create(order);
	}

	@Override
	public void update(long id, Order order) {
		orderDao.update(id, order);
		
	}

	@Override
	public void delete(Order order) {
		orderDao.delete(order);
		
	}

	@Override
	public String readOne(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

}
