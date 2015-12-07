package com.ryanwemmer.options.pojo;

import java.io.Serializable;

public class Suppliers implements Serializable{

	int id;
	String supplierName;
	String billingStreetPOBox;
	String billingCity;
	String billingState;
	String billingCountry;
	String billingZip;
	public int getId() {
		return id;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public String getBillingStreetPOBox() {
		return billingStreetPOBox;
	}
	public String getBillingCity() {
		return billingCity;
	}
	public String getBillingState() {
		return billingState;
	}
	public String getBillingCountry() {
		return billingCountry;
	}
	public String getBillingZip() {
		return billingZip;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public void setBillingStreetPOBox(String billingStreetPOBox) {
		this.billingStreetPOBox = billingStreetPOBox;
	}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	public void setBillingZip(String billingZip) {
		this.billingZip = billingZip;
	}
	
	
	
}
