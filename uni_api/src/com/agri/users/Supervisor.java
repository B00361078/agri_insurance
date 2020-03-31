package com.agri.users;

import com.agri.permissions.PermissionsManager;

public class Supervisor implements User{

	protected String role;
	protected int permLevel;

	public Supervisor() {
		this.role = "Supervisor";
	}

	@Override
	public int getPermissionsLevel() {
		permLevel = PermissionsManager.checkPermissions(role);
		return permLevel;
	}
}
