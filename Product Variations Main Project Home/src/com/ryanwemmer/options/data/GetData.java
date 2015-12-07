package com.ryanwemmer.options.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetData {
	
	//Load File into buffered reader
	public BufferedReader csvData(String filePath) throws IOException{
		//Pass file path from gui into csvData.
		//File f = new File(filePath); <-- Uncomment this when ready to implement Gui
		File f = new File("C:\\Users\\Ryan\\Development\\workspace\\ProductVariationsHome\\Product Variations Main Project Home\\bin\\sample.csv"); // <-- Remove when GUI done
		FileReader fr = new FileReader(f); //Load file into the FileReader.
		BufferedReader br = new BufferedReader(fr); //load file reader into buffer;
		return br;
	}
	
	
	//Create object type value.
	public List<String> getAllLines() throws IOException{
		//Load CSV data.
		GetData gd = new GetData();
		BufferedReader reader = gd.csvData("abc");
		//Create List
		List<String> lineList = new LinkedList<String>();
		String line = reader.readLine();
		while(line != null){
			//Remove comma if last column is missing data.
			//line = line.replace(", \n","");
			lineList.add(line);
			line = reader.readLine();
		}
		return lineList;
	}
	
	
	public String getSpecificLine(int row) throws IOException{
		GetData gd = new GetData();
		List<String> lines = gd.getAllLines();
		String line = lines.get(row);
	/*	if(line.endsWith(",")){
			//Remove comma if line ends with a comma
			return line.substring(0,line.length()-1);
		}else{
			//Return the line of data
			return line;
		}*/	
		return line;
	}
	
	
	//Load cell values into String list
	//DOESNT WORK:
	public List<String> setColumnValues(String l){
		String line = l;
		List<String> lineList = new LinkedList<String>();		
		String otherThanQuote = " [^\"] ";
		String quotedString = String.format(" \" %s* \" ", otherThanQuote);
		String regex = String.format("(?x) "+ // enable comments, ignore white spaces
                ",                         "+ // match a comma
                "(?=                       "+ // start positive look ahead
                "  (                       "+ //   start group 1
                "    %s*                   "+ //     match 'otherThanQuote' zero or more times
                "    %s                    "+ //     match 'quotedString'
                "  )*                      "+ //   end group 1 and repeat it zero or more times
                "  %s*                     "+ //   match 'otherThanQuote'
                "  $                       "+ // match the end of the string
                ")                         ", // stop positive look ahead
                otherThanQuote, quotedString, otherThanQuote);
		while(line != null){
			lineList.add(line);
			//line = reader.readLine();			
		}		
		return lineList;
	}
	
	
	
	//THIS ONE WORKS!!!!!!!!!!!!!!
	//Return array containing values of each cell for a particular row.
	public String[] cellValues(String l){
		String line = l;
		String otherThanQuote =" [^\"] ";
		String quotedString = String.format(" \" %s \" ", otherThanQuote);
		/*String regex = String.format("(?x) "+ // enable comments, ignore white spaces
                ",                         "+ // match a comma
                "(?=                       "+ // start positive look ahead
                "  (                       "+ //   start group 1
                "    %s*                   "+ //     match 'otherThanQuote' zero or more times
                "    %s                    "+ //     match 'quotedString'
                "  )*                      "+ //   end group 1 and repeat it zero or more times
                "  %s*                     "+ //   match 'otherThanQuote'
                "  $                       "+ // match the end of the string
                ")                         ", // stop positive look ahead
                otherThanQuote, quotedString, otherThanQuote);
		String[] values = line.split(regex);*/
		String[] tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		return tokens; //return cell values in an array
	}
	
	
	
	
	
	/**
	 * Create variables for object
	 *
	 * var0 = string var
	 * While loop
	 *
	 */
	
	//Parse 
	
	
	/*
	
	//Parse each row into a list.
	public List<String> getAllLines() throws IOException{
		//Load CSV data.
		GetData gd = new GetData();
		BufferedReader reader = gd.csvData("abc");
		//Create List
		List<String> lineList = new LinkedList<String>();
		String line = reader.readLine();
		while(line != null){
			//Remove comma if last column is missing data.
			line = line.replace(", \n","");
			lineList.add(line);
			line = reader.readLine();
		}
		return lineList;
	}
	
	//Get specific line.
	public String getSpecificLine(int row) throws IOException{
		GetData gd = new GetData();
		List<String> lines = gd.getAllLines();
		String line = lines.get(row);
		if(line.endsWith(",")){
			//Remove comma if line ends with a comma
			return line.substring(0,line.length()-1);
		}else{
			//Return the line of data
			return line;
		}		
	}
	
	//Load individual column values into an array
	public String[] rowValuesToArray(int rowId) throws IOException{
		//Use Array List because we do not know how many columns are in the csv
		ArrayList<String> l = new ArrayList<>();
		//Get number of columns in the first row
		GetData gd = new GetData(); 
		String line = gd.getSpecificLine(rowId);
		String[] data = line.split("\n");
		//Add data to ArrayList
		l.add(data[0]);
		String s = l.get(0);
		String[] rowData = s.split(","); //Use validator here.
		return rowData;		
	}
	*/
	
}
