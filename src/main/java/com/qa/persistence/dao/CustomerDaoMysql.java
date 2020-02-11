package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Customer;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class CustomerDaoMysql implements Dao<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	@Override
	public List<String> readAll() {
		List<String> customer = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customers;");
			Utils utils = new Utils();
			customer = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			LOGGER.info(e.toString());

		} finally {
			close();

			
		}

		return customer;
	}

	@Override
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO customers values(null,'%s','%s');",
					customer.getFirstName(), customer.getSurname()));

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completing the action, please check the log files");

		}finally {
			close();
		}
		return null;
	}

	@Override
	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(String.format("UPDATE customers set forename = '%s', surname = '%s' WHERE id=%s;",
					customer.getFirstName(), customer.getSurname(), customer.getId()));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completing the action, please check the log files");

		}finally {
			close();
		}
		return null;

	}

	@Override
	public void delete(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(String.format("DELETE from customers WHERE id = '%s';", customer.getId()));

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completing the action, please check the log files");

		}finally {
			close();
		}

	}

	@Override
	public void readOne(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement

					.executeQuery(String.format("select * from customers where id = %s", customer.getId()));
			Utils utils = new Utils();
			for (String row : utils.resultSetToArrayList(resultSet)) {
				LOGGER.info(row);
			}


		} catch (Exception e) {
			LOGGER.error(e.toString());

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
