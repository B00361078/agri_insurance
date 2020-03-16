package users;

public class SupervisorManager {

	public SupervisorManager() {
		super();
		PermissionsManager permManager = new PermissionsManager();
		Object myPerms = permManager.checkPermissions(this);
		System.out.print(myPerms);
		// TODO Auto-generated constructor stub
	}
	
}
