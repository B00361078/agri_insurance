package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.business.RiskData;
import com.agri.exceptions.ActionException;
import com.agri.quote.AgriInsuranceFactory;
import com.agri.quote.AgriQuote;
import com.agri.users.Supervisor;
import com.agri.users.SupervisorManager;
import com.agri.users.User;

class SavedQuoteStatusTest {

		String crop = "Barley";
	    String council = "Inverclyde";
	    int hectares = 500;
	    int vph = 100;
	
	@Test  // Supervisor Accept Quote Exception Test 
	void SupAcceptExceptionTest() throws Exception {
		
		String actual; 
		String expected;
        
		User user = new Supervisor();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
        
        	quote.saveQuote(user);
        	quote.acceptQuote(user);
        	actual = quote.getStatus().toString();
        	expected = "AcceptedQuoteStatus";
        	assertTrue(actual.contains(expected));
	}
	
	@Test  // Supervisor Decline Quote Exception Test 
	void SupDeclineExceptionTest() throws Exception {
		
		String actual;
		String expected;
		
		User user = new Supervisor();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
        
        quote.saveQuote(user);
        quote.declineQuote(user);
    	actual = quote.getStatus().toString();
    	expected = "DeclinedQuoteStatus";
    	assertTrue(actual.contains(expected));
	}
	
	@Test // Supervisor Save Quote Exception Test 
	void SupSaveExceptionTest() throws Exception {
		User user = new Supervisor();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		AgriQuote quote = AgriInsuranceFactory.createNewQuote(user, riskdata);
		
		try {
			quote.saveQuote(user);
			quote.acceptQuote(user);
			quote.saveQuote(user);
		}
		
		catch(ActionException e) {
			assertEquals(e.getMessage(), ("you cannot perform that action"));
		}
		
	}
		
		@Test  // Supervisor Refer Quote Exception Test 
		void SupReferExceptionTest() throws Exception {
			User user = new Supervisor();
			RiskData riskdata = new RiskData(crop, council, hectares, vph);
			AgriQuote quote = AgriInsuranceFactory.createNewQuote(user, riskdata);
			
			try {
				quote.saveQuote(user);
				quote.acceptQuote(user);
				quote.referQuote(user);
			}
			
			catch(ActionException e) {
				assertEquals(e.getMessage(), ("you cannot perform that action"));
			}
				
		}
		
		@Test  // Supervisor Manager Accept Quote Exception Test 
		void SupManAcceptExceptionTest() throws Exception {
			
			String actual; 
			String expected;
	        
			User user = new SupervisorManager();
			RiskData riskdata = new RiskData(crop, council, hectares, vph);
	        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
	        
	        	quote.saveQuote(user);
	        	quote.acceptQuote(user);
	        	actual = quote.getStatus().toString();
	        	expected = "AcceptedQuoteStatus";
	        	assertTrue(actual.contains(expected));
		}
		
		@Test  // Supervisor Manager Decline Quote Exception Test 
		void SupManDeclineExceptionTest() throws Exception {
			
			String actual; 
			String expected;
	        
			User user = new SupervisorManager();
			RiskData riskdata = new RiskData(crop, council, hectares, vph);
	        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
	        
	        	quote.saveQuote(user);
	        	quote.declineQuote(user);
	        	actual = quote.getStatus().toString();
	        	expected = "DeclinedQuoteStatus";
	        	assertTrue(actual.contains(expected));
		}
		
		@Test  // Supervisor Manager Decline Quote Exception Test 
		void SupManSaveExceptionTest() throws Exception {
			User user = new SupervisorManager();
			RiskData riskdata = new RiskData(crop, council, hectares, vph);
			AgriQuote quote = AgriInsuranceFactory.createNewQuote(user, riskdata);
			
			try {
				quote.saveQuote(user);
				quote.acceptQuote(user);
				quote.saveQuote(user);
			}
			
			catch(ActionException e) {
				assertEquals(e.getMessage(), ("you cannot perform that action"));
			}
				
		}
		
		@Test  // Supervisor Manager Refer Quote Exception Test 
		void SupManReferExceptionTest() throws Exception {
			User user = new SupervisorManager();
			RiskData riskdata = new RiskData(crop, council, hectares, vph);
			AgriQuote quote = AgriInsuranceFactory.createNewQuote(user, riskdata);
			
			try {
				quote.saveQuote(user);
				quote.acceptQuote(user);
				quote.referQuote(user);
			}
			
			catch(ActionException e) {
				assertEquals(e.getMessage(), ("you cannot perform that action"));
			}
				
		}
		
		
		@Test  // Supervisor Manager Save Quote Exception Test 
		void BrokerSaveExceptionTest() throws Exception {
			User user = new SupervisorManager();
			RiskData riskdata = new RiskData(crop, council, hectares, vph);
			AgriQuote quote = AgriInsuranceFactory.createNewQuote(user, riskdata);
			
			try {
				quote.saveQuote(user);
				quote.acceptQuote(user);
				quote.saveQuote(user);
			}
			
			catch(ActionException e) {
				assertEquals(e.getMessage(), ("you cannot perform that action"));
			}
				
		}
			
	
	}
		