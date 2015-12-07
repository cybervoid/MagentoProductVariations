package com.ryanwemmer.options.handlers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import com.ryanwemmer.options.Main;


public class PropertyFileHandler {
	
	Properties prop = new Properties();
	OutputStream output = null;
	
	//Create properties file.
	public void createPropFile(){
		
		String path = jarPath();
		try {
			FileWriter writer = new FileWriter(path + "config.properties");
			writer.append("address=\n");
			writer.append("port=\n");
			writer.append("username=\n");
			writer.append("password=\n");
			writer.append("database=\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Update existing properties file.
	public void updateMysqlPropFile(String address, String username, 
			String password, String database){
		try{
			prop.setProperty("address", address);
			prop.setProperty("username", username);
			prop.setProperty("password", password);
			prop.setProperty("database", database);			
			//prop.store(output, null);
			
			FileWriter writer = new FileWriter(jarPath()+"config.properties");
			prop.store(writer,null);
			writer.close();
		}catch(IOException io){
			io.printStackTrace();
		}/*finally{
			if(output != null){
				try{
					output.close();
				}catch(IOException io){
					io.printStackTrace();
				}
			}
		}*/		
	}
	
	
	//Load properties from file.
	public Properties loadProps(){
		PropertyFileHandler pfh = new PropertyFileHandler();
		Properties prop = new Properties();
		InputStream input = null;
		try{ 
			input = new FileInputStream(pfh.propFile().getPath());
			prop.load(input);
		}catch(IOException e){
			e.printStackTrace();
		}
		return prop;
	}
	
	
	//Check and see if the property file exists.
	public boolean propExists(){
		//Check if the property file exists in the jar's running directory.
		//String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		PropertyFileHandler pfh = new PropertyFileHandler();
		File f = new File(pfh.jarPath()+"config.properties");
		if(f.exists()){			
			return true;
		}else{
			return false;
		}	
	}
	
	//Get properties file
	public File propFile(){
		File f = new File(jarPath()+"config.properties");
		return f;
	}
	
	
	//Path to JAR's root directory.
	public String jarPath(){	
		//Get the root directory of the jar file.
		String path = null;
		try {
			path = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath(); //Convert to URI to handle special chars and spaces
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;	
	}
	
	public String encryptPw(String password){
		//Encrypted password, store in properties
		String encryptedPw = password;
		return encryptedPw;
	}
	
	public String decryptPassword(String encryptedPw){	
		//Retrieve encrypted password and decrypt
		String decryptedPw = encryptedPw;		
		return decryptedPw;
		//
	}
	
}
