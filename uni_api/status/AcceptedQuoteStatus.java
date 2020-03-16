package status;

import uni_api.AgriQuote;

public class AcceptedQuoteStatus implements QuoteStatus {
	
	AgriQuote quote;
	
	public AcceptedQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote() {
		quote.setStatus(quote.getAcceptedState());
		System.out.println("Your quote is already accepted");
	}

	@Override
	public void declineQuote() {
		quote.setStatus(quote.getRejectedState());
		System.out.println("Your quote is rejected");
	}

	@Override
	public void saveQuote() {
		System.out.println("Your quote is already saved and accepted");
	}

	@Override
	public void referQuote() {
		System.out.println("Your quote is already accepted, cannot refer");
		
	}

}
