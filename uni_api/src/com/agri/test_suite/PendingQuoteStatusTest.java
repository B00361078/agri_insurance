package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.business.RiskData;
import com.agri.exceptions.ActionException;
import com.agri.exceptions.PermissionException;
import com.agri.quote.AgriInsuranceFactory;
import com.agri.quote.AgriQuote;
import com.agri.users.Broker;
import com.agri.users.Default;
import com.agri.users.Supervisor;
import com.agri.users.SupervisorManager;
import com.agri.users.User;

class PendingQuoteStatusTest {
	
	String crop = "Barley";
    String council = "Inverclyde";
    int hectares = 500;
    int vph = 100;
    User userBroker = new Broker();
    User userSupervisor = new Supervisor();
    User userSupManager = new SupervisorManager();
    User userDefault = new Default();
   
	@Test //Accept Quote Exception Test
	void acceptQuoteTest() throws Exception {
		
	    RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(userBroker , riskdata); 
	       
	    try {        	
	    	quote.acceptQuote(userBroker);
	        } 
	        
	        catch(ActionException e) {
	          assertEquals(e.getMessage(), ("you must save the quote first"));	
	        }
	    
	}
	
	@Test //Decline Quote Exception Test
	void declineQuoteTest() throws Exception {
		
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(userSupervisor , riskdata); 
	    
	    try {        	
	    	quote.declineQuote(userSupervisor);
	        } 
	        
	        catch(ActionException e) {
	          assertEquals(e.getMessage(), ("you must save the quote first"));	
	        }
	    
	}
	
	@Test //Permission Save Quote Test
	void permSaveQuoteTest() throws Exception {
		
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(userBroker , riskdata); 
	    
	    try {
	    	quote.saveQuote(userDefault);
	    }
	    
	    catch(PermissionException e) {
	    	assertEquals(e.getMessage(), ("you do not have permission to perform that action"));
	    }
	}
	
	@Test //Refer Quote Exception Test
	void referQuoteTest() throws Exception {
		
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(userBroker , riskdata); 
	    
	    try {
	    	quote.referQuote(userBroker);
	    }
	    
	    catch(ActionException e) {
	    	assertEquals(e.getMessage(), ("you must save the quote first"));
	    }
		
	}
	
	@Test //Save Quote Status Test
	void saveQuoteTest() throws Exception {
		
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
	    AgriQuote quote = AgriInsuranceFactory.createNewQuote(userBroker , riskdata);
	    quote.saveQuote(userBroker);
	    String actual = quote.getStatus().toString();
    	String expected = "SavedQuoteStatus";
    	assertTrue(actual.contains(expected));
	    
	}
		
		
}


