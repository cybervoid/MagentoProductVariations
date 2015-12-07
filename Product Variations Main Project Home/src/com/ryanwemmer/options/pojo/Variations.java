package com.ryanwemmer.options.pojo;

import java.io.Serializable;

public class Variations implements Serializable{

	int id;
	int parentId;
	int childId;
	int attributeId;
	String dateCreated;
	String dateModified;
	public int getId() {
		return id;
	}
	public int getParentId() {
		return parentId;
	}
	public int getChildId() {
		return childId;
	}
	public int getAttributeId() {
		return attributeId;
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
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public void setChildId(int childId) {
		this.childId = childId;
	}
	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	
	
}
