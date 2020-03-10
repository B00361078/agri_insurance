package uni_api;

public class QuoteFactory {

	public static Quote generateQuote(String crop, String council, int hectares, int vph) {
		switch(crop) {
		case "Barley": {
			return new BarleyQte(council, hectares, vph);
			}
		case "Raspberries": {
			return new RaspberryQte(council, hectares, vph);
			}
		case "Winter Wheat": {
			return new WheatQte(council, hectares, vph);
			}
		case "Strawberries": {
			return new StrawberryQte(council, hectares, vph);
			}
		default:
			return null;
		}
	}

}
