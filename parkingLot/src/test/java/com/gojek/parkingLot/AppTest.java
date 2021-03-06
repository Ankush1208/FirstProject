package com.gojek.parkingLot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gojek.parkingLot.Model.Car;
import com.gojek.parkingLot.exceptions.ErrorCode;
import com.gojek.parkingLot.exceptions.ParkingLotException;
import com.gojek.parkingLot.service.ParkingLotService;
import com.gojek.parkingLot.service.ParkingLotServiceImpl;



/**
 * Unit test for simple App.
 */
public class AppTest 
   
{
  
private int parkingLevel;
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static ParkingLotService instance = null;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void init()
	{
		parkingLevel = 1;
		instance=new ParkingLotServiceImpl();
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUp()
	{
		instance.doCleanup();
		System.setOut(null);
		
	}
	
	@Test
	public void createParkingLot() throws Exception
	{
		

		instance.createParkingLot(parkingLevel, 65);
		assertTrue("createdparkinglotwith65slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
	}
	
	@Test
	public void alreadyExistParkingLot() throws Exception
	{
		
		instance.createParkingLot(parkingLevel, 65);
		assertTrue("createdparkinglotwith65slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_ALREADY_EXIST.getMessage()));
		instance.createParkingLot(parkingLevel, 65);

	}
	
	@Test
	public void testParkingCapacity() throws Exception
	{
		instance.createParkingLot(parkingLevel, 6);
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLevel, new Car("KA-01-HH-9999", "White"));
		instance.park(parkingLevel, new Car("KA-01-BB-0001", "Black"));
		assertEquals(3, instance.getAvailableSlotsCount(parkingLevel).get().intValue());

	}
	
	@Test
	public void testEmptyParkingLot() throws Exception
	{
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage()));
		instance.getStatus(parkingLevel);
		assertTrue("Sorry,CarParkingDoesnotExist".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
		instance.createParkingLot(parkingLevel, 6);
		instance.getStatus(parkingLevel);
		assertTrue(
				"Sorry,CarParkingDoesnotExist\ncreatedparkinglotwith6slots\nSlotNo.\tRegistrationNo.\tColor\nSorry,parkinglotisempty."
						.equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));

	}
	
