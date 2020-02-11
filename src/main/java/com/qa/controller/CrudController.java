package com.qa.controller;

public interface CrudController<T> {

	void readAll();

	void readOne();

	void create();

	void update();

	void delete();

}
