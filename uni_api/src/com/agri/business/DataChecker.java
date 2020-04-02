package com.agri.business;

import java.util.Arrays;
import java.util.List;

import com.agri.exceptions.InvalidDataException;

public class DataChecker {
	
	protected RiskData riskdata;
	protected String zone;
	public boolean isDataValid;
	// available crops to quote for
	private final static String [] crops = {"Barley", "Raspberries", "WinterWheat", "Strawberries"};
	
	public boolean getDataValid() {
		return isDataValid;
	}

	public void setDataValid(boolean isDataValid) {
		this.isDataValid = isDataValid;
	}
	// check data is valid for crops, zone and business rules
	public DataChecker(RiskData riskdata) throws InvalidDataException {
		this.riskdata = riskdata;
		checkZone();
		checkCropValid();
		checkBusinessRules();
	}
	
	// validate the council
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
	// check crop is valid
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
	// get decision from business rules
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
