package com.ryanwemmer.options.pojo;

import java.io.Serializable;

public class Products implements Serializable {
	
	int id;
	String internalSku;
	String mpn;
	int vendorId;
	boolean hasVariations;
	String dateCreated;
	String dateModified;
	public int getId() {
		return id;
	}
	public String getInternalSku() {
		return internalSku;
	}
	public String getMpn() {
		return mpn;
	}
	public int getVendorId() {
		return vendorId;
	}
	public boolean isHasVariations() {
		return hasVariations;
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
	public void setInternalSku(String internalSku) {
		this.internalSku = internalSku;
	}
	public void setMpn(String mpn) {
		this.mpn = mpn;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public void setHasVariations(boolean hasVariations) {
		this.hasVariations = hasVariations;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	

}
