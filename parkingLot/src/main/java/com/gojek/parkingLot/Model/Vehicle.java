package com.gojek.parkingLot.Model;

import java.io.Serializable;

public abstract class Vehicle  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String registrationNo;
	private String color;
	public Vehicle(String registrationNo, String color) {
		super();
		this.registrationNo = registrationNo;
		this.color = color;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registrationNo == null) ? 0 : registrationNo.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (registrationNo == null) {
			if (other.registrationNo != null)
				return false;
		} else if (!registrationNo.equals(other.registrationNo))
			return false;
		return true;
	}
	

}
