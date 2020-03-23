package permissions;

import users.User;

//this class holds method for checking permissions for each user, depending on their role

public class PermissionsManager {
		
	public static User checkPermissions(User user) {
		
		if (user.getRole() == "Broker") {
			user.setPermissionLevel(1);
		}
		else if (user.getRole() == "Supervisor") {
			user.setPermissionLevel(2);
		}
		else if (user.getRole() == "SupManager") {
				user.setPermissionLevel(3);
		}
		else if (user.getRole() == "SysAdmin") {
				user.setPermissionLevel(4);	
		}
		return null;
	}
}
