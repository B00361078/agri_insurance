package test_suite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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
		AgriQuote newqte = AgriInsuranceFactory.createNewQuote(user , crop, council, hectares, vph);
		
		
		
		
	
		
		
	}

}
