package com.agri.users;

import com.agri.permissions.PermissionsManager;

public class Broker implements User {
	
	protected String role;
	protected int permLevel;

	public Broker() {
		this.role = "Broker";
	}

	@Override
	public int getPermissionsLevel() {
		permLevel = PermissionsManager.checkPermissions(role);
		return permLevel;
	}
}
