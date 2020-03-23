package uni_api;

import java.security.SecureRandom;

public class QteNumberGenerator {
	
	public static String getQteNumber() {
		SecureRandom qteNumGen = new SecureRandom();
		int num = qteNumGen.nextInt(100000);
		String numString = String.format("%05d", num);
		String qteNumber = ("QTE" + numString);
		return qteNumber;
	}
}
