package status;

import exceptions.ActionException;
import exceptions.PermissionException;
import uni_api.AgriQuote;
import users.User;


public class AcceptedQuoteStatus implements QuoteStatus {
	
	AgriQuote quote;
	
	public AcceptedQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote(User user) throws ActionException {
			throw new ActionException("you cannot perform that action");
	}

	@Override
	public void declineQuote(User user) throws Exception {
		if (!(user.getPermissionLevel() > 1)) {
			throw new PermissionException("you do not have permission to perform that action");
		}
		quote.setStatus(quote.getDeclinedState());
	}

	@Override
	public void saveQuote(User user) throws ActionException {
		throw new ActionException("you cannot perform that action");
	}

	@Override
	public void referQuote(User user) throws ActionException {
		throw new ActionException("you cannot perform that action");		
	}

}
