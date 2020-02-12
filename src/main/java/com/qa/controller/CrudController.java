package com.qa.controller;

public interface CrudController<T> {

	void readAll();

	T readOne(T t);

	T create();

	T update();

	void delete();

}
