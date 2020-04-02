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

class ReferredQuoteStatusTest {
	
	String crop = "Barley";
    String council = "Inverclyde";
    int hectares = 500;
    int vph = 100;
    
    User userBroker = new Broker();
    User userSupervisor = new Supervisor();
    User userSupManager = new SupervisorManager();
    User userDefault = new Default();


	@Test //Accept Quote Status Test 
	void acceptQuoteTest() throws Exception {
		
		String actual; 
		String expected;
        
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(userSupervisor , riskdata);
        
        	quote.saveQuote(userSupervisor);
        	quote.referQuote(userSupervisor);
        	quote.acceptQuote(userSupManager);
        	actual = quote.getStatus().toString();
        	expected = "AcceptedQuoteStatus";
        	assertTrue(actual.contains(expected));
	}
	
	@Test //Decline Quote Exception Test
	void declineQuoteTest() throws Exception {
		
		String actual; 
		String expected;
        
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
        AgriQuote quote = AgriInsuranceFactory.createNewQuote(userSupervisor , riskdata);
        
        	quote.saveQuote(userSupervisor);
        	quote.referQuote(userSupervisor);
        	quote.declineQuote(userSupManager);
        	actual = quote.getStatus().toString();
        	expected = "DeclinedQuoteStatus";
        	assertTrue(actual.contains(expected));
	}
	
	@Test //Save Quote Exception Test
	void saveQuoteTest() throws Exception {

		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		AgriQuote quote = AgriInsuranceFactory.createNewQuote(userSupervisor, riskdata);
		
		try {
			quote.saveQuote(userSupervisor);
			quote.referQuote(userSupervisor);
			quote.saveQuote(userSupervisor);
		}
		
		catch(ActionException e) {
			assertEquals(e.getMessage(), ("your quote is already saved"));
		}
			
	}
	
	@Test //Refer Quote Exception Test
	void referQuoteTest() throws Exception {
		
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		AgriQuote quote = AgriInsuranceFactory.createNewQuote(userSupManager, riskdata);
		
		try {
			quote.saveQuote(userSupervisor);
			quote.referQuote(userSupervisor);
			quote.referQuote(userSupervisor);

		}
		
		catch(ActionException e) {
			assertEquals(e.getMessage(), ("your quote is already referred"));
		}
		
	}
	
	@Test //Permission Accept Quote Test 
	void permAcceptQuoteTest() throws Exception {
		
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		AgriQuote quote = AgriInsuranceFactory.createNewQuote(userSupervisor, riskdata);
		
		try {
			quote.saveQuote(userSupervisor);
			quote.referQuote(userSupervisor);
			quote.acceptQuote(userBroker);
		}
		
		catch(PermissionException e) {
			assertEquals(e.getMessage(), ("you do not have permission to perform that action"));
		}
		
	}
	
	@Test //Permission Decline Quote Test 
	void permDeclineQuoteTest() throws Exception {
		
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		AgriQuote quote = AgriInsuranceFactory.createNewQuote(userSupervisor, riskdata);
		
		try { 
			quote.saveQuote(userSupervisor);
			quote.referQuote(userSupervisor);
			quote.declineQuote(userBroker);
		}
		
		catch(PermissionException e) { 
			assertEquals(e.getMessage(), ("you do not have permission to perform that action"));
		}

	}
	

	
	
	
}
