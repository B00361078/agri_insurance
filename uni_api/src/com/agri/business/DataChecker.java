package com.agri.business;

import java.util.Arrays;
import java.util.List;

import com.agri.exceptions.InvalidDataException;

public class DataChecker {
	
	protected RiskData riskdata;
	protected String zone;
	protected boolean isDataValid;
	
	private final static String [] crops = {"Barley", "Raspberries", "WinterWheat", "Strawberries"};
	
	public boolean isDataValid() {
		return isDataValid;
	}

	public void setDataValid(boolean isDataValid) {
		this.isDataValid = isDataValid;
	}

	public DataChecker(RiskData riskdata) throws InvalidDataException {
		this.riskdata = riskdata;
		checkZone();
		checkCropValid();
		checkBusinessRules();
	}
	
	
	public void checkZone() throws InvalidDataException {
		zone = Zones.zoneChecker(riskdata.council);
		if (zone == null) {
			setDataValid(false);
			throw new InvalidDataException("invalid council entered");
		}
		else {
			setDataValid(true);
		}
	}
	
	public void checkCropValid () throws InvalidDataException {
		List<String> availableCrops = Arrays.asList(crops);
		if(!(availableCrops.contains(riskdata.crop))) {
			setDataValid(false);
			throw new InvalidDataException("invalid crop entered");
		}
		else {
			setDataValid(true);
		}
	}
	
	public void checkBusinessRules() throws InvalidDataException {
		new BusinessRules(zone, riskdata.hectares, riskdata.vph, riskdata.crop);
		if (BusinessRules.getDecision()==false) {
			setDataValid(false);
			throw new InvalidDataException("data did not meet business rules requirements");
		}
		else {
			setDataValid(true);
		}
	}
}
