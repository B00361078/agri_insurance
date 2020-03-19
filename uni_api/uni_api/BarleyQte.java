package uni_api;

import business.RiskData;

public class BarleyQte extends AgriQuote {
	
	public BarleyQte(RiskData riskdata) {
		//setting risk data for the quote, do check here to make sure valid
		super(riskdata);
	}
	
		
	private double calculatePrice () {
		premium = RatingEngine.getPremium(zone, riskdata.hectares, riskdata.vph);
		return premium;	
	}

	@Override
	public void makeQuote() {
		
	}
}


