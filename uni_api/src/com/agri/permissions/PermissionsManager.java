package com.agri.permissions;

//this class holds method for checking permissions for each user, depending on their role

public class PermissionsManager {
		
	public static int checkPermissions(String role) {
		
		switch(role) {
			case "Broker":
				return 1;
			case "Supervisor":
				return 2;
			case "SupManager":
				return 3;
			case "SysAdmin":
				return 4;
			default:
				return 0;
		}
	}
}
