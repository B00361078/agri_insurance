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
	public void rejectQuote() {
		quote.setStatus(quote.getRejectedState());
		System.out.println("Your quote is rejected");
	}

	@Override
	public void saveQuote() {
		System.out.println("Your quote is already saved and accepted");
	}

}
