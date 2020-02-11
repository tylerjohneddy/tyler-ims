package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Item;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class ItemDaoMysql implements Dao<Item> {
	public static final Logger LOGGER = Logger.getLogger(ItemDaoMysql.class);
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	@Override
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO items VALUES(null,'%s','%s','%s');", item.getName(),
					item.getValue(), item.getInStock()));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completeing the action, please check the log files");

		}finally {
			close();
		}
		return null;

	}

	@Override
	public List<String> readAll() {
		List<String> item = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM items;");
			Utils utils = new Utils();
			item = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			LOGGER.error(e.toString());

		}finally {
			close();
		}

		return item;
	}

	@Override
	public Item update(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(
					String.format("UPDATE items set name = '%s',value = '%s',in_stock = '%s' WHERE id='%s';",
							item.getName(), item.getValue(), item.getInStock(), item.getId()));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completeing the action, please check the log files");

		}finally {
			close();
		}
		return item;

	}

	@Override
	public void delete(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(String.format("DELETE FROM items WHERE ID = '%s';", item.getId()));

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completeing the action, please check the log files");

		}finally {
			close();
		}

	}

	@Override
	public void readOne(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery(String.format("select * from item where id = '%s'", item.getId()));
			Utils utils = new Utils();
			for (String row : utils.resultSetToArrayList(resultSet)) {
				LOGGER.info(row);
			}
		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completeing the action, please check the log files");


		}finally {
			close();
		}
	}
	public void close() {
		try {

			if (statement != null)
				statement.close();

		} catch (SQLException se2) {
			se2.printStackTrace();
		} // nothing we can do
		try {

			if (resultSet != null)

				resultSet.close();

		} catch (SQLException se) {

			se.printStackTrace();

		} // end finally try

	}

}
