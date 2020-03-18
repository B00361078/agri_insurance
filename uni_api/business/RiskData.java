package business;

public class RiskData {
	
	public String crop;
	public String council;
	public int hectares;
	public int vph;
	
	public RiskData(String crop, String council, int hectares, int vph) {
		//this would pull risk data from UI and create this object
		this.crop = crop;
		this.council = council;
		this.hectares = hectares;
		this.vph = vph;
	}
}
