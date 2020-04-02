package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.business.RiskData;
import com.agri.exceptions.ActionException;
import com.agri.exceptions.PermissionException;
import com.agri.quote.AgriInsuranceFactory;
import com.agri.quote.AgriQuote;
import com.agri.users.Default;
import com.agri.users.Supervisor;
import com.agri.users.SupervisorManager;
import com.agri.users.User;

class AcceptedQuoteStatusTest {
	
    	String crop = "Barley";
        String council = "Inverclyde";
        int hectares = 500;
        int vph = 100;
       
       
	@Test // Accepted Quote Exception Test
	void acceptedQuoteExceptionTest() throws Exception {
		
        User user = new Supervisor();
        RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata); 
        
        try {
        	
	        quote.saveQuote(user);
			quote.acceptQuote(user);
		    quote.acceptQuote(user);
	    
        } catch (ActionException e) {
        	
        	assertEquals(e.getMessage(), ("your quote is already accepted"));	
        	
        }
	}
	
	@Test // Decline Quote Test
	void declinedQuoteTest() throws Exception {
		
		String actual; 
		String expected;
        
		User user = new Supervisor();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
        
        quote.saveQuote(user);
        quote.acceptQuote(user);
        quote.declineQuote(user);
        actual = quote.getStatus().toString();
        expected = "DeclinedQuoteStatus";
        assertTrue(actual.contains(expected));
	}
	
	@Test // Save Quote Exception Test
	void saveQuoteExceptionTest() throws Exception {
			
	     User user = new Supervisor();
	     RiskData riskdata = new RiskData(crop, council, hectares, vph);
	     AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata); 
	        
	        try {
	        	
		        quote.saveQuote(user);
				quote.acceptQuote(user);
			    quote.saveQuote(user);
			    
	        } catch (ActionException e) {
	        	
	        	assertEquals(e.getMessage(), ("you cannot perform that action"));	
	        	
	        }
		}
	
	@Test // Refer Quote Exception Test 
	void referQuoteExceptionTest() throws Exception {
		
		User user = new Supervisor();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata); 
	    
	    try {
        	
		        quote.saveQuote(user);
				quote.acceptQuote(user);
			    quote.referQuote(user);
		    
	        } catch (ActionException e) {
	        	
	        	assertEquals(e.getMessage(), ("you cannot perform that action"));	
	        	
	        }
		}
	
	@Test //user with wrong permission level
	void wrongPermissionLevelTest() throws Exception {
		
		User user = new SupervisorManager();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		AgriQuote quote = AgriInsuranceFactory.createNewQuote(user, riskdata);
		
		try {
		
			quote.saveQuote(user);
			quote.acceptQuote(user);
			User userDefault = new Default();
			quote.declineQuote(userDefault);
			
		} catch (PermissionException e) {
			
			assertEquals(e.getMessage(), ("you do not have permission to perform that action"));
		}
			
	}
	
}
