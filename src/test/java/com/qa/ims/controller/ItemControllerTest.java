package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.controller.ItemController;
import com.qa.persistence.domain.Item;
import com.qa.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private ItemServices itemServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void createTest() {
		String name = "item";
		String value = "9.00";
		String inStock = "8";
		Mockito.doReturn(name, value, inStock).when(itemController).getInput();
		Item item = new Item(name, 9.00, 8);
		Item savedItem = new Item(1L, name, 9.00, 8);
		Mockito.when(itemServices.create(item)).thenReturn(savedItem);
		assertEquals(savedItem, itemController.create());
	}

//	@Test
//	public void updateTest() {
//		String id = "1";
//		String firstName = "Rhys";
//		String surname = "Thompson";
//		Mockito.doReturn(id, firstName, surname).when(customerController).getInput();
//		Customer customer = new Customer(1L, firstName, surname);
//		Mockito.when(customerServices.update(customer)).thenReturn(customer);
//		assertEquals(customer, customerController.update());
//	}

	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(new Item(1L));
	}
}
