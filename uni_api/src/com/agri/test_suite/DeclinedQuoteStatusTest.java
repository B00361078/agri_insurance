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

class DeclinedQuoteStatusTest {
	
	String crop = "Barley";
    String council = "Inverclyde";
    int hectares = 500;
    int vph = 100;
    
    @Test
	void SupAcceptExceptionTest() throws Exception {
		
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
    
    @Test
    void SupDeclineExceptionTest() throws Exception {
		
        User user = new Supervisor();
        RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata); 
        
        try {
        	
            quote.saveQuote(user);
    		quote.declineQuote(user);
    	    quote.declineQuote(user);
    	    fail();
    	    
            } 
            
            catch(ActionException e) {
              assertEquals(e.getMessage(), ("your quote is already declined"));	
            }
    }
    
    @Test
    void SupSavedExceptionTest() throws Exception {
		
	     User user = new Supervisor();
	     RiskData riskdata = new RiskData(crop, council, hectares, vph);
	     AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata); 
	        
	        try {
	        	
	        quote.saveQuote(user);
			quote.declineQuote(user);
		    quote.saveQuote(user);
		    fail();
		    
	        } 
	        
	        catch(ActionException e) {
	          assertEquals(e.getMessage(), ("your quote is already saved"));	
	        }
		}
    
    @Test
    void SupReferExceptionTest() throws Exception {
    	
    	User user = new Supervisor();
    	RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
    	
	    try {
        	
	        quote.saveQuote(user);
			quote.declineQuote(user);
		    quote.referQuote(user);
		    
	        } 
	        
	        catch(ActionException e) {
	          assertEquals(e.getMessage(), ("you do not have permission to perform that action"));	
	        }
		}
    
    @Test
	void SupManAcceptExceptionTest() throws Exception {
		
		String actual; 
		String expected;
        
		User user = new SupervisorManager();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
        
        	quote.saveQuote(user);
        	quote.declineQuote(user);
        	quote.acceptQuote(user);
        	actual = quote.getStatus().toString();
        	expected = "AcceptedQuoteStatus";
        	assertTrue(actual.contains(expected));
	}
    
    @Test
    void SupManDeclineExceptionTest() throws Exception {
		
        User user = new SupervisorManager();
        RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata); 
        
        try {
        	
            quote.saveQuote(user);
    		quote.declineQuote(user);
    	    quote.declineQuote(user);
    	    fail();
    	    
            } 
            
            catch(ActionException e) {
              assertEquals(e.getMessage(), ("your quote is already declined"));	
            }
    }
    
    @Test
    void SupManSaveExceptionTest() throws Exception {
    	
    	User user = new SupervisorManager();
    	RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata); 
        
        try {
        	
            quote.saveQuote(user);
    		quote.declineQuote(user);
    	    quote.saveQuote(user);
    	    fail();
    	    
            } 
            
            catch(ActionException e) {
              assertEquals(e.getMessage(), ("your quote is already saved"));	
            }
    }
        
    @Test
    void SupManReferExceptionTest() throws Exception {
    	User user = new SupervisorManager();
    	RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(user , riskdata);
    	
	    try {
        	
	        quote.saveQuote(user);
			quote.declineQuote(user);
		    quote.referQuote(user);
		    
	        } 
	        
	        catch(ActionException e) {
	          assertEquals(e.getMessage(), ("you do not have permission to perform that action"));	
	        }
    	  
    }
    
     
}
    
