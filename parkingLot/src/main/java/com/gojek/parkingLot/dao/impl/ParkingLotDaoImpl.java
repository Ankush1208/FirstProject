package com.gojek.parkingLot.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gojek.parkingLot.Model.Vehicle;
import com.gojek.parkingLot.dao.ParkingLotDao;
import com.gojek.parkingLot.dao.ParkingLotLevelDao;


public class ParkingLotDaoImpl<T extends Vehicle> implements ParkingLotDao<Vehicle> {

	private Map<Integer, ParkingLotLevelDao> levelMap ;
	private static  ParkingLotDaoImpl parkingLotDaoImpl=null;
	
	private  ParkingLotDaoImpl(List<Integer> parkingLevels,
			List<Integer> capacityList) {
		if(levelMap==null)
			levelMap=new HashMap<>();
		for(int i=0;i<parkingLevels.size();i++)
		{
			levelMap.put(parkingLevels.get(i),ParkingLotLevelDaoImpl.getInstance(parkingLevels.get(i), capacityList.get(i)));
		}
		
	}
	
	public static synchronized ParkingLotDaoImpl getInstance(List<Integer> parkingLevels,
			List<Integer> capacityList) {
		
		if(parkingLotDaoImpl==null)
			parkingLotDaoImpl= new ParkingLotDaoImpl(parkingLevels,capacityList);
		return parkingLotDaoImpl;
	}
	@Override
	public int parkCar(int level, Vehicle vehicle) {
		return levelMap.get(level).parkCar(vehicle);
		}

	@Override
	public boolean leaveCar(int level, int slotNumber) {
		return  levelMap.get(level).leaveCar(slotNumber);
	}

	@Override
	public List<String> getStatus(int level) {
		return levelMap.get(level).getStatus();
	}

	@Override
	public List<String> getRegNumberForColor(int level, String color) {
		return  levelMap.get(level).getRegNumberForColor(color);
	}

	@Override
	public List<Integer> getSlotNumbersFromColor(int level, String colour) {
		return levelMap.get(level).getSlotNumbersFromColor(colour);
	}

	@Override
	public int getSlotNoFromRegistrationNo(int level, String registrationNo) {
		return levelMap.get(level).getSlotNoFromRegistrationNo(registrationNo);
	}

	@Override
	public int getAvailableSlotsCount(int level) {
		return levelMap.get(level).getAvailableSlotsCount();
	}

	@Override
	public void doCleanup() {
		for (ParkingLotLevelDao<T> parkingLotDaoLevelImpl : levelMap.values())
		{
			parkingLotDaoLevelImpl.doCleanup();
		}
		levelMap = null;
		parkingLotDaoImpl = null;		
	}

}
