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

/**
 * @author Tyler
 *
 */
public class OrderDaoMysql implements Dao<Order> {

	public static final Logger logger = Logger.getLogger(OrderDaoMysql.class);
	private Statement statement = null;
	private ResultSet resultSet = null;
	private Utils utils = new Utils();

	/**
	 *
	 */
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
			utils.close(statement, resultSet);
		}
		return null;

	}

	/**
	 *
	 */
	@Override
	public List<String> readAll() {
		List<String> order = null;
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from orders;");
			order = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			utils.close(statement, resultSet);
		}

		return order;
	}

	/**
	 *
	 */
	@Override
	public Order update(Order order) {
		return null;

	}

	/**
	 *
	 */
	@Override
	public void delete(Order order) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();

			statement.executeUpdate(String.format("DELETE from item_order WHERE id = '%s';", order.getId()));
			statement.executeUpdate(String.format("DELETE from order WHERE order_id = '%s';", order.getId()));

		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			utils.close(statement, resultSet);
		}

	}

	/**
	 *
	 */
	@Override
	public void readOne(Order order) {

		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(String.format("select * from orders where id = '%s';", order.getId()));
			for (String row : utils.resultSetToArrayList(resultSet)) {
				logger.info(row);
			}
		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			utils.close(statement, resultSet);
		}

	}

}
