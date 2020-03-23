package com.agri.users;

import com.agri.permissions.PermissionsManager;

public class SupervisorManager extends User {

	public SupervisorManager() {
		super();
		setRole("SupManager");
		PermissionsManager.checkPermissions(this);
	}
}
