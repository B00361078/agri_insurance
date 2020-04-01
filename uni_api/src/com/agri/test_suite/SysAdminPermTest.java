package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.permissions.PermissionsManager;

class SysAdminPermTest {

	@Test
	//Check System Admin Permission Level
	void sysAdminPermissiontest() {
		String role = "SysAdmin";
		int expected = 4;
		
		int actual = PermissionsManager.checkPermissions(role);
		
		assertEquals(expected, actual);
	}

}
