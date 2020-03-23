package business;

import java.util.Map;

import static java.util.Map.entry;

public class BusinessRules {
	
	protected static int maxHectare;
	private Map<String, Integer> currentRules;
	private static boolean decision;
	private Integer maxSI;

	protected static Map<String, Integer> zone1_maxSI = Map.ofEntries
														(entry("Barley", 3000000), 
 														 entry("Wheat", 2000000),
 														 entry("Strawberries", 5000000)
														 );
	protected static Map<String, Integer> zone2_maxSI = Map.ofEntries
														(entry("Barley", 5000000), 
														 entry("Wheat", 4000000),
														 entry("Strawberries", 7000000)
														);
	protected static Map<String, Integer> zone3_maxSI = Map.ofEntries
														(entry("Barley", 7000000), 
														 entry("Wheat", 5000000),
														 entry("Strawberries", 9000000),
														 entry("Raspberries", 9000000)
														);

	public BusinessRules (String zone, int hectares, int vph, String crop) {
		decision = false;
		setZoneBusinessRules(zone);
		checkHectares(hectares, maxHectare);
		checkMaxSI(hectares, vph, crop);
		checkSIValid(hectares, vph);
	}

	private void checkMaxSI(int hectares, int vph, String crop) {
		Integer cropmaxSI = currentRules.get(crop);
		if (cropmaxSI == null) {
			setMaxSI(2000000);
		}		
		else 
			setMaxSI(cropmaxSI);
	}
	
	private void checkSIValid(int hectares, int vph) { 
		int totalSI = hectares * vph;
		if (totalSI > maxSI) {
			setDecision(false);
		}		
		else 
			setDecision(true);
	}

	public void setZoneBusinessRules(String zone) {
		switch(zone) {
		case "Zone1": {
			setMaxHectare(4000);
			setCurrentRules(zone1_maxSI);
			}
		case "Zone2": {
			setMaxHectare(8000);
			setCurrentRules(zone2_maxSI);
			}
		case "Zone3": {
			setMaxHectare(10000);
			setCurrentRules(zone3_maxSI);
			}
		default:
			setMaxHectare(2000);
		}
	}
	
	public static void checkHectares(int hectares, int maxHectares) {
		if (hectares > maxHectares ) {
			setDecision(false);
		}
		else {
			setDecision(true);
		}
	}
	
	public void setCurrentRules(Map<String, Integer> currentRules) {
		this.currentRules = currentRules;
	}

	public static void setMaxHectare(int maxHectare) {
		BusinessRules.maxHectare = maxHectare;
	}
	public static void setDecision(boolean decision) {
		BusinessRules.decision = decision;
	}
	
	public void setMaxSI(Integer maxSI) {
		this.maxSI = maxSI;
	}

	public static boolean getDecision() {
		return decision;
	}
	
}
