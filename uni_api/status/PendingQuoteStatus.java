package status;

import exceptions.PermissionException;
import uni_api.AgriQuote;
import users.User;

public class PendingQuoteStatus implements QuoteStatus {
	
AgriQuote quote;
	
	public PendingQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote(User user) throws Exception {
		throw new PermissionException("you must save the quote first");
	}

	@Override
	public void declineQuote(User user) throws Exception {
		throw new PermissionException("you must save the quote first");	
	}

	@Override
	public void saveQuote(User user) throws Exception {
		if (user.getPermissionLevel() < 1) {
			throw new PermissionException("you do not have permission to perform that action");
		}
		quote.setStatus(quote.getSavedState());
	}

	@Override
	public void referQuote(User user) throws Exception {
		throw new PermissionException("you must save the quote first");	
	}

}
