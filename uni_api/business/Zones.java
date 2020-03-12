package business;

import java.util.Arrays;
import java.util.List;

//zone1 to zone3 could be declared as const, then zoneChecker could be a static method.
public class Zones {
	// now changed to final (constant)
	private final static String [] zone1 = {"Inverclyde", "Renfrewshire", "West Dunbartonshire",  "East Dunbartonshire", 
			"Glasgow", "East Renfrewshire", "North Lanarkshire", "Falkirk", "West Lothian", "Edinburgh", 
			"Midlothian", "East Lothian"};

	private final static String [] zone2 = {"North Ayrshire", "East Ayrshire", "South Ayrshire",  "Dumfries and Galloway", 
				"South Lanarkshire", "Scottish Borders"};

	private final static String [] zone3 = {"Orkney", "Shetland"};
	
	// now static
	public static String zoneChecker(String area) {
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

