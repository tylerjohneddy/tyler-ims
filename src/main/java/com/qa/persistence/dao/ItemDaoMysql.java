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

public class ItemDaoMysql implements Dao<Item> {
	private final Logger logger = Logger.getLogger(ItemDaoMysql.class);
	private Statement statement = null;
	private ResultSet resultSet = null;
	private Utils utils = new Utils();

	@Override
	public Item create(Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO items VALUES(null,'%s','%s','%s');", item.getName(),
					item.getValue(), item.getInStock()));
		} catch (Exception e) {
			Utils.errorPrint(e);

		} finally {
			utils.close(statement, resultSet);
		}
		return null;

	}

	@Override
	public List<String> readAll() {
		List<String> item = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM items;");
			item = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			utils.close(statement, resultSet);
		}

		return item;
	}

	@Override
	public Item update(Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(
					String.format("UPDATE items set name = '%s',value = '%s',in_stock = '%s' WHERE id='%s';",
							item.getName(), item.getValue(), item.getInStock(), item.getId()));
		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			utils.close(statement, resultSet);
		}
		return item;

	}

	@Override
	public void delete(Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(String.format("DELETE FROM items WHERE ID = '%s';", item.getId()));

		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			utils.close(statement, resultSet);
		}

	}

	@Override
	public void readOne(Item item) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(String.format("select * from item where id = '%s'", item.getId()));
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
