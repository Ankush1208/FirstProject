package com.gojek.parkingLot.Validator;

import com.gojek.parkingLot.exceptions.ParkingLotException;

public interface AbstractValidator {
	
	public boolean validate(String input);
	public void executeCommandsAfterValidation(String input) throws ParkingLotException;

}
