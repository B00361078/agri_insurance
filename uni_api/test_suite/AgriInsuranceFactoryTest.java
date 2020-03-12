package test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uni_api.AgriInsuranceFactory;
import uni_api.AgriQuote;

class AgriInsuranceFactoryTest {

	@Test
	void test() {
		String crop = "Barley";
		String council = "Inverclyde";
		int hectares = 10;
		int vph = 100;
		
		AgriQuote newqte = AgriInsuranceFactory.createNewQuote(crop, council, hectares, vph);
	}

}
