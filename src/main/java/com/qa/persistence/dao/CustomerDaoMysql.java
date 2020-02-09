package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Customer;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class CustomerDaoMysql implements Dao<Customer> {
	
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	public List<String> readAll() {
		//ArrayList<Customer> customers = new ArrayList<Customer>();
		List<String> customer = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management", Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customers");
//			while (resultSet.next()) {
//				Long id = resultSet.getLong("id");
//				String firstName = resultSet.getString("first_name");
//				String surname = resultSet.getString("surname");
//				Customer customer = new Customer(id, firstName, surname);
//				customers.add(customer);
//			}
			Utils utils = new Utils();
			customer = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			
		}
		
		
		return customer;
	}

	public void create(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management", Config.username, Config.password)){
			Statement statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO customers values(null,'%s','%s');",customer.getFirstName(), customer.getSurname()));
		
		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completeing the action, please check the log files");
			
		} 
	}

	public void update(long id, Customer customer) {

	}

	public void delete(Customer customer) {

	}




}
