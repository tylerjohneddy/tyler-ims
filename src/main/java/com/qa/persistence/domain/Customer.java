package com.qa.persistence.domain;

/**
 * @author Tyler
 *
 */
public class Customer {

	private Long id;
	private String firstName;
	private String surname;

	/**
	 * @param firstName
	 * @param surname
	 */
	public Customer(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
	}

	/**
	 * @param id
	 * @param firstName
	 * @param surname
	 */
	public Customer(Long id, String firstName, String surname) {
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
	}

	/**
	 * @param id
	 */
	public Customer(Long id) {
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
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "id:" + id + " first name:" + firstName + " surname:" + surname;
	}

	/**
	 *
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
				return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
				return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
				return false;
		return true;
	}

}
