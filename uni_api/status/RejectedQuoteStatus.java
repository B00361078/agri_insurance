package status;

import uni_api.AgriQuote;

public class RejectedQuoteStatus implements QuoteStatus {
	
	AgriQuote quote;
	
	public RejectedQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote() {
		quote.setStatus(quote.getAcceptedState());
		System.out.println("Your quote is accepted");
	}

	@Override
	public void rejectQuote() {
		System.out.println("Your quote is already rejected");// TODO Auto-generated method stub
	}

	@Override
	public void saveQuote() {
		System.out.println("Your quote is already saved but rejected");
	}

}
