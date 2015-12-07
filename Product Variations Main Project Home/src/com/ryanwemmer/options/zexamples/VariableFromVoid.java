package com.ryanwemmer.options.zexamples;

public class VariableFromVoid {
	
	static String s; 
	public static void main(String[] args) {		
		
		VariableFromVoid main = new VariableFromVoid();
		//Run method to set the desired value into s
		main.setString();
		//S has been set. Print the value of s
		System.out.println(s);
	}
	
	
	//Set global variable in method
	public void setString(){
		//Set s to a value.
		s = "Abc";
	}

}
