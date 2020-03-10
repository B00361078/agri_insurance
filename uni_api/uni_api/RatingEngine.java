package uni_api;

import java.util.Random;

public class RatingEngine {
	
	public static double getPremium(String zone, int hectares, int vph) {
		
		//this is where the rating should be generated using passed in parameters
		// zone, hectares, value per hectare etc
		Random premGenerator = new Random();
		int premium = premGenerator.nextInt(10000);
		return premium;
	}
}
