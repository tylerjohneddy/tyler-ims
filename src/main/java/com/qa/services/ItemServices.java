package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Item;

public class ItemServices implements CrudServices<Item> {

	Dao<Item> itemDao;

	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}

	@Override
	public List<String> readAll() {
		return itemDao.readAll();
	}

	@Override
	public Item create(Item item) {
		return itemDao.create(item);

	}

	@Override
	public Item update(Item item) {
		return itemDao.update(item);
	}

	@Override
	public void delete(Item item) {
		itemDao.delete(item);
	}

	@Override
	public void readOne(Item item) {
		itemDao.readOne(item);
	}

}
