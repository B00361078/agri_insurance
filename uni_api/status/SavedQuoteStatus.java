package status;

import exceptions.PermissionException;
import uni_api.AgriQuote;
import users.User;

public class SavedQuoteStatus implements QuoteStatus {

AgriQuote quote;
	
	public SavedQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote(User user) throws PermissionException {
		quote.setStatus(quote.getAcceptedState());
		System.out.println("Your quote is accepted");
	}
	
	@Override
	public void declineQuote(User user) {
		quote.setStatus(quote.getDeclinedState());
		System.out.println("Your quote is rejected");	
	}

	@Override
	public void saveQuote(User user) {
		System.out.println("your quoute is already saved");
	}

	@Override
	public void referQuote(User user) {
		quote.setStatus(quote.getReferredState());
		System.out.println("Your quote has been referred");
		
	}

}
