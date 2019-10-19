package com.gojek.parkingLot.dao;

import java.util.List;

import com.gojek.parkingLot.Model.Vehicle;

/**
 * 
 * This interface maintain parking data on each level
 * 
 * @author ankushvashishth
 *
 */
public interface ParkingLotLevelDao<T extends Vehicle> {

	public int parkCar(T vehicle);

	public boolean leaveCar(int slotNumber);

	public List<String> getStatus();

	public List<String> getRegNumberForColor(String color);

	public List<Integer> getSlotNumbersFromColor(String colour);

	public int getSlotNoFromRegistrationNo(String registrationNo);

	public int getAvailableSlotsCount();
	public void doCleanup();


}
