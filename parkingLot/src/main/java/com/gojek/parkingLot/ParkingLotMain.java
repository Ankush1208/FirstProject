package com.gojek.parkingLot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gojek.parkingLot.Validator.AbstractValidator;
import com.gojek.parkingLot.Validator.ValidatorImpl;
import com.gojek.parkingLot.exceptions.ErrorCode;
import com.gojek.parkingLot.exceptions.ParkingLotException;

/**
 * Entry point of ParkingLotSystem
 *
 */
public class ParkingLotMain {
	public static void main(String[] args) {
		
		AbstractValidator validator = new ValidatorImpl();
		BufferedReader bufferReader = null;
		String input = null;
		try {
			System.out.println("===================================================================");
			System.out.println("===================      GOJEK PARKING LOT     ====================");
			System.out.println("===================================================================");
			printCommands();
			switch (args.length) {
			/*
			 * Interactive command prompt based shell where commands can be typed in
			 */
			case 0: {
				System.out.println("Please Enter 'exit' to end Execution");
				System.out.println("Enter your input :");
				while (true) {
					try {
						bufferReader = new BufferedReader(new InputStreamReader(System.in));
						input = bufferReader.readLine().trim();
						if (input.equalsIgnoreCase("exit")) {
							break;
						} else {
							if (validator.validate(input)) {
								try {
									validator.executeCommandsAfterValidation(input);
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
							} else {
								System.out.println("Please enter valid command from following : \n \n");
								printCommands();
							}
						}
					} catch (Exception e) {
						throw new ParkingLotException(ErrorCode.INVALID_REQUEST.getMessage(), e);
					}
				}
				break;
			}
			/*
			 * 
			 * Read the commands from that file. File Path will be given in program arguments
			 */
			case 1: {
				File inputFile = new File(args[0]);
				try {
					bufferReader = new BufferedReader(new FileReader(inputFile));
					int lineNo = 1;
					while ((input = bufferReader.readLine()) != null) {
						input = input.trim();
						if (validator.validate(input)) {
							try {
								validator.executeCommandsAfterValidation(input);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						} else
							System.out.println("Incorrect Command Found at line: " + lineNo + " ,Input: " + input);
						lineNo++;
					}
				} catch (Exception e) {
					throw new ParkingLotException(ErrorCode.INVALID_FILE.getMessage(), e);
				}
				break;
			}
			default:
				System.out.println("Invalid input. Usage Style: java -jar <jar_file_path> <input_file_path>");
			}
		} catch (ParkingLotException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException e) {
			}
		}
	}

	private static void printCommands() {
		StringBuffer buffer = new StringBuffer();
		buffer = buffer.append(" Please Enter one of the below commands. {variable} has to be entered as input ")
				.append("\n");
		buffer = buffer.append("A) For creating parking lot of size n               ---> create_parking_lot {capacity}")
				.append("\n");
		buffer = buffer
				.append("B) To park a car                                    ---> park <<car_number>> {car_colour}")
				.append("\n");
		buffer = buffer.append("C) Remove(Unpark) car from parking                  ---> leave {slot_number}")
				.append("\n");
		buffer = buffer.append("D) Print status of parking slot                     ---> status").append("\n");
		buffer = buffer.append(
				"E) Get cars registration no for the given car colour ---> registration_numbers_for_cars_with_colour {car_colour}")
				.append("\n");
		buffer = buffer.append(
				"F) Get slot numbers for the given car colour         ---> slot_numbers_for_cars_with_colour {car_colour}")
				.append("\n");
		buffer = buffer.append(
				"G) Get slot number for the given car number         ---> slot_number_for_registration_number {car_number}")
				.append("\n");
		System.out.println(buffer.toString());
	}
}
