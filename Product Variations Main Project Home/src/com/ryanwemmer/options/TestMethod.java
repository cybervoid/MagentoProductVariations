package com.ryanwemmer.options;

import java.io.IOException;

import com.ryanwemmer.options.database.Crud;
import com.ryanwemmer.options.util.Positions;

public class TestMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		TestMethod t = new TestMethod(); 
		//t.printHashMap();
		/*
		Crud c = new Crud();
		c.listAttributes();
		*/
//		GetData gd = new GetData();
		
		Crud c = new Crud();
		//c.attributesUpdate(4, "test", false, 10, "none", false);
		//c.attributesDelete(4);
		
		//List<String> cells = gd.cells("abc");
		/*String[] cells = gd.cellValues("abc");
		for(int i = 0; i < cells.length; i++){
			System.out.println(cells[i]);
		}*/
	
		
		/*List<String> lines = gd.getAllLines();
		for(int i = 0; i < lines.size(); i++){
			//System.out.println(lines.get(i));
			 
		
			String[] values = gd.cellValues(lines.get(i));
			for(int in = 0; in < values.length; in++ ){
				System.out.println(values[in]);
			}
			*/
		
		
			/*
			List<String> cells = gd.setColumnValues(lines.get(i));
			for(int inty = 0; inty < cells.size(); inty++){
				System.out.println(cells.get(inty));
			}*/	
	}
	/*
	public void printHashMap(){
		Crud c = new Crud();
		Map<Integer, Attributes> m = c.attributesRetrieve();
		//Map<Integer, Attributes> reversedMap = new TreeMap<Integer, Attributes>(m.size());
		
		List<Integer> keys = new ArrayList<Integer>(m.keySet());
		Collections.sort(keys);
		for(int key : keys){
			Attributes a = m.get(key);
			String string = a.getMagentoCode();
			System.out.println(key +" : " + string);
		}
	}*/
}
