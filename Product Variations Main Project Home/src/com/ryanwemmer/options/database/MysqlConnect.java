package com.ryanwemmer.options.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.ryanwemmer.options.handlers.PropertyFileHandler;

/**
 * This class sets up the mysql
 * connection.
 * 
 * @author Ryan
 *
 */
public class MysqlConnect {
	
	//Retrieve database properties from the .properties file
	
	
	public Connection dbConnect(){
		
		//Retrieve data from the properties file.
		PropertyFileHandler pfh = new PropertyFileHandler();
		Properties props = pfh.loadProps();
		String address = props.getProperty("address");
		String username = props.getProperty("username");
		//Retrieve encrypted password
		String password = props.getProperty("password"); 
		//Decrypt password
		String decryptedPw = pfh.decryptPassword(password);
		
		Connection conn = null;
		try {
			// Establish connection with database
			conn = DriverManager.getConnection(address, username,
					decryptedPw);
			// DON'T FORGET TO CLOSE CONNECTION IN METHOD CALLING CONNECTION
			// targetConnection method.
		} catch (Exception e) {
			System.err.println("Got an exception! ");		
		}
		return conn;	
	} 
}
