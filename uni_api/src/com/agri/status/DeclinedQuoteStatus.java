package com.agri.status;

import com.agri.exceptions.ActionException;
import com.agri.exceptions.PermissionException;
import com.agri.quote.AgriQuote;
import com.agri.users.User;

public class DeclinedQuoteStatus implements QuoteStatus {
	
	// class for declined quote status, determines what each action can do on quote
	
	AgriQuote quote;
	
	public DeclinedQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote(User user) throws Exception {
		if (!(user.getPermissionsLevel() > 1)) {
			throw new PermissionException("you do not have permission to perform that action");
		}
		quote.setStatus(quote.getAcceptedState());
	}

	@Override
	public void declineQuote(User user) throws Exception {
		throw new ActionException("your quote is already declined");
	}

	@Override
	public void saveQuote(User user) throws Exception {
		throw new ActionException("your quote is already saved");
	}

	@Override
	public void referQuote(User user) throws Exception {
		if (!(user.getPermissionsLevel() > 1)) {
			throw new PermissionException("you do not have permission to perform that action");
		}
		quote.setStatus(quote.getReferredState());	
	}
}
