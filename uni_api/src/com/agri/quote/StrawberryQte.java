package com.agri.quote;

import com.agri.business.QteNumberGenerator;
import com.agri.business.RatingEngine;
import com.agri.business.RiskData;

public class StrawberryQte extends AgriQuote {
	
	public StrawberryQte(RiskData riskdata) {
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
