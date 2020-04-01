package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.permissions.PermissionsManager;
import com.agri.users.Supervisor;

class SupervisorPermTest {

	@Test
	//check Supervisor Permission Level
	void supervisorPermissiontest() {
		int expected = 2;
		
		int actual = new Supervisor().getPermissionsLevel();
		
		assertEquals(expected, actual);
	}

}
