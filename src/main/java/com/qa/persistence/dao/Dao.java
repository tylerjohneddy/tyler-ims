package com.qa.persistence.dao;

import java.util.List;

public interface Dao<T> {

	List<String> readAll();

	T readOne(T t);

	T create(T t);

	T update(T t);

	void delete(T t);

}
