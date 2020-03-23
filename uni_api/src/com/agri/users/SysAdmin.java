package com.agri.users;

import com.agri.permissions.PermissionsManager;

public class SysAdmin extends User {
	
	public SysAdmin() {
		super();
		setRole("SysAdmin");
		PermissionsManager.checkPermissions(this);
	}
}
