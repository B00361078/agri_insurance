package uni_api;

import business.Zones;

public class StrawberryQte extends Quote {
	
	private String zone;
	private double calcPremium;

	public StrawberryQte(String council, int hectares, int vph) {
		//Santi: Wonderig what happens when wrog set of [council, hectares, vph] is sent to this consutructor
		zone = new Zones().zoneChecker(council);//see comment in class Zone.. you are using this as if it were static (not dependent in any state)
		calcPremium = RatingEngine.getPremium(zone, hectares, vph);
	}

	@Override
	public void generateQuote() {
		premium = this.calcPremium;
		qteNumber = QteNumberGenerator.getQteNumber();
		status = "ok";
		
	}

}
