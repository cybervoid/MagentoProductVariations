package com.ryanwemmer.options.pojo;

import java.io.Serializable;

/** 
 * Attributes Persistent class
 *
 * When new products are imported into the database or exported into a CSV file, it requires specific 
 * column titles. An "Attribute" is a column title. Because the database uses a denormalized structure, 
 * the number of rows per query will be significant. 
 * 
 * When data is entered or retrieved from the database, "Attributes" class holds the information to 
 * facilitate the data transfer. 
 *  
 * @author Ryan Wemmer <ryan.wemmer@gmail.com>
 * Copyright (c) May 05, 2014
 * 
 */
public class Attributes implements Serializable{ //Implement Serializable as per hibernate requirement.

	private static final long serialVersionUID = 1L; //Different versions not anticipated. 
	private int id; 						//Unique database ID 
	private String magentoCode;				//Name of column header on export csv  
	private boolean active; 				//Indicates whether to include in csv export
	private int exportOrder; 				//Sets column position on export file  
	private String defaultValue;		 	//Sets a default value, if required.
	private boolean isConfigurableOption; 	//Indicates if this attribute controls variations
											//For Example, "Shirt Color" may have "Red, Green or Blue"
	private String dateCreated;				//Date attribute record was created 
	private String dateModified;			//Date Attribute row was last modified
	private boolean replaceApost;			//Replaces Apostrophes with &#39; in final csv export file
	private boolean replaceQuote;			//Replaces Quotes with &#34; in final csv export file.
	
	//GETTERS and SETTERS
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getMagentoCode(){
		return magentoCode; 
	}	
	public void setMagentoCode(String magentoCode){
		this.magentoCode = magentoCode; 
	}	
	public boolean getActive(){
		return active;
	}	
	public void setActive(boolean active){
		this.active = active;
	}
	public int getExportOrder(){
		return exportOrder;
	}	
	public void setExportOrder(int exportOrder){
		this.exportOrder = exportOrder;
	}
	public String getDefaultValue(){
		return defaultValue;
	}	
	public void setDefaultValue(String defaultValue){
		this.defaultValue = defaultValue;
	}
	public boolean getIsConfigurableOption(){
		return isConfigurableOption;
	}
	public void setIsConfigurableOption(boolean isConfigurableOption){
		this.isConfigurableOption = isConfigurableOption;
	}	
	public boolean getReplaceApost(){
		return replaceApost;
	}	
	public void setReplaceApost(boolean replaceApost){
		this.replaceApost = replaceApost;
	}
	public boolean getReplaceQuote(){
		return replaceQuote;
	}	
	public void setReplaceQuote(boolean replaceQuote){
		this.replaceQuote = replaceQuote;
	}	
	public String getDateCreated(){
		return dateCreated;
	}
	public void setDateCreated(String dateCreated){
		this.dateCreated = dateCreated;
	}
	public String getDateModified(){
		return dateModified;
	}
	public void setDateModified(String dateModified){
		this.dateModified = dateModified;
	}
}

