package status;

import uni_api.AgriQuote;

public class PendingQuoteStatus implements QuoteStatus {
	
AgriQuote quote;
	
	public PendingQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote() {
		System.out.println("quote must be saved first");// TODO Auto-generated method stub
		
	}

	@Override
	public void declineQuote() {
		System.out.println("quote must be saved first");// TODO Auto-generated method stub
		
	}

	@Override
	public void saveQuote() {
		System.out.println("quote has been saved");
		quote.setStatus(quote.getSavedState());
		
	}

	@Override
	public void referQuote() {
		System.out.println("quote must be saved first");
		
	}

}
