package status;

import uni_api.AgriQuote;

public class SavedQuoteStatus implements QuoteStatus {

AgriQuote quote;
	
	public SavedQuoteStatus(AgriQuote quote) {
		this.quote = quote;
	}

	@Override
	public void acceptQuote() {
		quote.setStatus(quote.getAcceptedState());
		System.out.println("Your quote is accepted");
	}
	
	@Override
	public void rejectQuote() {
		quote.setStatus(quote.getRejectedState());
		System.out.println("Your quote is rejected");	
	}

	@Override
	public void saveQuote() {
		System.out.println("your quoute is already saved");
	}

}