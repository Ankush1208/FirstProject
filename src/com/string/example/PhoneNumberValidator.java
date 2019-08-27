package com.string.example;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
	
	
	public static void main(String[] args) {
		System.out.println("Phone number validation result: "+validatePhoneNumber("5797595271"));
		
	}

	private static boolean validatePhoneNumber(String phoneNo) {
		//validate phone numbers of format "1234567890"
		
		String regex = "([5-9]\\d{9}|(91)[5-9]\\d{9})";
		return Pattern.compile(regex).matcher(phoneNo).matches();

		
		
	}

}