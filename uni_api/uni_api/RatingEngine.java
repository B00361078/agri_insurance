package uni_api;

import java.util.Random;

public class RatingEngine {
	
	public static int getPremium() {
		Random premGenerator = new Random();
		int premium = premGenerator.nextInt(10000);
		return premium;
	}
}
