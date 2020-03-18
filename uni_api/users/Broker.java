package users;

import permissions.PermissionsManager;

public class Broker extends User {

	public Broker() {
		super();
		PermissionsManager permManager = new PermissionsManager();
		Object myPerms = permManager.checkPermissions(this);
		// TODO Auto-generated constructor stub
	}
	
}
