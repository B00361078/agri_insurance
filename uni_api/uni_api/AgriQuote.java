package uni_api;

import status.AcceptedQuoteStatus;
import status.QuoteStatus;
import status.RejectedQuoteStatus;
import status.SavedQuoteStatus;

public abstract class AgriQuote {
	
	//parent class for Agri quotes including getters and setters for its variables
	
	protected double premium;
	protected String qteNumber;
	protected QuoteStatus accepted; //types of status using state design pattern
	protected QuoteStatus saved;
	protected QuoteStatus rejected;
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
		this.currentStatus = new SavedQuoteStatus(this);// set current status to saved
		this.accepted = new AcceptedQuoteStatus(this);
		this.rejected = new RejectedQuoteStatus(this);
		this.saved = new SavedQuoteStatus(this);
		this.makeQuote();
	}
	
	public void setStatus(QuoteStatus currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public QuoteStatus getStatus() {
		return currentStatus;
	}

	public void acceptQuote() {
		currentStatus.acceptQuote();
	}
	
	public void rejectQuote() {
		currentStatus.rejectQuote();
	}
	public void saveQuote() {
		currentStatus.saveQuote();
	}
	public QuoteStatus getAcceptedState() {
		return accepted;
	}
	public QuoteStatus getRejectedState() {
		return rejected;
	}
	public QuoteStatus getSavedState() {
		return saved;
	}
	// abstract method will be instantiates by lower level classes
	public abstract void makeQuote();

}
