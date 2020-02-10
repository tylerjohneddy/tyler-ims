package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Item;
import com.qa.utils.Config;

public class ItemDaoMysql implements Dao<Item> {
	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	@Override
	public void create(Item item) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO items VALUES(null,%s,%s,%s);", item.getName(),
					item.getValue(), item.getInStock()));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completeing the action, please check the log files");

		}

	}

	@Override
	public List<String> readAll() {
		String sql = "SELECT * FROM items;";
		// new Mysql().read(sql);

		return null;
	}

	@Override
	public void update(Item item) {
		String sql = String.format("UPDATE items(name,value,quantity) set VALUES(%s,%s,%s) WHERE id=%s;", item.getId(),
				item.getName(), item.getValue(), item.getInStock());
		// new Mysql().update(sql);

	}

	@Override
	public void delete(Item item) {
		String sql = String.format("DELETE FROM items WHERE ID = %s;", item.getId());
		// new Mysql().delete(sql);

	}

	@Override
	public String readOne(Item item) {
		return null;
	}

}
