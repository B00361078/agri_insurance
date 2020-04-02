package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.users.Broker;

class BrokerPermTest {

	@Test //check Brokers Permission Level
	void BrokerPermissiontest() {
		int expected = 1;
		
		int actual = new Broker().getPermissionsLevel();
		
		assertEquals(expected, actual);
	}

}
