package uni_api;

import business.Zones;

public class BarleyQte extends Quote {

	public BarleyQte(String area) {
		String checkZone = new Zones().zoneChecker(area);
		System.out.println("this is the zone" + checkZone);
	}

	@Override
	public void generateQuote() {
		premium = RatingEngine.getPremium();
		qteNumber = QteNumberGenerator.getQteNumber();//
	}
}
