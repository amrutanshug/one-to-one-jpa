package com.test.response.entity;

public class AddressModel {
	private Long addressProofId;
	private String houseNo;
	private String street;
	private String city;
	private String state;
	private String country;
	
	public AddressModel() {
		
	}
	
	public AddressModel(Long addressProofId, String houseNo, String street, String city, String state, String country) {
		super();
		this.addressProofId = addressProofId;
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public Long getAddressProofId() {
		return addressProofId;
	}
	public void setAddressProofId(Long addressProofId) {
		this.addressProofId = addressProofId;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AddressModel [addressProofId=" + addressProofId + ", houseNo=" + houseNo + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressProofId == null) ? 0 : addressProofId.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((houseNo == null) ? 0 : houseNo.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
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
		AddressModel other = (AddressModel) obj;
		if (addressProofId == null) {
			if (other.addressProofId != null)
				return false;
		} else if (!addressProofId.equals(other.addressProofId))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (houseNo == null) {
			if (other.houseNo != null)
				return false;
		} else if (!houseNo.equals(other.houseNo))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	
	
}
