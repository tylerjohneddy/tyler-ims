package com.qa.ims.persistance;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.dao.CustomerDaoMysql;
import com.qa.utils.Config;

@RunWith(MockitoJUnitRunner.class)
public class CustomerMysqlDaoIT {
	@InjectMocks
	private CustomerDaoMysql customerDaoMysql;
	
	@Mock 
	private Config config;


	@Test
	public void testDatabaseHasValues() {
		when(config.getUrl()).thenReturn("jdbc:mysql://35.230.149.143/inventory_management");
		when(config.getUsername()).thenReturn("javaDriver");
		when(config.getPassword()).thenReturn("i-am-gROOT");
		List<String> customers = customerDaoMysql.readAll();
		assertTrue(customers.size() > 0);
	}
}
