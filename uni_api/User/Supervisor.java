package User;

public class Supervisor {

	public Supervisor() {
		super();
		// TODO Auto-generated constructor stub
		PermissionsManager permManager = new PermissionsManager();
		Object myPerms = permManager.checkPermissions(this);
		System.out.print(myPerms);
	}
	
}
