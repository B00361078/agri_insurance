package status;

import uni_api.AgriQuote;

public class ReferredQuoteStatus implements QuoteStatus {
	
AgriQuote quote;
	
	public ReferredQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote() {
		quote.setStatus(quote.getAcceptedState());
		System.out.println("Your quote is has been accepted");
	}

	@Override
	public void declineQuote() {
		quote.setStatus(quote.getAcceptedState());
		System.out.println("Your quote is has been rejected");
	}

	@Override
	public void saveQuote() {
		System.out.println("Your quote has already been saved");
		
	}

	@Override
	public void referQuote() {
		System.out.println("Your quote is already referred");
		
	}

}
