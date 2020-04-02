package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.business.DataChecker;
import com.agri.business.RiskData;
import com.agri.exceptions.InvalidDataException;

class DataCheckerTest {
	
	@Test
	//checkZone() to return throwable exception as council does not exist
	void checkZoneTest() throws InvalidDataException {
		RiskData riskdata = new RiskData("Barley", "Spain", 3000, 45);
		String expected = "invalid council entered";
		
		
		try {
			DataChecker data = new DataChecker(riskdata);
			data.checkZone();
		} catch (InvalidDataException e) {
			String actual = e.getMessage();
			assertEquals(actual, expected);
		}
	}
	
	@Test
	//checkZone() return data is valid as Glasgow is a valid council
	void checkZoneTest2() throws InvalidDataException {
		RiskData riskdata = new RiskData("Barley", "Glasgow", 3000, 45);
		Boolean expected = true;
	
		DataChecker data = new DataChecker(riskdata);
		data.checkZone();
		Boolean actual = data.isDataValid;
		assertEquals(actual, expected);
	}
	
	@Test
	//ensure valid data is returned as true
	void getValidDataTest() throws InvalidDataException {
		RiskData riskdata = new RiskData("Barley", "Glasgow", 3000, 45);
		Boolean expected = true;
	
		DataChecker data = new DataChecker(riskdata);
		Boolean actual = data.getDataValid();
		
		assertEquals(actual, expected);
	}
	
	@Test
	//check valid crop has been selected
	void checkCropValidTest1() throws InvalidDataException {
		RiskData riskdata = new RiskData("Barley", "Glasgow", 3000, 45);
		Boolean expected = true;
	
		DataChecker data = new DataChecker(riskdata);
		data.checkCropValid();
		Boolean actual = data.getDataValid();
		
		assertEquals(actual, expected);
	}
	
	@Test
	//check throwable error when invalid crop has been selected
	void checkCropValidTest2() throws InvalidDataException {
		RiskData riskdata = new RiskData("sweetcorn", "Glasgow", 3000, 45);
		String expected = "invalid crop entered";
			
		try {
			DataChecker data = new DataChecker(riskdata);
			data.checkCropValid();
		} catch (InvalidDataException e) {
			String actual = e.getMessage();
			assertEquals(actual, expected);
		}
	}
	
	@Test
	//check business rules pass when valid
	void checkBusinessRulesTest1() throws InvalidDataException {
		RiskData riskdata = new RiskData("Barley", "Glasgow", 3000, 45);
		Boolean expected = true;
	
		DataChecker data = new DataChecker(riskdata);
		data.checkBusinessRules();
		Boolean actual = data.getDataValid();
		
		assertEquals(actual, expected);
	}
	
	@Test
	//check throwable error when business rules fail
	void checkBusinessRulesTest2() throws InvalidDataException {
		RiskData riskdata = new RiskData("Barley", "Glasgow", 30000000, 45);
		String expected = "data did not meet business rules requirements";
			
		try {
			DataChecker data = new DataChecker(riskdata);
			data.checkBusinessRules();
		} catch (InvalidDataException e) {
			String actual = e.getMessage();
			assertEquals(actual, expected);
		}
	}
	
}

