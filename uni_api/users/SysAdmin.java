package users;

import permissions.PermissionsManager;

public class SysAdmin extends User {
	
	public SysAdmin() {
		super();
		setRole("SysAdmin");
		PermissionsManager.checkPermissions(this);
	}
}
