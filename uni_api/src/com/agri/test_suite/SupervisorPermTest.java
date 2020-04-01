package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.permissions.PermissionsManager;

class SupervisorPermTest {

	@Test
	//check Supervisor Permission Level
	void supervisorPermissiontest() {
		String role = "Supervisor";
		int expected = 2;
		
		int actual = PermissionsManager.checkPermissions(role);
		
		assertEquals(expected, actual);
	}

}
