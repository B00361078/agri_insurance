package users;

import permissions.PermissionsManager;

public class Supervisor extends User{

	public Supervisor() {
		super();
		setRole("Supervisor");
		PermissionsManager.checkPermissions(this);
	}	
}
