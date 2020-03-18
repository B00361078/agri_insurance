package uni_api;

import business.RiskData;
import business.Zones;

public class StrawberryQte extends AgriQuote {
	
	public StrawberryQte(RiskData riskdata) {
		super(riskdata);
		//Santi: Wonderig what happens when wrog set of [council, hectares, vph] is sent to this consutructor
		// will add in exception handling for invalid parameters
	}

	@Override
	public void makeQuote() {
	
	}

}
