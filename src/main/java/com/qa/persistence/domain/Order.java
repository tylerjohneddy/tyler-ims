package com.qa.persistence.domain;

import java.util.ArrayList;

/**
 * @author Tyler
 *
 */
public class Order {
	private Long id;
	private double cost;
	private Long customerId;
	private double discount;
	private String dateTime;
	ArrayList<Item> itemList;

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

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
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

	/**
	 * @param id
	 */
	public Order(Long id) {
		this.id = id;

	}

	public Order(Long customerId, ArrayList<Item> itemList) {
		this.customerId = customerId;
		this.itemList = itemList;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
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
	public double getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((dateTime == null) ? 0 : dateTime.hashCode());
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
			return false;
		return true;
	}
}
