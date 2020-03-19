package status;

import exceptions.ActionException;
import exceptions.PermissionException;
import uni_api.AgriQuote;
import users.User;

public class ReferredQuoteStatus implements QuoteStatus {
	
AgriQuote quote;
	
	public ReferredQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote(User user ) throws Exception {
		if (!(user.getPermissionLevel() > 2)) {
			throw new PermissionException("you do not have permission to perform that action");
		}
		quote.setStatus(quote.getAcceptedState());
	}

	@Override
	public void declineQuote(User user) throws Exception {
		if (!(user.getPermissionLevel() > 2)) {
			throw new PermissionException("you do not have permission to perform that action");
		}
		quote.setStatus(quote.getDeclinedState());
	}

	@Override
	public void saveQuote(User user) throws Exception {
		throw new ActionException("your quote is already saved");
		
	}

	@Override
	public void referQuote(User user) throws Exception {
		throw new ActionException("your quote is already referred");
	}

}
