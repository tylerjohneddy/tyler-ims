package com.qa.ims;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.persistence.domain.Item;

public class ItemTest {
	private static final Item item = new Item(1l, "chocolate", 1.99);
	private static final Item item2 = new Item(1L,1L);

	@Test
	public void itemSetterGetterTest() {
		item.setId(2L);
		item.setName("cake");
		item.setValue(2.99);

		assertEquals(2, item.getId(),0);
		assertEquals("cake", item.getName());
		assertEquals(2.99, item.getValue(), 0.0001);
		assertEquals(1L, item2.getQuantity(),0);

	}
	@Test
	public void itemHashCodeTest() {
		assertEquals(-128859143, item.hashCode());
		
	}

	

}
