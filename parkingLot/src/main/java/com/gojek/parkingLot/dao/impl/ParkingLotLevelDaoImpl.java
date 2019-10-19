package com.gojek.parkingLot.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.gojek.parkingLot.Model.Vehicle;
import com.gojek.parkingLot.constants.Constants;
import com.gojek.parkingLot.dao.ParkingLotLevelDao;

public class ParkingLotLevelDaoImpl<T extends Vehicle> implements ParkingLotLevelDao<T> {

	private int maxSize;
	private List<Integer> availableSlots;
	private Map<Integer, Optional<T>> m1;
	private static ParkingLotLevelDaoImpl instance = null;

	private ParkingLotLevelDaoImpl(int level, int capacity) {

		this.maxSize = capacity;
		availableSlots = new ArrayList<>();
		m1 = new HashMap<>();
		for (int i = 1; i <= capacity; i++) {
			m1.put(i, Optional.empty());
			availableSlots.add(i);
		}

	}

	public static synchronized ParkingLotLevelDaoImpl getInstance(int level, int capacity) {

		if (instance == null)
			instance = new ParkingLotLevelDaoImpl(level, capacity);
		return instance;
	}

	@Override
	public int parkCar(T vehicle) {
		int availableSlot;
		if (this.availableSlots.size() == 0) {
			return Constants.NOT_AVAILABLE;
		}

		else {
			availableSlot = availableSlots.get(0);
			if (m1.containsValue(Optional.of(vehicle)))
				return Constants.VEHICLE_ALREADY_EXIST;

			m1.put(availableSlot, Optional.of(vehicle));
			availableSlots.remove(0);
		}
		return availableSlot;
	}

	@Override
	public boolean leaveCar(int slotNumber) {
		if (!m1.get(slotNumber).isPresent())
			return false;

		availableSlots.add(slotNumber);
		m1.put(slotNumber, Optional.empty());
		return true;

	}

	@Override
	public List<String> getStatus() {
		List<String> statusList = new ArrayList<>();
		for (int i = 1; i <= maxSize; i++) {
			Optional<T> vehicle = m1.get(i);
			if (vehicle.isPresent()) {
				statusList.add(i + "\t\t" + vehicle.get().getRegistrationNo() + "\t\t" + vehicle.get().getColor());
			}
		}
		return statusList;
	}

	@Override
	public List<String> getRegNumberForColor(String color) {
		List<String> statusList = new ArrayList<>();
		for (int i = 1; i <= maxSize; i++) {
			Optional<T> vehicle = m1.get(i);
			if (vehicle.isPresent() && color.equalsIgnoreCase(vehicle.get().getColor())) {
				statusList.add(vehicle.get().getRegistrationNo());
			}
		}
		return statusList;
	}

	@Override
	public List<Integer> getSlotNumbersFromColor(String colour) {
		List<Integer> slotList = new ArrayList<>();
		for (int i = 1; i <= maxSize; i++) {
			Optional<T> vehicle = m1.get(i);
			if (vehicle.isPresent() && colour.equalsIgnoreCase(vehicle.get().getColor())) {
				slotList.add(i);
			}
		}
		return slotList;
	}

	@Override
	public int getSlotNoFromRegistrationNo(String registrationNo) {
		int result = 0;
		for (int i = 1; i <= maxSize; i++) {
			Optional<T> vehicle = m1.get(i);
			if (vehicle.isPresent() && registrationNo.equalsIgnoreCase(vehicle.get().getRegistrationNo())) {
				result = i;
			}
		}
		return result;
	}

	@Override
	public int getAvailableSlotsCount() {
		return  availableSlots.size();
	}

	@Override
	public void doCleanup() {
		this.availableSlots=null;
		m1 = null;
		instance = null;		
	}

}
