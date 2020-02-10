package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer;

public class CustomerServices implements CrudServices<Customer> {

	Dao<Customer> customerDao;
	
	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}
	
	public List<String> readAll() {
		return customerDao.readAll();
	}

	public void create(Customer customer) {
		customerDao.create(customer);
	}

	public void update(long id, Customer customer) {
		customerDao.update(id, customer);
		
	}

	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}

	public String readOne(Customer customer) {
		return customerDao.readOne(customer);
	}

}
