package test_suite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import business.RiskData;
import exceptions.PermissionException;
import uni_api.AgriInsuranceFactory;
import uni_api.AgriQuote;
import users.Broker;
import users.User;

class AgriInsuranceFactoryTest {
	
	@Test
	void test() throws PermissionException {
		String crop = "Barley";
		String council = "Orkney";
		int hectares = 10;
		int vph = 100;
		User user = new Broker();
		RiskData riskdata = new RiskData(crop, council, hectares, vph);
		AgriQuote newqte = AgriInsuranceFactory.createNewQuote(user , riskdata);
		
		
		
		
	
		
		
	}

}
