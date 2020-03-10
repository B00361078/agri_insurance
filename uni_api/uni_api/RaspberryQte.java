package uni_api;

import business.Zones;

public class RaspberryQte extends Quote {
	
	private String zone;
	private double calcPremium;

	public RaspberryQte(String council, int hectares, int vph) {
		zone = new Zones().zoneChecker(council);
		calcPremium = RatingEngine.getPremium(zone, hectares, vph);
	}

	@Override
	public void generateQuote() {
		premium = this.calcPremium;
		qteNumber = QteNumberGenerator.getQteNumber();
		status = "ok";
		
	}

}
