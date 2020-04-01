package com.agri.test_suite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.agri.business.Zones;

class ZonesTest {

	String council;
	String actual;
	String expected;
	
	@Test
	//Check council is in Zone 1
	void zone1Test() {
		council = "Glasgow";
		expected = "Zone1";
		
		actual = Zones.zoneChecker(council);
		
		assertEquals(expected, actual);
	}
	
	@Test
	//Check council is in Zone 2
	void zone2Test() {
		council = "Scottish Borders";
		expected = "Zone2";
		
		actual = Zones.zoneChecker(council);
		
		assertEquals(expected, actual);
	}
	
	@Test
	//Check council is in Zone 3
	void zone3Test() {
		council = "Shetland";
		expected = "Zone3";
				
		actual = Zones.zoneChecker(council);
		
		assertEquals(expected, actual);
	}
	
	@Test
	//Check if council does not exist returs null
	void noZoneTest( ) {
		council = "Spain";
		expected = null;
		
		actual = Zones.zoneChecker(council);
		
		assertEquals(expected, actual);
	}

}
