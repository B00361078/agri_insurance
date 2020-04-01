package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.permissions.PermissionsManager;
import com.agri.users.SysAdmin;

class SysAdminPermTest {

	@Test
	//Check System Admin Permission Level
	void sysAdminPermissiontest() {
		int expected = 4;
		
		int actual = new SysAdmin().getPermissionsLevel();
		
		assertEquals(expected, actual);
	}

}
