package users;

import permissions.PermissionsManager;

public class Broker extends User {

	public Broker() {
		super();
		PermissionsManager permManager = new PermissionsManager();
		Object myPerms = permManager.checkPermissions(this);
		System.out.print(myPerms);
		// TODO Auto-generated constructor stub
	}
	
}
