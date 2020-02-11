package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Customer;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class CustomerDaoMysql implements Dao<Customer> {

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	@Override
	public List<String> readAll() {
		// ArrayList<Customer> customers = new ArrayList<Customer>();
		List<String> customer = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customers;");
			Utils utils = new Utils();
			customer = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			LOGGER.info(e.toString());

		}

		return customer;
	}

	@Override
	public void create(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO customers values(null,'%s','%s');",
					customer.getFirstName(), customer.getSurname()));

		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completing the action, please check the log files");

		}
	}

	@Override
	public void update(Customer customer) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(String.format("UPDATE customers set forename = '%s', surname = '%s' WHERE id=%s;",
					customer.getFirstName(), customer.getSurname(), customer.getId()));
		} catch (Exception e) {
			LOGGER.error(e.toString());
			LOGGER.info("An error occured while completing the action, please check the log files");

		}

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

		}

	}

	@Override
	public void readOne(Customer customer) {
		Customer returnedCustomer = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.230.149.143/inventory_management",
				Config.username, Config.password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement

					.executeQuery(String.format("select * from customers where id = %s", customer.getId()));
			ResultSet temp = resultSet;
			Utils utils = new Utils();
			for (String row : utils.resultSetToArrayList(resultSet)) {
				LOGGER.info(row);
			}

//			while (resultSet.next()) {
//				Long id = resultSet.getLong("id");
//				String firstName = resultSet.getString("forename");
//				String surname = resultSet.getString("surname");
//				returnedCustomer = new Customer(id, firstName, surname);
//			}
//			

		} catch (Exception e) {
			LOGGER.error(e.toString());

		}

	}

}
