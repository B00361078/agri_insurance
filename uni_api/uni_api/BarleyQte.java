package uni_api;

import business.BusinessRules;
import business.RiskData;
import business.Zones;

public class BarleyQte extends AgriQuote {
	
	public BarleyQte(RiskData riskdata) {
		//setting risk data for the quote, do check here to make sure valid
		super(riskdata);
	}
	
	private void checkDataValid() {
		zone = Zones.zoneChecker(riskdata.council);
			if (zone == null) {
				isValid = false;
			}
			else {
				businessRules = new BusinessRules(zone, riskdata.hectares, riskdata.vph, riskdata.crop);
				isValid = BusinessRules.getDecision();
			}
	}
		
	private double calculatePrice () {
				premium = RatingEngine.getPremium(zone, riskdata.hectares, riskdata.vph);
		return premium;	
	}

	@Override
	public void makeQuote() {
		checkDataValid();
		if (isValid == false) {
			System.out.println("quote is invalid");
		}
		else {
			System.out.println("quote is valid");
			calculatePrice ();
			new QteNumberGenerator();
		}
		
	}
}

