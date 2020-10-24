package com.baizhi.empty;

public class Address {
	private Integer address_id;
	private Integer dd__user_id;
	private String address_name;
	private Integer address_zip;
	private String address_telephone;;
	private String address_phone;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Integer address_id, Integer dd__user_id,
			String address_name, Integer address_zip, String address_telephone,
			String address_phone) {
		super();
		this.address_id = address_id;
		this.dd__user_id = dd__user_id;
		this.address_name = address_name;
		this.address_zip = address_zip;
		this.address_telephone = address_telephone;
		this.address_phone = address_phone;
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", dd__user_id="
				+ dd__user_id + ", address_name=" + address_name
				+ ", address_zip=" + address_zip + ", address_telephone="
				+ address_telephone + ", address_phone=" + address_phone + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((address_id == null) ? 0 : address_id.hashCode());
		result = prime * result
				+ ((address_name == null) ? 0 : address_name.hashCode());
		result = prime * result
				+ ((address_phone == null) ? 0 : address_phone.hashCode());
		result = prime
				* result
				+ ((address_telephone == null) ? 0 : address_telephone
						.hashCode());
		result = prime * result
				+ ((address_zip == null) ? 0 : address_zip.hashCode());
		result = prime * result
				+ ((dd__user_id == null) ? 0 : dd__user_id.hashCode());
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
		Address other = (Address) obj;
		if (address_id == null) {
			if (other.address_id != null)
				return false;
		} else if (!address_id.equals(other.address_id))
			return false;
		if (address_name == null) {
			if (other.address_name != null)
				return false;
		} else if (!address_name.equals(other.address_name))
			return false;
		if (address_phone == null) {
			if (other.address_phone != null)
				return false;
		} else if (!address_phone.equals(other.address_phone))
			return false;
		if (address_telephone == null) {
			if (other.address_telephone != null)
				return false;
		} else if (!address_telephone.equals(other.address_telephone))
			return false;
		if (address_zip == null) {
			if (other.address_zip != null)
				return false;
		} else if (!address_zip.equals(other.address_zip))
			return false;
		if (dd__user_id == null) {
			if (other.dd__user_id != null)
				return false;
		} else if (!dd__user_id.equals(other.dd__user_id))
			return false;
		return true;
	}
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public Integer getDd__user_id() {
		return dd__user_id;
	}
	public void setDd__user_id(Integer dd__user_id) {
		this.dd__user_id = dd__user_id;
	}
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public Integer getAddress_zip() {
		return address_zip;
	}
	public void setAddress_zip(Integer address_zip) {
		this.address_zip = address_zip;
	}
	public String getAddress_telephone() {
		return address_telephone;
	}
	public void setAddress_telephone(String address_telephone) {
		this.address_telephone = address_telephone;
	}
	public String getAddress_phone() {
		return address_phone;
	}
	public void setAddress_phone(String address_phone) {
		this.address_phone = address_phone;
	}
	
	
}
