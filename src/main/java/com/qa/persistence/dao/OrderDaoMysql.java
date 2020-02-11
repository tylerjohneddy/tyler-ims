package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Order;
import com.qa.utils.Config;
import com.qa.utils.Utils;



public class OrderDaoMysql implements Dao<Order> {
	
	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);


	@Override
	public void create(Order order) {
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO orders values(null,'%s','%s','%s',now());", order.getCost(),
					order.getCustomerId(), order.getDiscount()));

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completing the action, please check the log files");

		}

	}

	@Override
	public List<String> readAll() {
		List<String> order = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders;");
			Utils utils = new Utils();
			order = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			LOGGER.error(e.toString());

		}

		return order;
	}

	@Override
	public void update(Order order) {
		
	}

	@Override
	public void delete(Order order) {
		
	}

	@Override
	public String readOne(Order t) {
		return null;
	}





}
