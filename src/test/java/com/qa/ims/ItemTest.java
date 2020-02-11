package com.qa.ims;



import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.persistence.domain.Item;


public class ItemTest {
	private static final Item item = new Item(1l, "chocolate", 1.99, 10);
	@Test
	public void itemSetterGetterTest() {
		item.setId(2l);
		item.setName("cake");
		item.setValue(2.99);
		item.setInStock(5);
		//assertEquals(2, item.getId());
		assertEquals("cake", item.getName());
		assertEquals(2.99,item.getValue(),0.0001);
		assertEquals(5,item.getInStock());
		
		
	}

}
