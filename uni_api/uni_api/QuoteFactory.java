package uni_api;

public class QuoteFactory {

	public static Quote generateQuote(String crop, String area) {
		switch(crop) {
		case "Barley": {
			return new BarleyQte(area);
			}
		case "Raspberries": {
			return new RaspberryQte();
			}
		case "Winter Wheat": {
			return new WheatQte();
			}
		case "Strawberries": {
			return new StrawberryQte();
			}
		default:
			return null;
		}
	}

}
