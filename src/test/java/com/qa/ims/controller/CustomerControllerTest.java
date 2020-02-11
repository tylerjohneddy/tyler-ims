package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Customer;
import com.qa.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private CustomerServices customerServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

	@Test
	public void updateTest() {
		String id = "1";
		String firstName = "Rhys";
		String surname = "Thompson";
		Mockito.doReturn(id, firstName, surname).when(customerController).getInput();
		Customer customer = new Customer(1L, firstName, surname);
		Mockito.when(customerServices.update(customer)).thenReturn(customer);
		assertEquals(customer, customerController.update());
	}

}