package com.gojek.parkingLot.dao;

import java.util.List;

import com.gojek.parkingLot.Model.Vehicle;

/**
 * 
 * 
 * This Interface maintain ParkingData including number of vehicles with their
 * allocated slots and informations
 * 
 * 
 */
public interface ParkingLotDao<T extends Vehicle> {

	public int parkCar(int level, T vehicle);

	public boolean leaveCar(int level, int slotNumber);

	public List<String> getStatus(int level);

	public List<String> getRegNumberForColor(int level, String color);

	public List<Integer> getSlotNumbersFromColor(int level, String colour);

	public int getSlotNoFromRegistrationNo(int level, String registrationNo);

	public int getAvailableSlotsCount(int level);
	
	public void doCleanup();

}
