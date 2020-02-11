package com.qa.ims;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.persistence.domain.Order;


public class OrderTest {
	private static final Order order = new Order(3l, 9.99, 1l, 10);

	@Test
	public void orderSetterGetterTest() {

		order.setId(1l);
		order.setCost(6.39);
		order.setCustomerId(4l);
		order.setDiscount(90);
		//assertEquals(1,order.getId());
		assertEquals(6.39,order.getCost(),0.001);
		//assertEquals(4, order.getCustomerId());
		assertEquals(90, order.getDiscount());

	}

}
