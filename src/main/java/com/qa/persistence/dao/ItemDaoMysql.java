package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Item;
import com.qa.utils.Config;
import com.qa.utils.Utils;

/**
 * @author Tyler
 *
 */
public class ItemDaoMysql implements Dao<Item> {

	private Utils utils = new Utils();
	private Config config = new Config();

	/** 
	 *
	 */
	@Override
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword()); Statement statement = connection.createStatement()) {
			statement.executeUpdate(
					String.format("INSERT INTO items VALUES(null,'%s','%s');", item.getName(), item.getValue()));
		} catch (Exception e) {
			Utils.errorPrint(e);

		}
		return null;

	}

	/**
	 *
	 */
	@Override
	public List<String> readAll() {
		List<String> item = null;
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword());
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items;")) {
			item = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			Utils.errorPrint(e);
		}

		return item;
	}

	/**
	 *
	 */
	@Override
	public Item update(Item item) {
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword()); Statement statement = connection.createStatement()) {
			statement.executeUpdate(String.format("UPDATE items set name = '%s',value = '%s' WHERE id='%s';",
					item.getName(), item.getValue(), item.getId()));
		} catch (Exception e) {
			Utils.errorPrint(e);
		}
		return item;

	}

	/**
	 *
	 */
	@Override
	public void delete(Item item) {
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword()); Statement statement = connection.createStatement()) {
			statement.executeUpdate(String.format("DELETE FROM items WHERE ID = '%s';", item.getId()));

		} catch (Exception e) {
			Utils.errorPrint(e);
		}

	}

	/**
	 *
	 */
	@Override
	public Item readOne(Item item) {
		Item returnItem = null;
		try (Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(),
				config.getPassword());
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery(String.format("select * from items where id = '%s'", item.getId()))) {
			resultSet.next();

			Long id = resultSet.getLong("id");
			String name = resultSet.getString("name");
			Double value = resultSet.getDouble("value");
			returnItem = new Item(id, name, value);
		} catch (Exception e) {
			Utils.errorPrint(e);
		}
		return returnItem;
	}

}
