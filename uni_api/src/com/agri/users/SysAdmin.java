package com.agri.users;

import com.agri.permissions.PermissionsManager;

public class SysAdmin implements User {
	
	// implements user and gets permissions
	
	protected String role;
	protected int permLevel;

	public SysAdmin() {
		this.role = "SysAdmin";
	}

	@Override
	public int getPermissionsLevel() {
		permLevel = PermissionsManager.checkPermissions(role);
		return permLevel;
	}
}
