package com.agri.users;

import com.agri.permissions.PermissionsManager;

public class Default implements User {
	
	protected String role;
	protected int permLevel;

	public Default() {
		this.role = "Default";
	}

	@Override
	public int getPermissionsLevel() {
		permLevel = PermissionsManager.checkPermissions(role);
		return permLevel;
	}
}