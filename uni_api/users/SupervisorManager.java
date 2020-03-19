package users;

import permissions.PermissionsManager;

public class SupervisorManager extends User {

	public SupervisorManager() {
		super();
		setRole("SupManager");
		PermissionsManager.checkPermissions(this);
	}
}
