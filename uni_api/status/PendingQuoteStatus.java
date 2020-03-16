package status;

import uni_api.AgriQuote;
import users.User;

public class PendingQuoteStatus implements QuoteStatus {
	
AgriQuote quote;
	
	public PendingQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote(User user) {
		System.out.println("quote must be saved first");// TODO Auto-generated method stub
		
	}

	@Override
	public void declineQuote(User user) {
		System.out.println("quote must be saved first");// TODO Auto-generated method stub
		
	}

	@Override
	public void saveQuote(User user) {
		System.out.println("quote has been saved");
		quote.setStatus(quote.getSavedState());
		
	}

	@Override
	public void referQuote(User user) {
		System.out.println("quote must be saved first");
		
	}

}
