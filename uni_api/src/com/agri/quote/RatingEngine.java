package com.agri.quote;

import java.util.Random;

public class RatingEngine {
	
	public static double getPremium() {
		
		//this is where the rating should be generated from Rating engine
		Random premGenerator = new Random();
		int premium = premGenerator.nextInt(10000);
		return premium;
	}
}
