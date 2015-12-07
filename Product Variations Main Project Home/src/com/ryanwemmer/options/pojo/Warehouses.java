package com.ryanwemmer.options.pojo;

import java.io.Serializable;

public class Warehouses implements Serializable{

	int id;
	int supplierId;
	String street;
	String city;
	String state;
	String country;
	String zipCode;
	String dateCreated;
	String dateModified;
	
	
	public int getId() {
		return id;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getCountry() {
		return country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

}
