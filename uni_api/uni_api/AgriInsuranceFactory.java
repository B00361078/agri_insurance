package uni_api;

import exceptions.PermissionException;
import users.User;
public class AgriInsuranceFactory {
	
	public static AgriQuote createNewQuote(User user, String crop, String council, int hectares, int vph) throws PermissionException {
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
