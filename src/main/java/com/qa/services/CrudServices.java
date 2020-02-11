package com.qa.services;

import java.util.List;

public interface CrudServices<T> {

	public List<String> readAll();

	void readOne(T t);

	void create(T t);

	void update(T t);

	void delete(T t);

}
