package uni_api;

import java.util.Map;

import business.BusinessRules;
import business.RiskData;
import exceptions.ActionException;import exceptions.PermissionException;
import status.AcceptedQuoteStatus;
import status.QuoteStatus;
import status.ReferredQuoteStatus;
import status.DeclinedQuoteStatus;
import status.PendingQuoteStatus;
import status.SavedQuoteStatus;
import users.User;

public abstract class AgriQuote {
	
	//parent class for Agri quotes including getters and setters for its variables
	
	protected double premium;
	protected String qteNumber;
	protected QuoteStatus currentStatus;
	protected String zone;
	RiskData riskdata;
	BusinessRules businessRules;
	boolean isValid;
	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
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
	
	public AgriQuote(RiskData riskdata) {
		this.riskdata = riskdata;
		this.currentStatus = new PendingQuoteStatus(this);// set current status to saved
		this.makeQuote();
	}
	
	public void setStatus(QuoteStatus currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public QuoteStatus getStatus() {
		return currentStatus;
	}

	public void acceptQuote(User user) throws PermissionException, ActionException {
		currentStatus.acceptQuote(user);
	}
	
	public void declineQuote(User user) throws ActionException, PermissionException {
		currentStatus.declineQuote(user);
	}
	public void saveQuote(User user) throws ActionException, PermissionException {
		currentStatus.saveQuote(user);
	}
	public void referQuote(User user) throws ActionException, PermissionException {
		currentStatus.referQuote(user);
	}
	
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
	// abstract method will be instantiates by lower level classes
	public abstract void makeQuote();

}