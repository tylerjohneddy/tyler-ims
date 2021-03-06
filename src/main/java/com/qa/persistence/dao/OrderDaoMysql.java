package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;
import com.qa.utils.Config;
import com.qa.utils.Utils;

/**
 * @author Tyler
 *
 */
public class OrderDaoMysql implements Dao<Order> {

	public static final Logger logger = Logger.getLogger(OrderDaoMysql.class);
	private Utils utils = new Utils();
	private Config config = new Config();

	/**
	 *
	 */
	@Override
	public Order create(Order order) {
		ResultSet resultSet = null;

		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword()); Statement statement = connection.createStatement()) {
			statement.executeUpdate(String.format("INSERT INTO orders values(null,'%s','%s','%s',now());",
					order.getCost(), order.getCustomerId(), order.getDiscount()), Statement.RETURN_GENERATED_KEYS);

			resultSet = statement.getGeneratedKeys();
			resultSet.next();

			order.setId((long) resultSet.getInt(1));

			addItem(order);

			updateCost(order);
			logger.info("Order created!");

		} catch (

		Exception e) {
			Utils.errorPrint(e);

		} finally {
			try {

				if (resultSet != null)

					resultSet.close();

			} catch (SQLException e) {

				Utils.errorPrint(e);
			} // end finally try

		}
			
		return null;

}

	public Order addItem(Order order) {
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword()); Statement statement = connection.createStatement()) {
			for (Item item : order.getItemList()) {
				statement.executeUpdate(String.format("INSERT INTO item_order values(null,'%s','%s','%s','%s');",
						order.getId(), item.getId(), item.getValue(), item.getQuantity()));
			}
		} catch (Exception e) {
			Utils.errorPrint(e);

		}

		return null;

	}

	public Order calcCost(Order order) {
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword());
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(String.format(
						"SELECT SUM(item_quantity * sold_cost) from item_order where order_id = %s;", order.getId()))) {
			resultSet.next();
			order.setCost(resultSet.getDouble(1));

		} catch (Exception e) {
			Utils.errorPrint(e);

		}

		return order;

	}

	/**
	 *
	 */
	@Override
	public List<String> readAll() {
		List<String> order = null;
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword());
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orders;")) {
			order = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			Utils.errorPrint(e);
		}
		return order;
	}

	/**
	 *
	 */
	public Order updateCost(Order order) {
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword())) {
			Order orderCost = calcCost(order);
			if (orderCost.getCost() >= 10000) {

				orderCost.setDiscount(orderCost.getCost() * 0.1);
				orderCost.setCost(orderCost.getCost() * 0.9);

			}

			try (Statement statement = connection.createStatement()) {
				statement.executeUpdate(String.format("UPDATE orders SET cost = '%s', discount = '%s' WHERE id='%s';",
						orderCost.getCost(), orderCost.getDiscount(), orderCost.getId()));
			}

		} catch (Exception e) {
			Utils.errorPrint(e);
		}
		return null;

	}

	/**
	 *
	 */
	@Override
	public void delete(Order order) {
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword()); Statement statement = connection.createStatement()) {

			statement.executeUpdate(String.format("DELETE from item_order WHERE id = '%s';", order.getId()));
			statement.executeUpdate(String.format("DELETE from orders WHERE id = '%s';", order.getId()));

		} catch (Exception e) {
			Utils.errorPrint(e);
		}

	}

	/**
	 *
	 */
	@Override
	public Order readOne(Order order) {

		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword());
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery(String.format("select * from orders where id = '%s';", order.getId()))) {
			for (String row : utils.resultSetToArrayList(resultSet)) {
				logger.info(row);
			}
		} catch (Exception e) {
			Utils.errorPrint(e);
		}
		return null;

	}

	@Override
	public Order update(Order order) {
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword()); Statement statement = connection.createStatement()) {
			Item item = order.getItemList().get(0);
			statement.executeUpdate(
					String.format("UPDATE item_order set item_quantity = '%s' WHERE order_id='%s' AND item_id = '%s';",
							item.getQuantity(), order.getId(), item.getId()));
			updateCost(order);
		} catch (Exception e) {
			Utils.errorPrint(e);
		}
		return null;
	}

}
