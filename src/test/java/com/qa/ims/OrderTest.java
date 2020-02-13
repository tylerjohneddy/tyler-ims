package com.qa.ims;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;

public class OrderTest {
	private static final Order order = new Order(3l, 9.99, 1l, 10);
	private static final Order order1 = new Order(1L, 9.99, 1L, 0, "111");
	private static final Order order2 = new Order(9.99,2L,0);


	@Test
	public void orderSetterGetterTest() {
		Item item = new Item(1L);
		item.setQuantity(1L);
		ArrayList<Item> items = new ArrayList<>();
		items.add(item);
		order.setItemList(items);

		order.setId(1l);
		order.setCost(6.39);
		order.setCustomerId(4l);
		order.setDiscount(90);
		assertEquals(1, order.getId(),0);
		assertEquals(items,order.getItemList());
		assertEquals(6.39, order.getCost(), 0.001);
		assertEquals(4, order.getCustomerId(),0);
		assertEquals(90, order.getDiscount(), 0.001);

	}

	@Test
	public void orderHashCodeTest() {
		Order order = new Order(0L);
		assertEquals(887503681, order.hashCode());
	}
}
