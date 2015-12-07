package com.ryanwemmer.options.data.sortattributes;

import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import com.ryanwemmer.options.database.Crud;
import com.ryanwemmer.options.pojo.Attributes;



public class AttributeExportOrder {
	//Returns list of attributes, sorted by export order. 
	public List<Attributes> getSortedOrder(){
		Crud c = new Crud();
		List<Attributes> attributes = c.attributesRetrieveList();		
		//Sort list by export order value.
		Collections.sort(attributes, new AttributesComparator());
		return attributes;
	}
	class AttributesComparator implements Comparator<Attributes>{
		@Override
		public int compare(Attributes att1, Attributes att2) {
			return att1.getExportOrder() - att2.getExportOrder(); 		
		}	
	}
	/**
	 * Export order determines column positions for csv exports. 
	 * On the attributes table, "export_order" starts counting at 0.
	 * Therefore, a simple row count will provide the necessary value 
	 * to put new attributes at the end of the export.
	 * 
	 * @return Largest number in export order column.  
	 */
	public int highestExport(){
		//Connect to the database.
		Crud c = new Crud();
		//Retrieve list of rows on attributes table.
		if(c.attributesRetrieveList() == null || c.attributesRetrieveList().size() == 0){
			return 0; //Return 0. System may be implemented on a new system, therefore the database may be empty.
		}else{			
			return c.attributesRetrieveList().size();		
		}
	}
	// TODO CREATE CLASS THAT RE-ORDERS ATTRIBUTES IF AN ATTRIBUTE IS DELETED.
}
