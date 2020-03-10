package uni_api;

public abstract class Quote {
	
	protected double premium;
	protected String qteNumber;
	protected String status;
	
	public Quote() {
		this.generateQuote();
	}
	
	public abstract void generateQuote();
}
