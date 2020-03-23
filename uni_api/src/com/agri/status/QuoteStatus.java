package status;

import users.User;

public interface QuoteStatus {
	
	public void acceptQuote(User user ) throws Exception;

	public void declineQuote(User user) throws Exception;
	
	public void saveQuote(User user) throws Exception;
	
	public void referQuote(User user)throws Exception;
}
