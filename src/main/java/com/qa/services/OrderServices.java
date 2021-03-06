package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Order;

/**
 * @author Tyler
 *
 */
public class OrderServices implements CrudServices<Order> {
	Dao<Order> orderDao;

	/**
	 * @param orderDao
	 */
	public OrderServices(Dao<Order> orderDao) {
		this.orderDao = orderDao;
	}

	/**
	 *
	 */
	@Override
	public List<String> readAll() {
		return orderDao.readAll();
	}

	/**
	 *
	 */
	@Override
	public Order create(Order order) {

		return orderDao.create(order);
	}

	/**
	 *
	 */
	@Override
	public Order update(Order order) {
		return orderDao.update(order);

	}

	/**
	 *
	 */
	@Override
	public void delete(Order order) {
		orderDao.delete(order);

	}

	/**
	 *
	 */
	@Override
	public Order readOne(Order order) {
		return orderDao.readOne(order);

	}

}
