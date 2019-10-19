package com.gojek.parkingLot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import com.gojek.parkingLot.Model.Vehicle;
import com.gojek.parkingLot.constants.Constants;
import com.gojek.parkingLot.dao.ParkingLotDao;
import com.gojek.parkingLot.dao.impl.ParkingLotDaoImpl;
import com.gojek.parkingLot.exceptions.ErrorCode;
import com.gojek.parkingLot.exceptions.ParkingLotException;



public class ParkingLotServiceImpl implements ParkingLotService{
	
	private ParkingLotDao<Vehicle> parkingLotdao =null;

	public void createParkingLot(int level, int capacity) throws ParkingLotException {
		if(parkingLotdao!=null)
			throw new ParkingLotException(ErrorCode.PARKING_ALREADY_EXIST.getMessage());
		List<Integer> parkingLevels = new ArrayList<>();
		List<Integer> capacityList = new ArrayList<>();
		parkingLevels.add(level);
		capacityList.add(capacity);
		parkingLotdao=ParkingLotDaoImpl.getInstance(parkingLevels, capacityList);
		System.out.println("Created parking lot with " + capacity + " slots");

	}

	public Optional<Integer> park(int level, Vehicle vehicle) throws ParkingLotException {
		Optional<Integer> value = Optional.empty();
		validateParkingLot();
		try
		{
			value = Optional.of(parkingLotdao.parkCar(level, vehicle));
			if (value.get() == Constants.NOT_AVAILABLE)
				System.out.println("Sorry, parking lot is full");
			else if (value.get() == Constants.VEHICLE_ALREADY_EXIST)
				System.out.println("Sorry, vehicle is already parked.");
			else
				System.out.println("Allocated slot number: " + value.get());
		}
		catch (Exception e)
		{
			throw new ParkingLotException(ErrorCode.PROCESSING_ERROR.getMessage(), e);
		}
	
		return value;
	}

	private void validateParkingLot() throws ParkingLotException {
		if (parkingLotdao == null)
		{
			throw new ParkingLotException(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage());
		}		
	}

	public void unPark(int level, int slotNumber) throws ParkingLotException {
		validateParkingLot();
		try
		{
			
			if (parkingLotdao.leaveCar(level, slotNumber))
				System.out.println("Slot number " + slotNumber + " is free");
			else
				System.out.println("Slot number is Empty Already.");
		}
		catch (Exception e)
		{
			throw new ParkingLotException(ErrorCode.INVALID_VALUE.getMessage().replace("{variable}", "slot_number"), e);
		}		
	}

	public void getStatus(int level) throws ParkingLotException {
		validateParkingLot();
		try
		{
			System.out.println("Slot No.\tRegistration No.\tColor");
			List<String> statusList = parkingLotdao.getStatus(level);
			if (statusList.size() == 0)
				System.out.println("Sorry, parking lot is empty.");
			else
			{
				for (String statusSting : statusList)
				{
					System.out.println(statusSting);
				}
			}
		}
		catch (Exception e)
		{
			throw new ParkingLotException(ErrorCode.PROCESSING_ERROR.getMessage(), e);
		}		
	}

	public Optional<Integer> getAvailableSlotsCount(int level) throws ParkingLotException {
		Optional<Integer> value = Optional.empty();
		validateParkingLot();
		try
		{
			value = Optional.of(parkingLotdao.getAvailableSlotsCount(level));
		}
		catch (Exception e)
		{
			throw new ParkingLotException(ErrorCode.PROCESSING_ERROR.getMessage(), e);
		}
		return value;
	}

	public void getRegNumberForColor(int level, String color) throws ParkingLotException {
		validateParkingLot();
		try
		{
			List<String> registrationList = parkingLotdao.getRegNumberForColor(level, color);
			if (registrationList.size() == 0)
				System.out.println("Not Found");
			else
				System.out.println(String.join(", ", registrationList));
		}
		catch (Exception e)
		{
			throw new ParkingLotException(ErrorCode.PROCESSING_ERROR.getMessage(), e);
		}		
	}

	public void getSlotNumbersFromColor(int level, String color) throws ParkingLotException {
		validateParkingLot();
		try
		{
			List<Integer> slotList = parkingLotdao.getSlotNumbersFromColor(level, color);
			if (slotList.size() == 0)
				System.out.println("Not Found");
			StringJoiner joiner = new StringJoiner(", ");
			for (Integer slot : slotList)
			{
				joiner.add(slot + "");
			}
			System.out.println(joiner.toString());
		}
		catch (Exception e)
		{
			throw new ParkingLotException(ErrorCode.PROCESSING_ERROR.getMessage(), e);
		}		
	}

	public int getSlotNoFromRegistrationNo(int level, String registrationNo) throws ParkingLotException {
		int value = 0;
		validateParkingLot();
		try
		{
			value = parkingLotdao.getSlotNoFromRegistrationNo(level, registrationNo);
			System.out.println(value != 0 ? value : "Not found");
		}
		catch (Exception e)
		{
			throw new ParkingLotException(ErrorCode.PROCESSING_ERROR.getMessage(), e);
		}
	
		return value;
	}

	@Override
	public void doCleanup() {

		if(parkingLotdao!=null)
			parkingLotdao.doCleanup();
	}

}
