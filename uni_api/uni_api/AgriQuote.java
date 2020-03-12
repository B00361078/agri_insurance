package uni_api;

public abstract class AgriQuote {
	
	//parent class for Agri quotes including getters and setters for its variables
	
	protected double premium;
	protected String qteNumber;
	protected String status;
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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public AgriQuote(String council, int hectares, int vph) {
		this.council = council;
		this.hectares = hectares;
		this.vph = vph;
		this.generateQuote();
	}
	// abstract method will be instantiates by lower level classes
	public abstract void generateQuote();

}
