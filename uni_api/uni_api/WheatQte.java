package uni_api;

import business.Zones;

public class WheatQte extends AgriQuote {
	
	public WheatQte(String council, int hectares, int vph) {
		super(council, hectares, vph);
	}

	@Override
	public void generateQuote() {
	}

}
