package com.agri.quote;

import com.agri.business.QteNumberGenerator;
import com.agri.business.RatingEngine;
import com.agri.business.RiskData;

public class RaspberryQte extends AgriQuote {

	public RaspberryQte(RiskData riskdata) {
		//setting risk data for the quote
		super(riskdata);
	}
	
	private double calculatePrice () {
		setPremium(RatingEngine.getPremium(riskdata.crop, sumInsured));
		return premium;
	}
	
	private double calculateSI () {
		setSumInsured(riskdata.hectares * riskdata.vph);
		return sumInsured;
	}
	// overriden method to generate quote 
	@Override
	public void makeQuote() {
		calculateSI();
		calculatePrice();
		setQteNumber(QteNumberGenerator.getQteNumber());
	}
}
