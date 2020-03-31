package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.business.RatingEngine;

class RatingEngineTest {

	@Test
	void testBarleyPremium() {
		String crop = "Barley";
		int SI = 211;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 4.22;
		assertEquals(expected, actual);
	}
	
	@Test
	void testStrawberryPremium() {
		String crop = "Strawberries";
		int SI = 500;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 35.0;
		assertEquals(expected, actual);
	}
}