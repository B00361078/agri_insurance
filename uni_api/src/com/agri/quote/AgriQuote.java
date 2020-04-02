package com.agri.quote;

import com.agri.business.RiskData;
import com.agri.status.AcceptedQuoteStatus;
import com.agri.status.DeclinedQuoteStatus;
import com.agri.status.PendingQuoteStatus;
import com.agri.status.QuoteStatus;
import com.agri.status.ReferredQuoteStatus;
import com.agri.status.SavedQuoteStatus;
import com.agri.users.User;

public abstract class AgriQuote {
	
	//parent class for Agri quotes including getters and setters for its variables
	
	protected double premium;
	protected String qteNumber;
	protected QuoteStatus currentStatus;
	protected RiskData riskdata;
	protected int sumInsured;
	
	public AgriQuote(RiskData riskdata) {
		this.riskdata = riskdata;
		this.currentStatus = new PendingQuoteStatus(this);// set current status to pending
		this.makeQuote();
	}
	// setters and getters for variables
	public RiskData getRiskdata() {
		return riskdata;
	}

	public void setRiskdata(RiskData riskdata) {
		this.riskdata = riskdata;
	}

	public int getSumInsured() {
		return sumInsured;
	}

	public void setSumInsured(int sumInsured) {
		this.sumInsured = sumInsured;
	}
		
	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	public String getQteNumber() {
		return qteNumber;
	}

	public void setQteNumber(String qteNumber) {
		this.qteNumber = qteNumber;
	}
	
	public void setStatus(QuoteStatus currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public QuoteStatus getStatus() {
		return currentStatus;
	}
	// available actions on AgriQuote to effect status
	public void acceptQuote(User user) throws Exception {
		currentStatus.acceptQuote(user);
	}
	public void declineQuote(User user) throws Exception {
		currentStatus.declineQuote(user);
	}
	public void saveQuote(User user) throws Exception {
		currentStatus.saveQuote(user);
	}
	public void referQuote(User user) throws Exception {
		currentStatus.referQuote(user);
	}
	// getters for each status
	public QuoteStatus getAcceptedState() {
		return new AcceptedQuoteStatus(this);
	}
	public QuoteStatus getDeclinedState() {
		return new DeclinedQuoteStatus(this);
	}
	public QuoteStatus getSavedState() {
		return new SavedQuoteStatus(this);
	}
	public QuoteStatus getReferredState() {
		return new ReferredQuoteStatus(this);
	}
	// abstract method will be instantiated by lower level classes
	public abstract void makeQuote();

}
