package com.ryanwemmer.options.pojo;

import java.io.Serializable;

public class AttributeValues implements Serializable{
	int id;
	int attributeId;
	int productId;
	String value;
	String dateCreated;
	String dateModified;
	
	
	
	public int getId() {
		return id;
	}
	public int getAttributeId() {
		return attributeId;
	}
	public int getProductId() {
		return productId;
	}
	public String getValue() {
		return value;
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
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	
}
