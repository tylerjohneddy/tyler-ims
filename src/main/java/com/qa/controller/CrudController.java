package com.qa.controller;

public interface CrudController<T> {

	void readAll();

	void readOne();

	T create();

	T update();

	void delete();

}
