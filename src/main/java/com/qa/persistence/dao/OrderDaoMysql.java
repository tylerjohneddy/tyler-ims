package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Order;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class OrderDaoMysql implements Dao<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderDaoMysql.class);
	private Statement statement = null;
	private ResultSet resultSet = null;

	@Override
	public Order create(Order order) {

		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO orders values(null,'%s','%s','%s',now());",
					order.getCost(), order.getCustomerId(), order.getDiscount()));
			for (int i = 0; i >= order.getItem().length;) {
				break;

			}

		} catch (Exception e) {
			Utils.errorPrint(e);

		} finally {
			close();
		}
		return null;

	}

	@Override
	public List<String> readAll() {
		List<String> order = null;
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from orders;");
			Utils utils = new Utils();
			order = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			close();
		}

		return order;
	}

	@Override
	public Order update(Order order) {
		return null;

	}

	@Override
	public void delete(Order order) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();

			statement.executeUpdate(String.format("DELETE from item_order WHERE id = '%s';", order.getId()));
			statement.executeUpdate(String.format("DELETE from order WHERE order_id = '%s';", order.getId()));

		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			close();
		}

	}

	@Override
	public void readOne(Order order) {

		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(String.format("select * from orders where id = '%s';", order.getId()));
			Utils utils = new Utils();
			for (String row : utils.resultSetToArrayList(resultSet)) {
				LOGGER.info(row);
			}
		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			close();
		}

	}

	public void close() {
		try {

			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			Utils.errorPrint(e);
		} // nothing we can do
		try {

			if (resultSet != null)

				resultSet.close();

		} catch (SQLException e) {

			Utils.errorPrint(e);
		} // end finally try

	}

}
