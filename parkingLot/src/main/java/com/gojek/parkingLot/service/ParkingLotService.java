package com.gojek.parkingLot.service;

import java.util.Optional;

import com.gojek.parkingLot.Model.Vehicle;
import com.gojek.parkingLot.exceptions.ParkingLotException;



public interface ParkingLotService {

	
public void createParkingLot(int level, int capacity) throws ParkingLotException;
	
	public Optional<Integer> park(int level, Vehicle vehicle) throws ParkingLotException;
	
	public void unPark(int level, int slotNumber) throws ParkingLotException;
	
	public void getStatus(int level) throws ParkingLotException;
	
	public Optional<Integer> getAvailableSlotsCount(int level) throws ParkingLotException;
	
	public void getRegNumberForColor(int level, String color) throws ParkingLotException;
	
	public void getSlotNumbersFromColor(int level, String colour) throws ParkingLotException;
	
	public int getSlotNoFromRegistrationNo(int level, String registrationNo) throws ParkingLotException;
	
	public void doCleanup();

}
