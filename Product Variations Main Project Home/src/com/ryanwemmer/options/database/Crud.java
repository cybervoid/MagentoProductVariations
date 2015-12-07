package com.ryanwemmer.options.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ryanwemmer.options.data.sortattributes.AttributeExportOrder;
import com.ryanwemmer.options.pojo.Attributes;

public class Crud {

	/**
	 * This class handles queries and other 
	 * function related to the database.
	 * 
	 * It contains the simple CRUD functions,
	 * it also contains necessary queries to
	 * fully enter and retrieve data.
	 */

	MysqlConnect m = new MysqlConnect();
	//DateTime for database timestamp
	public String currentTime(){
		Date createdTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(createdTime);
		return time;
	}
		
	/* SETUP HIBERNATE SESSIONS. Sessions will be called often in CRUD */
	
	private Configuration config(){
		Configuration cfg = new Configuration();
		try{
			cfg.configure("hibernate.cfg.xml");
		}catch(Throwable e){
			System.err.println("CRUD: config() Failed: " + e);
		}
		return cfg;
	}
	
	private SessionFactory factoryCreate(){
		Configuration cfg = config();
		SessionFactory factory = null;
		try{
			factory = cfg.buildSessionFactory();
		}catch(Throwable e){
			System.err.println("Failed to create session factory object: " + e);
		}
		return factory;
	}
	/* Session will be called often in CRUD class  */	
	private Session sessionCreate(){
		SessionFactory sf = factoryCreate();
		Session s = sf.openSession();
		return s;
	}
	
