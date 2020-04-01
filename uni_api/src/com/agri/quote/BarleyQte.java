package com.agri.quote;

import com.agri.business.QteNumberGenerator;
import com.agri.business.RatingEngine;
import com.agri.business.RiskData;

public class BarleyQte extends AgriQuote {
	
	public BarleyQte(RiskData riskdata) {
		//setting risk data for the quote, do check here to make sure valid
		super(riskdata);
		
	}
	
	private double calculatePrice () {
		premium = RatingEngine.getPremium(riskdata.crop, sumInsured);
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


