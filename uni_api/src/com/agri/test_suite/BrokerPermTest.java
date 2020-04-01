package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.permissions.PermissionsManager;

class BrokerPermTest {

	@Test
	//get Brokers Permission Level
	void BrokerPermissiontest() {
		String role = "Broker";
		int expected = 1;
		
		int actual = PermissionsManager.checkPermissions(role);
		
		assertEquals(expected, actual);
	}

}
