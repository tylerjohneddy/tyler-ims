package com.qa.persistence.domain;

public class Item {
	private Long id;
	private String name;
	private double value;
	private int inStock;

	public Item(Long id, String name, double value, int inStock) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.inStock = inStock;
	}

	public Item(String name, double value, int inStock) {

		this.name = name;
		this.value = value;
		this.inStock = inStock;
	}

	public Item(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

}
