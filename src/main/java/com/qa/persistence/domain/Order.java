package com.qa.persistence.domain;

public class Order {
	private int id;
	private double cost;
	private int customerId;
	private int discount;

	/**
	 * @param id
	 * @param cost
	 * @param customerId
	 * @param discount
	 */
	public Order(int id, double cost, int customerId, int discount) {
		this.id = id;
		this.cost = cost;
		this.customerId = customerId;
		this.discount = discount;
	}

	/**
	 * @param cost
	 * @param customerId
	 * @param discount
	 */
	public Order(double cost, int customerId, int discount) {
		

		this.cost = cost;
		this.customerId = customerId;
		this.discount = discount;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
