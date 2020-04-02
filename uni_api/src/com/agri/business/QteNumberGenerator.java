package com.agri.business;

import java.security.SecureRandom;

public class QteNumberGenerator {
	
	// this class generates a random quote number will fixed format
	
	public static String getQteNumber() {
		SecureRandom qteNumGen = new SecureRandom();
		int num = qteNumGen.nextInt(100000);
		String numString = String.format("%05d", num);
		String qteNumber = ("QTE" + numString);
		return qteNumber;
	}
}
