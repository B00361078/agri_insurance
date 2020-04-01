package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.permissions.PermissionsManager;
import com.agri.users.SupervisorManager;

class SupervisorManagerPermTest {

	@Test
	//Check Supervisor Manager Permission Level
	void supervisorManagerPermissionTest() {
		int expected = 3;
		
		int actual = new SupervisorManager().getPermissionsLevel();
		
		assertEquals(expected, actual);
	}

}
