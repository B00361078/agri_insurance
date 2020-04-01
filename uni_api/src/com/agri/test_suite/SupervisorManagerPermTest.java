package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.permissions.PermissionsManager;

class SupervisorManagerPermTest {

	@Test
	//Check Supervisor Manager Permission Level
	void supervisorManagerPermissionTest() {
		String role = "SupManager";
		int expected = 3;
		
		int actual = PermissionsManager.checkPermissions(role);
		
		assertEquals(expected, actual);
	}

}
