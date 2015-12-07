package com.ryanwemmer.options.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;

public class Positions {
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public int screenWidth(){
		return screenSize.width;
		
	}
	
	public int screenHeight(){
		return screenSize.height;
	}
	
	public Point screenRandomMiddlePoint(){
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
		Point middle = new Point((screenSize.width / 2) - randomInt(), (screenSize.height / 2) - randomInt());
		return middle;
		/*Point newLocation = new Point(middle.x - (frame.getWidth() / 2), 
		                              middle.y - (frame.getHeight() / 2));
		return newLocation;*/
	}
	/*
	public Point randomWindowPoint(){
		
	}*/
	private int randomInt(){		
		Random r = new Random();		
		return r.nextInt(30);
	}
}
