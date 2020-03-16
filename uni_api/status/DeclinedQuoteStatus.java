package status;

import uni_api.AgriQuote;

public class DeclinedQuoteStatus implements QuoteStatus {
	
	AgriQuote quote;
	
	public DeclinedQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote() {
		quote.setStatus(quote.getAcceptedState());
		System.out.println("Your quote is accepted");
	}

	@Override
	public void declineQuote() {
		System.out.println("Your quote is already rejected");// TODO Auto-generated method stub
	}

	@Override
	public void saveQuote() {
		System.out.println("Your quote is already saved but rejected");
	}

	@Override
	public void referQuote() {
		quote.setStatus(quote.getReferredState());
		System.out.println("Your quote has been referred");
		
	}

}
