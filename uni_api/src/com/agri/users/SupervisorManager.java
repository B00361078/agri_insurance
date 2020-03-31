package com.agri.users;

import com.agri.permissions.PermissionsManager;

public class SupervisorManager implements User {
	
	protected String role;
	protected int permLevel;

	public SupervisorManager() {
		this.role = "SupManager";
	}

	@Override
	public int getPermissionsLevel() {
		permLevel = PermissionsManager.checkPermissions(role);
		return permLevel;
	}
}
