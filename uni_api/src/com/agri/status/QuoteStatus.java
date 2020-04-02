package com.agri.status;

import com.agri.users.User;

public interface QuoteStatus {
	
	// quote status interface with available actions to perform
	
	public void acceptQuote(User user ) throws Exception;

	public void declineQuote(User user) throws Exception;
	
	public void saveQuote(User user) throws Exception;
	
	public void referQuote(User user)throws Exception;
}
