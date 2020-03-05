package business;

import java.util.Arrays;
import java.util.List;

public class Zones {
	
	String [] zone1 = {"Inverclyde", "Renfrewshire", "West Dunbartonshire",  "East Dunbartonshire", 
			"Glasgow", "East Renfrewshire", "North Lanarkshire", "Falkirk", "West Lothian", "Edinburgh", 
			"Midlothian", "East Lothian"};

	String [] zone2 = {"North Ayrshire", "East Ayrshire", "South Ayrshire",  "Dumfries and Galloway", 
				"South Lanarkshire", "Scottish Borders"};

	String [] zone3 = {"Orkney", "Shetland"};
	
	public String zoneChecker(String area) {
		List<String> z1 = Arrays.asList(zone1);
		List<String> z2 = Arrays.asList(zone2);
		List<String> z3 = Arrays.asList(zone3);
		
		if(z1.contains(area)) {
			return "Zone1";
		}
		else if (z2.contains(area)) {
			return "Zone2";
		}
		else if (z3.contains(area)) {
			return "Zone3";
		}
		return null;
	}
}

