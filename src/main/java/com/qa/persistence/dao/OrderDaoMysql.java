package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Order;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class OrderDaoMysql implements Dao<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);

	@Override
	public Order create(Order order) {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO orders values(null,'%s','%s','%s',now());",
					order.getCost(), order.getCustomerId(), order.getDiscount()));
			for (int i = 0; i >= order.getItem().length; i++) {

			}

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completing the action, please check the log files");

		}
		return null;

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
	public Order update(Order order) {
		return null;

	}

	@Override
	public void delete(Order order) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();

			statement.executeUpdate(String.format("DELETE from item_order WHERE id = '%s';", order.getId()));
			statement.executeUpdate(String.format("DELETE from order WHERE order_id = '%s';", order.getId()));

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completing the action, please check the log files");

		}

	}

	@Override
	public void readOne(Order order) {
		// Order returnedOrder = null;

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery(String.format("select * from orders where id = '%s';", order.getId()));
			Utils utils = new Utils();
			for (String row : utils.resultSetToArrayList(resultSet)) {
				LOGGER.info(row);
			}
//			while (resultSet.next()) {
//				Long id = resultSet.getLong("id");
//				Double cost = resultSet.getDouble("cost");
//				Long customerId = resultSet.getLong("customer_id");
//				int discount = resultSet.getInt("discount");
//				String dateTime = resultSet.getString("date_time");
//				returnedOrder = new Order(id, cost, customerId, discount, dateTime);
//			}
		} catch (Exception e) {
			LOGGER.error(e.toString());

		}

	}

}
