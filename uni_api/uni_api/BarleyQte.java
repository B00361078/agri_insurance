package uni_api;

import business.Zones;

public class BarleyQte extends AgriQuote {
	
	public BarleyQte(String council, int hectares, int vph) {
		//setting AgriQuote variables here
		super(council, hectares, vph);
	}
	
	private String checkZone(String council) {
		new Zones();
		zone = Zones.zoneChecker(council);
			if (zone != null) {
				setZone(zone);
				return zone;
			}
			else {
				setZone("invalid");
				return zone;
			}
	}
	
	private double calculatePrice (String zone, int hectares, int vph) {
			if (getZone() != null) {
				premium = RatingEngine.getPremium(zone, hectares, vph);
				setPremium(premium);
			}
			else {
				premium = 0;
				setPremium(premium);
			}
		return premium;	
	}

	@Override
	public void generateQuote() {
		// override method now doing things
		zone = checkZone(council);
		System.out.println("this is the zone   " + zone);
		calculatePrice (zone, hectares, vph);
		System.out.println("this is the price   " + getPremium());
		
	}
}

