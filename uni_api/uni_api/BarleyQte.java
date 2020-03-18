package uni_api;

import business.RiskData;
import business.Zones;

public class BarleyQte extends AgriQuote {
	
	public BarleyQte(RiskData riskdata) {
		//setting risk data for the quote, do check here to make sure valid
		super(riskdata);
	}
	
	private String checkZone() {
		zone = Zones.zoneChecker(riskdata.council);
			if (zone != null) {
				setZone(zone);
				return zone;
			}
			else {
				setZone("invalid");
				return zone;
			}
	}
	
	private double calculatePrice () {
			if (getZone() != null) {
				premium = RatingEngine.getPremium(zone, riskdata.hectares, riskdata.vph);
				setPremium(premium);
			}
			else {
				premium = 0;
				setPremium(premium);
			}
		return premium;	
	}

	@Override
	public void makeQuote() {
		// override method now doing things
		zone = checkZone();
		calculatePrice ();
	}
}

