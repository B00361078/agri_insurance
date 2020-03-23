package com.agri.quote;

import com.agri.business.RiskData;
import com.agri.business.Zones;

public class RaspberryQte extends AgriQuote {

	public RaspberryQte(RiskData riskdata) {
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
