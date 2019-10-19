package com.gojek.parkingLot.Validator;

import java.util.HashMap;
import java.util.Map;

import com.gojek.parkingLot.Model.Car;
import com.gojek.parkingLot.constants.Constants;
import com.gojek.parkingLot.exceptions.ErrorCode;
import com.gojek.parkingLot.exceptions.ParkingLotException;
import com.gojek.parkingLot.service.ParkingLotService;
import com.gojek.parkingLot.service.ParkingLotServiceImpl;



public class ValidatorImpl implements AbstractValidator {

	private ParkingLotService parkingLotService;
	
	private static final Map<String, Integer> ValidatorMap = new HashMap<String, Integer>();

	public ValidatorImpl() {
		this.parkingLotService=new ParkingLotServiceImpl();
		ValidatorMap.put(Constants.CREATE_PARKING_LOT, 1);
		ValidatorMap.put(Constants.PARK, 2);
		ValidatorMap.put(Constants.LEAVE, 3);
		ValidatorMap.put(Constants.STATUS, 4);
		ValidatorMap.put(Constants.REG_NUMBER_FOR_CARS_WITH_COLOUR, 5);
		ValidatorMap.put(Constants.SLOTS_NUMBER_FOR_CARS_WITH_COLOUR, 6);
		ValidatorMap.put(Constants.SLOTS_NUMBER_FOR_REG_NUMBER, 7);
	}

	public boolean validate(String input) {
		boolean flag = false;
		String[] s1 = input.split(" ");
		String key = s1[0];
		if (ValidatorMap.containsKey(key)) {
			flag = true;
		}
		return flag;
	}

	public void executeCommandsAfterValidation(String input) throws ParkingLotException {
		/*
		 * considering only level 1 parking 
		 */
		int level = 1;
		String[] inputs = input.split(" ");
		String key = inputs[0];
		switch (key)
		{
			case Constants.CREATE_PARKING_LOT:
				try
				{
					int capacity = Integer.parseInt(inputs[1]);
					parkingLotService.createParkingLot(level, capacity);
				}
				catch (NumberFormatException e)
				{
					throw new ParkingLotException(ErrorCode.INVALID_VALUE.getMessage().replace("{variable}", "capacity"));
				}
				break;
			case Constants.PARK:
				parkingLotService.park(level, new Car(inputs[1], inputs[2]));
				break;
			case Constants.LEAVE:
				try
				{
					int slotNumber = Integer.parseInt(inputs[1]);
					parkingLotService.unPark(level, slotNumber);
				}
				catch (NumberFormatException e)
				{
					throw new ParkingLotException(
							ErrorCode.INVALID_VALUE.getMessage().replace("{variable}", "slot_number"));
				}
				break;
			case Constants.STATUS:
				parkingLotService.getStatus(level);
				break;
			case Constants.REG_NUMBER_FOR_CARS_WITH_COLOUR:
				parkingLotService.getRegNumberForColor(level, inputs[1]);
				break;
			case Constants.SLOTS_NUMBER_FOR_CARS_WITH_COLOUR:
				parkingLotService.getSlotNumbersFromColor(level, inputs[1]);
				break;
			case Constants.SLOTS_NUMBER_FOR_REG_NUMBER:
				parkingLotService.getSlotNoFromRegistrationNo(level, inputs[1]);
				break;
			default:
				break;
		}

	}

}
