package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;

import com.qa.persistence.domain.Item;

public class ItemServices implements CrudServices<Item> {
	
	Dao<Item> itemDao;

	public ItemServices(Dao<Item> ItemDao) {
		this.itemDao = ItemDao;
	}

	@Override
	public List<String> readAll() {
		return itemDao.readAll();
	}

	@Override
	public void create(Item item) {
		itemDao.create(item);

	}

	@Override
	public void update(Item item) {
		itemDao.update(item);
	}

	@Override
	public void delete(Item item) {
		itemDao.delete(item);
	}

	@Override
	public String readOne(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

}
