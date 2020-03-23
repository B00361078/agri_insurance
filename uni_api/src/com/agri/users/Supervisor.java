package com.agri.users;

import com.agri.permissions.PermissionsManager;

public class Supervisor extends User{

	public Supervisor() {
		super();
		setRole("Supervisor");
		PermissionsManager.checkPermissions(this);
	}	
}
