package User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uni_api.QuoteFactory;

class PermissionsManagerTest {

	@Test
	void test1() {
		String role = "jhjhd";
		Quote newqte = QuoteFactory.generateQuote(crop, area)
		int perms = new PermissionsManager().checkPermissions(role);
		int expected = 1;
		assertEquals(expected, perms);
		// assert the return value is the same as expected
	}

}
