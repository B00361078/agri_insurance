package uni_api;

import exceptions.ActionException;
import exceptions.PermissionException;
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
	protected String council;
	protected int hectares;
	protected int vph;
	protected String zone;
	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getCouncil() {
		return council;
	}

	public void setCouncil(String council) {
		this.council = council;
	}

	public int getHectares() {
		return hectares;
	}

	public void setHectares(int hectares) {
		this.hectares = hectares;
	}

	public int getVph() {
		return vph;
	}

	public void setVph(int vph) {
		this.vph = vph;
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
	
	public AgriQuote(String council, int hectares, int vph) {
		this.council = council;
		this.hectares = hectares;
		this.vph = vph;
		this.currentStatus = new PendingQuoteStatus(this);// set current status to saved
		this.makeQuote();
	}
	
	public void setStatus(QuoteStatus currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public QuoteStatus getStatus() {
		return currentStatus;
	}

	public void acceptQuote(User user) throws ActionException {
		currentStatus.acceptQuote(user);
	}
	
	public void declineQuote(User user) throws ActionException {
		currentStatus.declineQuote(user);
	}
	public void saveQuote(User user) throws ActionException {
		currentStatus.saveQuote(user);
	}
	public void referQuote(User user) throws ActionException {
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
