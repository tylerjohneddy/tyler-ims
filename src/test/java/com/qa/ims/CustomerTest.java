package com.qa.ims;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.persistence.domain.Customer;



public class CustomerTest {
	private static final Customer customer = new Customer(6l, "old", "older");
	@Test
	public void customerSetterGetterTest() {
		customer.setFirstName("Tyler");
		customer.setSurname("Eddy");
		customer.setId(1l);
		assertEquals("Tyler", customer.getFirstName());
		assertEquals("Eddy", customer.getSurname());
		//assertEquals(1, customer.getId());
	}
	@Test
	public void customerHashCodeTest() {
		assertEquals(211681940, customer.hashCode());
	}
	@Test
	public void customerToStringTest() {
		assertEquals("id:6 first name:old surname:older", customer.toString());
		
	}
	


}
