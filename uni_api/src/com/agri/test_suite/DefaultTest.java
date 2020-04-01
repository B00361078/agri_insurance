package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.users.Default;

class DefaultTest {

	@Test
	//get default Permission Level
	void DefaultPermissiontest() {
		int expected = 0;
		
		int actual = new Default().getPermissionsLevel();
		
		assertEquals(expected, actual);
	}

}
