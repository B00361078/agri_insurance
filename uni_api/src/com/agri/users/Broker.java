package users;

import permissions.PermissionsManager;

public class Broker extends User {

	public Broker() {
		super();
		setRole("Broker");
		PermissionsManager.checkPermissions(this);
	}
}
