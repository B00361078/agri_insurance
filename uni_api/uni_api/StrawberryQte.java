package uni_api;

import business.RiskData;
import business.Zones;

public class StrawberryQte extends AgriQuote {
	
	public StrawberryQte(RiskData riskdata) {
		super(riskdata);
		//Santi: Wonderig what happens when wrog set of [council, hectares, vph] is sent to this consutructor
		// will add in exception handling for invalid parameters
	}
	
	private double calculatePrice () {
		premium = RatingEngine.getPremium();
		return premium;
	}
	
	private double calculateSI () {
		sumInsured = riskdata.hectares * riskdata.vph;
		return sumInsured;
	}

	@Override
	public void makeQuote() {
		calculateSI();
		calculatePrice();
		QteNumberGenerator.getQteNumber();
	}
}

