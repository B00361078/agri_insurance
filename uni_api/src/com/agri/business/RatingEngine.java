package com.agri.business;

import java.text.DecimalFormat;

public class RatingEngine {

	public static double getPremium(String crop, int SI) {
		
		DecimalFormat decimal = new DecimalFormat("########0.00");
		
		double calc;
		String value;
		double premium;
		
		switch (crop) {
			case "Barley":
				calc = SI * 0.02;
				value = decimal.format(calc);
				premium = Double.parseDouble(value);
				return premium;
			case "Strawberries":
				calc = SI * 0.07;
				value = decimal.format(calc);
				premium = Double.parseDouble(value);
				return premium;
			case "Raspberries":
				calc = SI * 0.19;
				value = decimal.format(calc);
				premium = Double.parseDouble(value);
				return premium;
			case "WinterWheat":
				calc = SI * 0.11;
				value = decimal.format(calc);
				premium = Double.parseDouble(value);
				return premium;
			default:
				return 0.00;
		}
	}
}
