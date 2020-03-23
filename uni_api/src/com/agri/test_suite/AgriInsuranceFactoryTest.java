package com.agri.test_suite;

import org.junit.jupiter.api.Test;

import com.agri.business.RiskData;
import com.agri.quote.AgriInsuranceFactory;
import com.agri.quote.AgriQuote;
import com.agri.users.Broker;
import com.agri.users.User;

class AgriInsuranceFactoryTest {
	
	@Test
	void test() throws Exception {
		String crop = "Barley";
		String council = "Inverclyde";
		int hectares = 500;
		int vph = 100;
		User user = new Broker();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		AgriQuote newqte = AgriInsuranceFactory.createNewQuote(user , riskdata);
		
		
		
		
	
		
		
	}

}
