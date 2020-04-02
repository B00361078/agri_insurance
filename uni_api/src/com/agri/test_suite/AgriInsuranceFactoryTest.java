package com.agri.test_suite;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.agri.business.RiskData;
import com.agri.exceptions.InvalidDataException;
import com.agri.exceptions.PermissionException;
import com.agri.quote.AgriInsuranceFactory;
import com.agri.quote.AgriQuote;
import com.agri.users.Broker;
import com.agri.users.Default;
import com.agri.users.User;

class AgriInsuranceFactoryTest {
	
	String council = "Inverclyde";
	int hectares = 500;
	int vph = 100;
		
	@Test //barley quote generated check
	void barleyQuoteTest() throws Exception {
		
		String crop = "Barley";
		String expected = "BarleyQte";
		User user = new Broker();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		
		AgriQuote newqte = AgriInsuranceFactory.createNewQuote(user , riskdata);
		String actual = newqte.toString();
		
		assertTrue(actual.contains(expected));
	}
	
	@Test //raspberry quote generated check
	void raspberryQuoteTest() throws Exception {
		
		String crop = "Raspberries";
		String expected = "RaspberryQte";
		User user = new Broker();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		
		AgriQuote newqte = AgriInsuranceFactory.createNewQuote(user , riskdata);
		String actual = newqte.toString();
		
		assertTrue(actual.contains(expected));
	}
	
	@Test //winter wheat quote generated check
	void winterWheatQuoteTest() throws Exception {
		
		String crop = "WinterWheat";
		String expected = "WheatQte";
		User user = new Broker();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		
		AgriQuote newqte = AgriInsuranceFactory.createNewQuote(user , riskdata);
		String actual = newqte.toString();
		
		assertTrue(actual.contains(expected));
	}
	
	@Test //strawberry quote generated check
	void strawberriesQuoteTest() throws Exception {
		
		String crop = "Strawberries";
		String expected = "StrawberryQte";
		User user = new Broker();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		
		AgriQuote newqte = AgriInsuranceFactory.createNewQuote(user , riskdata);
		String actual = newqte.toString();
		
		assertTrue(actual.contains(expected));
	}
	
	@Test //crop not listed should return default null
	void unknowsQuoteTest() throws Exception {
		
		String crop = "Sugarcane";
		String expected = "invalid crop entered";
		User user = new Broker();
		
		try {
			
			RiskData riskdata = new RiskData(crop, council, hectares, vph);
			AgriInsuranceFactory.createNewQuote(user , riskdata);
			
		} catch (InvalidDataException e) {
			
			String actual = e.getMessage();
			assertEquals(expected, actual);
			
		}
	}
	
	@Test //user without correct permissions creating a quote
	void invalidUserTest() throws Exception {
		
		new AgriInsuranceFactory();
		String crop = "Barley";
		String expected = "you do not have permission to quote";
		User user = new Default();
		
		try {
			
			RiskData riskdata = new RiskData(crop, council, hectares, vph);
			AgriInsuranceFactory.createNewQuote(user , riskdata);
			
		} catch (PermissionException e) {
			
			String actual = e.getMessage();
			assertEquals(expected, actual);
			
		}
	}
	
}
