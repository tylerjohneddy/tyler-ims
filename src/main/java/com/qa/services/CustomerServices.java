package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer;

public class CustomerServices implements CrudServices<Customer> {

	Dao<Customer> customerDao;

	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<String> readAll() {
		return customerDao.readAll();
	}

	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
	}

	@Override
	public Customer update(Customer customer) {
		return customerDao.update(customer);

	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);

	}

	@Override
	public void readOne(Customer customer) {
		customerDao.readOne(customer);
	}

}
