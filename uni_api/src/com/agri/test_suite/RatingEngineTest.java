package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.business.RatingEngine;

class RatingEngineTest {

	@Test
	//get premium for Barley (whole number SI)
	void barleyPremiumtest1() {
		String crop = "Barley";
		int SI = 211;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 4.22;
		assertEquals(expected, actual);
	}
	
	@Test
	//get premium for Barley (whole number SI)
	void barleyPremiumTest2() {
		String crop = "Barley";
		int SI = (int) 158.5;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 3.16;
		assertEquals(expected, actual);
	}
	
	@Test
	//get premium for Strawberries
	void testStrawberryPremium() {
		String crop = "Strawberries";
		int SI = 500;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 35.0;
		assertEquals(expected, actual);
	}
}
