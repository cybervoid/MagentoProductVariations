package com.ryanwemmer.options.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ryanwemmer.options.database.Crud;
import com.ryanwemmer.options.pojo.Attributes;

public class Translators {

	
	public void printAttributesHashMap(){
		Crud c = new Crud();
		Map<Integer, Attributes> m = c.attributesRetrieve();
		
		//Put Keys into a list
		List<Integer> keys = new ArrayList<Integer>(m.keySet());
		//Collections.sort(keys);
		for(int key : keys){
			//Get specific attribute
			Attributes a = m.get(key);
			//Extract magentoCode from attribute
			String string = a.getMagentoCode();		
			System.out.println(key +" : " + string);
		}
	}
}
