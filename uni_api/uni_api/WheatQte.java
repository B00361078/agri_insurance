package uni_api;

import business.RiskData;
import business.Zones;

public class WheatQte extends AgriQuote {
	
	public WheatQte(RiskData riskdata) {
		super(riskdata);
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
