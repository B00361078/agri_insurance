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

class DeclinedQuoteStatusTest {
	
	String crop = "Barley";
    String council = "Inverclyde";
    int hectares = 500;
    int vph = 100;
    
    @Test // Accept Quote Test
	void acceptQuoteTest() throws Exception {
		
		String actual; 
		String expected;
        
		User user = new Supervisor();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
        
       	quote.saveQuote(user);
        quote.declineQuote(user);
        quote.acceptQuote(user);
        actual = quote.getStatus().toString();
        expected = "AcceptedQuoteStatus";
        assertTrue(actual.contains(expected));
	}
    
    @Test // Decline Quote Exception Test
    void declineExceptionTest() throws Exception {
		
        User user = new Supervisor();
        RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata); 
        
        try {
        	
	            quote.saveQuote(user);
	    		quote.declineQuote(user);
	    		quote.declineQuote(user);
    	    
            } catch (ActionException e) {
            	
            	assertEquals(e.getMessage(), ("your quote is already declined"));
              
            }
    }
    
    @Test // Save Quote Exception Test
    void savedQuoteExceptionTest() throws Exception {
		
	     User user = new Supervisor();
	     RiskData riskdata = new RiskData(crop, council, hectares, vph);
	     AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata); 
	        
	     try {
	        	
	    	 quote.saveQuote(user);
	    	 quote.declineQuote(user);
	    	 quote.saveQuote(user);

		  } catch (ActionException e) {
			  
			  assertEquals(e.getMessage(), ("your quote is already saved"));
	          
	      }
	}
    
    @Test // Refer Quote Exception Test 
    void referQuoteExceptionTest() throws Exception {
    	
    	User user = new Supervisor();
    	RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
    	
	    try {
        	
	        quote.saveQuote(user);
			quote.declineQuote(user);
		    quote.referQuote(user);
		    
	    } catch (ActionException e) {
	    	
	        assertEquals(e.getMessage(), ("you do not have permission to perform that action"));
	        
	    }
	}
    
    
    @Test //accept quote without correct permission level
    void acceptWrongPermissionTest() throws Exception {
    	
    	User user = new SupervisorManager();
    	RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
    	
	    try {
        	
	        quote.saveQuote(user);
			quote.declineQuote(user);
			User userDefault = new Default();
		    quote.acceptQuote(userDefault);
		    
	     } catch (PermissionException e) {
	    	 
	        assertEquals(e.getMessage(), ("you do not have permission to perform that action"));
	          
	     } 
    }
    
    @Test //refer quote without correct permission level
    void referWrongPermissionTest() throws Exception {
    	User user = new SupervisorManager();
    	RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
    	
	    try {
        	
	        quote.saveQuote(user);
			quote.declineQuote(user);
			User userDefault = new Default();
		    quote.referQuote(userDefault);
		    
	    } catch (PermissionException e) {
	    	
	    	assertEquals(e.getMessage(), ("you do not have permission to perform that action"));
	          
	    }	  
    }
}
    
