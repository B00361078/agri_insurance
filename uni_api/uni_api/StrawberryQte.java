package uni_api;

import business.Zones;

public class StrawberryQte extends AgriQuote {
	
	public StrawberryQte(String council, int hectares, int vph) {
		super(council, hectares, vph);
		//Santi: Wonderig what happens when wrog set of [council, hectares, vph] is sent to this consutructor
		// will add in exception handling for invalid parameters
	}

	@Override
	public void generateQuote() {
	
	}

}
