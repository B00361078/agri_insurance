package status;

import uni_api.AgriQuote;
import users.User;

public class ReferredQuoteStatus implements QuoteStatus {
	
AgriQuote quote;
	
	public ReferredQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote(User user ) {
		quote.setStatus(quote.getAcceptedState());
		System.out.println("Your quote is has been accepted");
	}

	@Override
	public void declineQuote(User user) {
		quote.setStatus(quote.getAcceptedState());
		System.out.println("Your quote is has been rejected");
	}

	@Override
	public void saveQuote(User user) {
		System.out.println("Your quote has already been saved");
		
	}

	@Override
	public void referQuote(User user) {
		System.out.println("Your quote is already referred");
		
	}

}
