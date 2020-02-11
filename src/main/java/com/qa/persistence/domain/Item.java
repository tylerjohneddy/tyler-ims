package com.qa.persistence.domain;

/**
 * @author Tyler
 *
 */
public class Item {
	private Long id;
	private String name;
	private double value;
	private int inStock;

	/**
	 * @param id
	 * @param name
	 * @param value
	 * @param inStock
	 */
	public Item(Long id, String name, double value, int inStock) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.inStock = inStock;
	}

	/**
	 * @param name
	 * @param value
	 * @param inStock
	 */
	public Item(String name, double value, int inStock) {

		this.name = name;
		this.value = value;
		this.inStock = inStock;
	}

	/**
	 * @param id
	 */
	public Item(Long id) {
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
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return
	 */
	public int getInStock() {
		return inStock;
	}

	/**
	 * @param inStock
	 */
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	/**
	 *
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + inStock;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inStock != other.inStock)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

}