	/** Create data handlers for tables */
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////// CRUD: ATTRIBUTES ////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	/**  
	 * This class creates new attributes in the database using data 
	 * received from the user. 
	 * 
	 * @param magentoCode	This will be the attribute name in the magento instance.
	 * @param active	This determines if the attribute will be include in user exports.
	 * @param exportOrder	Indicates the position of the attribute when the user does an export.
	 * @param isConfigurableOption	Indicates an attribute is a variation. Example: 'size' has small, medium, or large
	 * @param replaceApost	Indicates whether to replace apostrophes with html code: &#39; on export sheet
	 * @param replaceQuote	Indicates whether to replace apostrophes with html code: &#34; on export sheet
	 */
	public void attributesCreate(String magentoCode, boolean active,  int exportOrder, 
			String defaultValue, boolean isConfigurableOption, boolean replaceApost, 
			boolean replaceQuote){		
		//Create session variables
		Attributes a = new Attributes();		
		Session s = sessionCreate();											 		
		Transaction tx = null;
		AttributeExportOrder aeo = new AttributeExportOrder();	 
		int nbr = aeo.highestExport(); //Retrieve value for export order.			
		try{					
			//Set values to be inserted using Attributes Setters 
			a.setMagentoCode(magentoCode);
			a.setActive(active);
			a.setExportOrder(nbr);	
			a.setDefaultValue(defaultValue);
			a.setIsConfigurableOption(isConfigurableOption);
			a.setReplaceApost(replaceApost);
			a.setReplaceQuote(replaceQuote);
			a.setDateCreated(currentTime()); 	
			a.setDateModified(currentTime());
			//Save data 
			tx = s.beginTransaction();
			s.save(a);				
			s.flush();				
			tx.commit();			//Commit changes to database
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();		//If error occurs, roll back transaction changes
			}
			e.printStackTrace();
		}finally{
			s.close(); 				//Close the session.
		}			
	}
	

	/**
	 * Retrieve a full list of attributes. Need to do row counts.
	 * Also needed when re-ordering export order. 
	 * 
	 * @return	Returns a list of all attributes in the database.
	 */
	
	public List<Attributes> attributesRetrieveList(){
		
		//Instantiate List, Session and Transaction objects.
		List<Attributes> aList = null;
		Session s = sessionCreate();
		Transaction tx = null;
		
		try{
			//Start the transaction using session.
			tx = s.beginTransaction();
			//Load list of attributes
			aList = s.createQuery("FROM Attributes").list();			
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback(); // if error occurs, roll back transaction
			}
			e.printStackTrace();
		}finally{
			s.close();
		}
		return aList;
	}
	
	/* RETRIEVE ATTRIBUTES */
	public Map<Integer, Attributes> attributesRetrieve(){
		//create instance variables
		Map<Integer, Attributes> m = new HashMap<Integer, Attributes>();
		Session s = sessionCreate();
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			//Load list of attributes
			List aList = s.createQuery("FROM Attributes").list();			
			for(Iterator iterator = aList.iterator(); iterator.hasNext();){
				Attributes a = (Attributes) iterator.next();
				m.put(a.getId(), a);
			}
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback(); // if error occurs, roll back transaction
			}
			e.printStackTrace();
		}finally{
			s.close();
		}
		return m;
	}
	
	
	/* UPDATE ATTRIBUTES */
	public void attributesUpdate(int id, String magentoCode, boolean active, int exportOrder, 
			String defaultValue, boolean isConfigurableOption, boolean replaceApost, boolean replaceQuote){
		Session s = sessionCreate();
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			Attributes a = (Attributes) s.get(Attributes.class, id);
			a.setMagentoCode(magentoCode);
			a.setActive(active);
			a.setExportOrder(exportOrder);
			a.setDefaultValue(defaultValue);
			a.setIsConfigurableOption(isConfigurableOption);			
			a.setReplaceApost(replaceApost);
			a.setReplaceQuote(replaceQuote);
			a.setDateModified(currentTime());
			s.update(a);
			tx.commit();
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();			
			}	
			e.printStackTrace();			
		}finally{
			s.close();			
		}
	}
	
	/* DELETE ATTRIBUTES */
	public void attributesDelete(int id){
		Session s = sessionCreate();
		Transaction tx = null;
		try{
			tx = s.beginTransaction();
			Attributes a = (Attributes) s.get(Attributes.class, id);
			s.delete(a); //Delete attribute
			tx.commit();			
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();			
			}	
			e.printStackTrace();			
		}finally{
			s.close();			
		}
	}
		
	/*
	 *  END OF ATTRIBUTES CRUD
	 */
	
	
	
	
	/** CREATE DATABASE */
	/** CREATE TABLES */
	
	
	
	/** CREATE RECORDS */
		//Method to create a new attribute
	public void newAttribute(String magentoCode, boolean active,  int exportOrder, 
			String defaultValue, boolean isConfigurableOption){
		
		//Get current time for created.
		String time = currentTime();
		//Build SQL Statement.
		String query = "INSERT INTO  " 			+
				"`mayerblue_products`.`attributes` (" 	+	
				"`magento_code` ,"						+
				"`active` ,"							+
				"`export_order` ,"						+
				"`default_value` ,"						+
				"`is_configurable_option` ,"			+
				"`date_created` ,"						+
				"`date_modified`"						+
				")"										+
				"VALUES (" 								+
				 "(\'" 	  +	magentoCode 				+ 
				 "\', \'" + active 						+ 
				 "\', \'" + exportOrder 				+ 
				 "\', \'" + defaultValue 				+
				 "\', \'" + isConfigurableOption 		+ 
				 "\', \'" + time 						+ 
				 "\', CURRENT_TIMESTAMP);";  
				//end of SQL statement
		try{
			//Connect to database
			Connection conn = m.dbConnect();
			//create statement
			Statement st = conn.createStatement();
			//execute insert statement
			st.executeUpdate(query);
			//Close statement
			st.close();
			//Close db connection
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		/*  ORIGINAL STATEMENT:
		 * INSERT INTO  `mayerblue_products`.`attributes` (
		 *	`id` ,`magento_code` , `active` , `export_order` ,`default_value` , 
		 *	`is_configurable_option` ,`date_created` ,`date_modified` ) 
		 *	VALUES ( '1',  'mpn',  '1',  '1',  '',  '0',  '2014-04-24 19:06:03', CURRENT_TIMESTAMP );
		 */

	}
	//Method to enter a new attribute default value	
	//Method to create a new product
	//Create a new Vendor
	
	
	/** RETRIEVE RECORDS */
	
	// Use Hibernate to retrieve list of attributes in the database.
	
	
	
	//View an individual product
	//View a vendor
	//Export all vendor data
	//Export Select vendor data
	//Retrieve Categories
	//Method to retrieve all attribute information.
	
	//Store attributes table

	//Method to retrieve export orders
	//Method to retrieve highest attribute export order
	//Method to retrieve all attribute export values.
	//Method to retrieve attribute ID
	//Method to retrieve attribute name.

	
	/** UPDATE RECORDS */
	//Method to make an attribute inactive. (will not export)	
	//Method to change/remove attribute default value	
	//Method to change an attribute value
	//Method to update export order
	//Method to create a vendor
	//Method to add new products to existing vendor	
	//Update Categories
	
	
	
	
	/** DELETE RECORDS */
		//Method to delete attribute
		//Method to delete a product
		//Method to delete a vendor and all products
		//Method to delete a group of products 
	
	
}
