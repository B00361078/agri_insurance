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
	//get premium for Barley (decimal SI)
	void barleyPremiumTest2() {
		String crop = "Barley";
		int SI = (int) 158.5;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 3.16;
		assertEquals(expected, actual);
	}
	
	@Test
	//get premium for Strawberries (whole number SI)
	void strawberryPremiumTest1() {
		String crop = "Strawberries";
		int SI = 500;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 35.0;
		assertEquals(expected, actual);
	}
	
	@Test
	//get premium for Strawberries (decimal SI)
	void strawberryPremiumTest2() {
		String crop = "Strawberries";
		int SI = (int) 650.7;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 45.5;
		assertEquals(expected, actual);
	}
	
	@Test
	//get premium for Raspberry (whole number SI)
	void raspberryPremiumTest1() {
		String crop = "Raspberries";
		int SI = 600;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 114.0;
		assertEquals(expected, actual);
	}
	
	@Test
	//get premium for Raspberry (decimal SI)
	void raspberryPremiumTest2() {
		String crop = "Raspberries";
		int SI = (int) 437.68;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 83.03;
		assertEquals(expected, actual);
	}
	
	@Test
	//get premium for Winter Wheat (whole number SI)
	void wheatPremiumTest1() {
		String crop = "WinterWheat";
		int SI = 850;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 93.5;
		assertEquals(expected, actual);
	}
	
	@Test
	//get premium for Winter Wheat (decimal SI)
	void wheatPremiumTest2() {
		String crop = "WinterWheat";
		int SI = (int) 1036.23;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 113.96;
		assertEquals(expected, actual);
	}
	
	@Test
	//get premium for crop not covered
	void unknownCropTest() {
		String crop = "Unknown";
		int SI = 500;
		new RatingEngine();
		double actual = RatingEngine.getPremium(crop, SI);
		double expected = 0.00;
		assertEquals(expected, actual);
	}
}
