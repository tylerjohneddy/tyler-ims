package com.qa.persistence.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.qa.persistence.domain.Order;



public class OrderDaoMysql implements Dao<Order> {

	@Override
	public void create(Order order) {
		String sql = String.format("INSERT INTO orders values(null,%s,%s,%s,now());", order.getCost(),
				order.getCustomerId(), order.getDiscount());
		//new Mysql().create(sql);

	}

	@Override
	public List<String> readAll() {
		List<String> resultArray = new ArrayList<String>();
		String sql = "SELECT * FROM orders;";
		//ResultSet resultSet = new Mysql().read(sql);
		//Mysql mysql = new Mysql();
		//resultArray = mysql.resultSetToArrayList(resultSet);
		for (String line : resultArray) {
			System.out.println(line);
		}

		return resultArray;
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String readOne(Order t) {
		// TODO Auto-generated method stub
		return null;
	}





}
