package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.business.QteNumberGenerator;

class QteNumberGeneratorTest {

	@Test
	//every quote number should contain QTE at the start
	void checkQTETest() {
		Boolean expected = true;
		
		new QteNumberGenerator();
		
		String quoteNumber = QteNumberGenerator.getQteNumber();
		String sequence = quoteNumber.substring(0, 3);
		Boolean actual = sequence.equalsIgnoreCase("QTE");
		
		assertEquals(expected, actual);
	}
	
	@Test
	//every quote number should contain 5 numbers after QTE
	void checkNumberTest() {
		Boolean expected = true;
		Boolean actual = false;
		
		String quoteNumber = QteNumberGenerator.getQteNumber();
		String sequence = quoteNumber.substring(3, 8);

		int length = sequence.length();

		if (length == 5) {
			actual = true;
		}
		
		assertEquals(expected, actual);
	}

}
