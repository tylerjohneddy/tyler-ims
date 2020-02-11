package com.qa.persistence.domain;

public class Order {
	private Long id;
	private double cost;
	private Long customerId;
	private int discount;
	private String dateTime;
	private Long[][] item;

	/**
	 * @param id
	 * @param cost
	 * @param customerId
	 * @param discount
	 */
	public Order(Long id, double cost, Long customerId, int discount, String dateTime) {
		this.id = id;
		this.cost = cost;
		this.customerId = customerId;
		this.discount = discount;
		this.dateTime = dateTime;
	}

	/**
	 * @param id
	 * @param cost
	 * @param customerId
	 * @param discount
	 */
	public Order(Long id, double cost, Long customerId, int discount) {
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
	public Order(double cost, Long customerId, int discount) {

		this.cost = cost;
		this.customerId = customerId;
		this.discount = discount;
	}

	public Order(Long id, Long[][] item) {
		this.id = id;
		this.item = item;
	}

	public Order(Long id) {
		this.id = id;

	}

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
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
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 */
	public void setCustomerId(Long customerId) {
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

	public Long[][] getItem() {
		return item;
	}

	public void setItem(Long[][] item) {
		this.item = item;
	}

}
