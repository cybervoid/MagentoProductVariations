/**
 * Copyright (c) 2014 Ryan Wemmer. All rights reserved.
 * @author Ryan Wemmer
 * @version 1.0
 */

package com.ryanwemmer.options;

import java.net.URISyntaxException;

import com.ryanwemmer.options.gui.GetSourceData;
import com.ryanwemmer.options.gui.ReorderAttributesGui;
import com.ryanwemmer.options.gui.StartGui;
import com.ryanwemmer.options.handlers.PropertyFileHandler;


public class Main {

	/**
	 * @param args
	 */
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		StartGui sg = new StartGui();
		sg.launchGui();		
		PropertyFileHandler f = new PropertyFileHandler();


	}
	
}
