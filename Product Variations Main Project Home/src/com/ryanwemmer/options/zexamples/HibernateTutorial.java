package com.ryanwemmer.options.zexamples;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ryanwemmer.options.pojo.Attributes;


//https://www.youtube.com/watch?v=wNT-EZsaC98
public class HibernateTutorial {
	
	
	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration();
		//Configure xml file
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Attributes a = new Attributes();
		//Set insert values
		//a.setId();		
		a.setMagentoCode("store");
		a.setActive(true);
		a.setExportOrder(2);
		a.setDefaultValue("default");
		a.setIsConfigurableOption(false);
		a.setDateCreated("2014-04-25 18:19:29");
		a.setDateModified("2014-04-25 18:19:29");
		s.save(a); //Save attributes object
		s.flush(); 
		tx.commit(); //Commit changes to database
		s.close(); // Close Session
		
	}
}
