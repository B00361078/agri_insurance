package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.permissions.PermissionsManager;

class PermissionsManagerTest {
	

	@Test //get broker permission level
	void brokerTest() {
		
		String role = "Broker";
		int expected = 1;
		
		int actual = PermissionsManager.checkPermissions(role);
		
		assertEquals(expected, actual);
	}
	
	@Test //get supervisor permission level
	void supervisorTest() {
		
		String role = "Supervisor";
		int expected = 2;
		
		int actual = PermissionsManager.checkPermissions(role);
		
		assertEquals(expected, actual);
	}
	
	@Test //get Supervisor Manager permission level
	void supManagerTest() {
		
		String role = "SupManager";
		int expected = 3;
		
		int actual = PermissionsManager.checkPermissions(role);
		
		assertEquals(expected, actual);
	}
	
	@Test //get Sys Admin permission level
	void sysAdminTest() {
		
		String role = "SysAdmin";
		int expected = 4;
		
		int actual = PermissionsManager.checkPermissions(role);
		
		assertEquals(expected, actual);
	}
	
	@Test //get default permission level
	void defaultTest() {
		
		new PermissionsManager();
		String role = "default";
		int expected = 0;
		
		int actual = PermissionsManager.checkPermissions(role);
		
		assertEquals(expected, actual);
	}

}
