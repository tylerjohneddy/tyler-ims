package com.qa.services;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {

	@Mock
	private Dao<Order> orderDao;

	@InjectMocks
	private OrderServices orderServices;

	@Test
	public void customerServicesCreate() {
		ArrayList<Item> list = new ArrayList<>();
		Order order = new Order(1L, list);
		orderServices.create(order);
		Mockito.verify(orderDao, Mockito.times(1)).create(order);
	}

	@Test
	public void customerServicesRead() {
		orderServices.readAll();
		Mockito.verify(orderDao, Mockito.times(1)).readAll();
	}
	@Test
	public void customerServicesReadOne() {
		ArrayList<Item> list = new ArrayList<>();
		Order order = new Order(1L, list);
		orderServices.readOne(order);
		Mockito.verify(orderDao, Mockito.times(1)).readOne(order);
	}

	@Test
	public void customerServicesUpdate() {
		ArrayList<Item> list = new ArrayList<>();
		Order order = new Order(1L, list);
		orderServices.update(order);
		Mockito.verify(orderDao, Mockito.times(1)).update(order);
	}

	@Test
	public void customerServicesDelete() {
		ArrayList<Item> list = new ArrayList<>();
		Order order = new Order(1L, list);
		orderServices.delete(order);
		;
		Mockito.verify(orderDao, Mockito.times(1)).delete(order);
	}
}
