package uni_api;

import business.DataChecker;
import business.RiskData;
import exceptions.PermissionException;
import users.User;
public class AgriInsuranceFactory {
	
	public static AgriQuote createNewQuote(User user, RiskData riskdata) throws Exception {
		DataChecker check = new DataChecker(riskdata);
		check.isDataValid(); //checking RiskData is valid before quoting
		if (!(user.getPermissionLevel() >= 1)) { //check permission at earliest opportunity
			throw new PermissionException("you do not have permission to quote");
		}
		switch(riskdata.crop) {
		case "Barley": {
			return new BarleyQte(riskdata);
			}
		case "Raspberries": {
			return new RaspberryQte(riskdata);
			}
		case "WinterWheat": {
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
