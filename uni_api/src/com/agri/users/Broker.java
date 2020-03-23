package com.agri.users;

import com.agri.permissions.PermissionsManager;

public class Broker extends User {

	public Broker() {
		super();
		setRole("Broker");
		PermissionsManager.checkPermissions(this);
	}
}
