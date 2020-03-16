package status;

import exceptions.ActionException;
import exceptions.PermissionException;
import users.User;

public interface QuoteStatus {
	
	public void acceptQuote(User user ) throws ActionException, PermissionException;

	public void declineQuote(User user) throws ActionException, PermissionException;
	
	public void saveQuote(User user) throws ActionException, PermissionException;
	
	public void referQuote(User user)throws ActionException, PermissionException;
}
