package com.qa.services;

import java.util.List;

public interface CrudServices<T> {

	public List<String> readAll();

	T readOne(T t);

	T create(T t);

	T update(T t);

	void delete(T t);

}
