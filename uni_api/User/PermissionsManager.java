package User;

public class PermissionsManager {
		
	public Object checkPermissions(Object obj) {
		if (obj instanceof Broker) {
			return new BrokerPerms();
		}
		else if (obj instanceof Broker) {
			return new SupervisorPerms();
		}
		else if (obj instanceof Broker) {
				return new SupervisorManagerPerms();
		}
		else return null;
 }
	
}
