package com.qa.persistence.dao;

import java.util.List;

import com.qa.persistence.domain.Item;


public class ItemDaoMysql implements Dao<Item> {

	@Override
	public void create(Item item) {
		String sql = String.format("INSERT INTO items VALUES(null,%s,%s,%s);", item.getName(), item.getValue(),item.getInStock());
		//new Mysql().create(sql);
		
	}

	@Override
	public List<String> readAll() {
		String sql = "SELECT * FROM items;";
		//new Mysql().read(sql);
		
		return null;
	}


	@Override
	public void update(long id, Item item) {
		// TODO Auto-generated method stub
		String sql = String.format("UPDATE items(name,value,quantity) set VALUES(%s,%s,%s) WHERE id=%s;", item.getId(), item.getName(), item.getValue(),
				item.getInStock());
		//new Mysql().update(sql);
		
	}

	@Override
	public void delete(Item item) {
		// TODO Auto-generated method stub
		String sql = String.format("DELETE FROM items WHERE ID = %s;", item.getId());
		//new Mysql().delete(sql);
		
	}

}
