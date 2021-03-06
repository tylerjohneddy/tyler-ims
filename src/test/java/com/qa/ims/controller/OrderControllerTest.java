package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.controller.OrderController;
import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;
import com.qa.persistence.domain.Order;
import com.qa.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private OrderServices orderServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private OrderController orderController;

	@Test
	public void updateTest() {
		String id = "1";
		String itemId = "1";
		String itemQuantity = "1";
		Mockito.doReturn(id, itemId, itemQuantity).when(orderController).getInput();
		Order order = new Order(1L);
		Item item = new Item(1L);
		item.setQuantity(1L);
		ArrayList<Item> items = new ArrayList<>();
		items.add(item);
		order.setItemList(items);
		Mockito.when(orderServices.update(order)).thenReturn(order);
		assertEquals(order, orderController.update());
		
		//Mockito.when(orderController.update(customer)).thenReturn(customer);
		//assertEquals(customer, orderController.update());
	}


//		order.setItemList(items);
//		return orderService.update(order);

	@Test
	public void readOneTest() {
		String id = "1";
		Mockito.doReturn(id).when(orderController).getInput();
		Order order = new Order(1L);
		Mockito.when(orderServices.readOne(order)).thenReturn(order);
		assertEquals(order, orderController.readOne(order));
	}
		
	

}
