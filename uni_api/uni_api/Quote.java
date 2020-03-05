package uni_api;

public abstract class Quote {
	
	protected int premium;
	protected String qteNumber;
	protected String zone;
	
	public int getPremium() {
		return premium;
	}
	
	public String getQteNumber() {
		return qteNumber;
	}
	
	public Quote() {
		this.generateQuote();
	}
	
	public abstract void generateQuote();
}
