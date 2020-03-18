package uni_api;

import business.RiskData;
import exceptions.PermissionException;
import users.User;
public class AgriInsuranceFactory {
	
	public static AgriQuote createNewQuote(User user, RiskData riskdata) throws PermissionException {
		switch(riskdata.crop) {
		case "Barley": {
			return new BarleyQte(riskdata);
			}
		case "Raspberries": {
			return new RaspberryQte(riskdata);
			}
		case "Winter Wheat": {
			return new WheatQte(riskdata);
			}
		case "Strawberries": {
			return new StrawberryQte(riskdata);
			}
		default:
			return null;
		}
	}

}