	@Test
	public void testParkingLotIsFull() throws Exception
	{
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage()));
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		assertEquals("Sorry,CarParkingDoesnotExist", outContent.toString().trim().replace(" ", ""));
		instance.createParkingLot(parkingLevel, 2);
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLevel, new Car("KA-01-HH-9999", "White"));
		instance.park(parkingLevel, new Car("KA-01-BB-0001", "Black"));
		assertTrue("createdparkinglotwith2slots\\nAllocatedslotnumber:1\nAllocatedslotnumber:2\nSorry,parkinglotisfull"
				.equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));

	}
	
	@Test
	public void testNearestSlotAllotment() throws Exception
	{
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage()));
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		assertEquals("Sorry,CarParkingDoesnotExist", outContent.toString().trim().replace(" ", ""));
		instance.createParkingLot(parkingLevel, 5);
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLevel, new Car("KA-01-HH-9999", "White"));
		instance.getSlotNoFromRegistrationNo(parkingLevel, "KA-01-HH-1234");
		instance.getSlotNoFromRegistrationNo(parkingLevel, "KA-01-HH-9999");
		assertTrue("createdparkinglotwith5slots\nAllocatedslotnumber:1\nAllocatedslotnumber:2"
				.equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));

	}
	
	@Test
	public void leave() throws Exception
	{
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage()));
		instance.unPark(parkingLevel, 2);
		assertEquals("Sorry,CarParkingDoesnotExist", outContent.toString().trim().replace(" ", ""));
		instance.createParkingLot(parkingLevel, 6);
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLevel, new Car("KA-01-HH-9999", "White"));
		instance.park(parkingLevel, new Car("KA-01-BB-0001", "Black"));
		instance.unPark(parkingLevel, 4);
		assertTrue(
				"Sorry,CarParkingDoesnotExist\ncreatedparkinglotwith6slots\nAllocatedslotnumber:1\nAllocatedslotnumber:2\nAllocatedslotnumber:3\nSlotnumber4isfree"
						.equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));

	}
	
	@Test
	public void testWhenVehicleAlreadyPresent() throws Exception
	{
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage()));
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		assertEquals("Sorry,CarParkingDoesnotExist", outContent.toString().trim().replace(" ", ""));
		instance.createParkingLot(parkingLevel, 3);
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		assertTrue(
				"createdparkinglotwith3slots\nAllocatedslotnumber:1\nSorry,vehicleisalreadyparked."
						.equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
	}
	
	@Test
	public void testWhenVehicleAlreadyLeft() throws Exception
	{
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage()));
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		assertEquals("Sorry,CarParkingDoesnotExist", outContent.toString().trim().replace(" ", ""));
		instance.createParkingLot(parkingLevel, 99);
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLevel, new Car("KA-01-HH-9999", "White"));
		instance.unPark(parkingLevel, 1);
		instance.unPark(parkingLevel, 1);
		assertTrue(
				"Sorry,CarParkingDoesnotExist\ncreatedparkinglotwith99slots\nAllocatedslotnumber:1\nAllocatedslotnumber:2\nSlotnumberisEmptyAlready."
						.equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));

	}
	
	@Test
	public void testStatus() throws Exception
	{
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage()));
		instance.getStatus(parkingLevel);
		assertEquals("Sorry,CarParkingDoesnotExist", outContent.toString().trim().replace(" ", ""));
		instance.createParkingLot(parkingLevel, 8);
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLevel, new Car("KA-01-HH-9999", "White"));
		instance.getStatus(parkingLevel);
		assertTrue(
				"Sorry,CarParkingDoesnotExist\ncreatedparkinglotwith8slots\nAllocatedslotnumber:1\nAllocatedslotnumber:2\nSlotNo.\tRegistrationNo.\tColor\n1\tKA-01-HH-1234\tWhite\n2\tKA-01-HH-9999\tWhite"
						.equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
	
	}
	
	@Test
	public void testGetSlotsByRegNo() throws Exception
	{
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage()));
		instance.getSlotNoFromRegistrationNo(parkingLevel, "KA-01-HH-1234");
		assertEquals("Sorry,CarParkingDoesnotExist", outContent.toString().trim().replace(" ", ""));
		instance.createParkingLot(parkingLevel, 10);
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLevel, new Car("KA-01-HH-9999", "White"));
		instance.getSlotNoFromRegistrationNo(parkingLevel, "KA-01-HH-1234");
		assertEquals("Sorry,CarParkingDoesnotExist\n" + "Createdparkinglotwith10slots\n" + "\n"
				+ "Allocatedslotnumber:1\n" + "\n" + "Allocatedslotnumber:2\n1",
				outContent.toString().trim().replace(" ", ""));
		instance.getSlotNoFromRegistrationNo(parkingLevel, "KA-01-HH-1235");
		assertEquals("Sorry,CarParkingDoesnotExist\n" + "Createdparkinglotwith10slots\n" + "\n"
				+ "Allocatedslotnumber:1\n" + "\n" + "Allocatedslotnumber:2\n1\nNotFound",
				outContent.toString().trim().replace(" ", ""));

	}
	
	@Test
	public void testGetSlotsByColor() throws Exception
	{
		thrown.expect(ParkingLotException.class);
		thrown.expectMessage(is(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage()));
		instance.getRegNumberForColor(parkingLevel, "white");
		assertEquals("Sorry,CarParkingDoesnotExist", outContent.toString().trim().replace(" ", ""));
		instance.createParkingLot(parkingLevel, 7);
		instance.park(parkingLevel, new Car("KA-01-HH-1234", "White"));
		instance.park(parkingLevel, new Car("KA-01-HH-9999", "White"));
		instance.getStatus(parkingLevel);
		instance.getRegNumberForColor(parkingLevel, "Cyan");
		assertEquals(
				"Sorry,CarParkingDoesnotExist\n" + "Createdparkinglotwith7slots\n" + "\n" + "Allocatedslotnumber:1\n"
						+ "\n" + "Allocatedslotnumber:2\nKA-01-HH-1234,KA-01-HH-9999",
				outContent.toString().trim().replace(" ", ""));
		instance.getRegNumberForColor(parkingLevel, "Red");
		assertEquals(
				"Sorry,CarParkingDoesnotExist\n" + "Createdparkinglotwith7slots\n" + "\n" + "Allocatedslotnumber:1\n"
						+ "\n" + "Allocatedslotnumber:2\n" + "KA-01-HH-1234,KA-01-HH-9999,Notfound",
				outContent.toString().trim().replace(" ", ""));

	}
}
