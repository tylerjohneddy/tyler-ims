package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.utils.Config;
import com.qa.utils.Utils;

public class CustomerDaoMysql implements Dao<Customer> {

	private final Logger LOGGER = Logger.getLogger(CustomerDaoMysql.class);
	private Statement statement = null;
	private ResultSet resultSet = null;
	private Utils utils = new Utils();

	@Override
	public List<String> readAll() {
		List<String> customer = null;
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from customers;");
			Utils utils = new Utils();
			customer = utils.resultSetToArrayList(resultSet);
		} catch (Exception e) {
			Utils.errorPrint(e);

		} finally {
			utils.close(statement,resultSet);
		}

		return customer;
	}

	@Override
	public Customer create(Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(String.format("INSERT INTO customers values(null,'%s','%s');",
					customer.getFirstName(), customer.getSurname()));

		} catch (Exception e) {
			Utils.errorPrint(e);

		} finally {
			utils.close(statement,resultSet);		}
		return null;
	}

	@Override
	public Customer update(Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(String.format("UPDATE customers set forename = '%s', surname = '%s' WHERE id=%s;",
					customer.getFirstName(), customer.getSurname(), customer.getId()));
		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			utils.close(statement,resultSet);		}
		return null;

	}

	@Override
	public void delete(Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			statement.executeUpdate(String.format("DELETE from customers WHERE id = '%s';", customer.getId()));

		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {
			utils.close(statement, resultSet);
		}

	}

	@Override
	public void readOne(Customer customer) {
		try (Connection connection = DriverManager.getConnection(Config.url, Config.username, Config.password)) {
			statement = connection.createStatement();
			resultSet = statement

					.executeQuery(String.format("select * from customers where id = %s", customer.getId()));
			Utils utils = new Utils();
			for (String row : utils.resultSetToArrayList(resultSet)) {
				LOGGER.info(row);
			}

		} catch (Exception e) {
			Utils.errorPrint(e);
		} finally {

			utils.close(statement, resultSet);
		}

	}


}
