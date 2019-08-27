package com.amazon.interview;

public class StringRotation {

	public static void stringRotation(String str1, String str2) {
		String result = null, result2 = null;
		if (str1.length() != str2.length())
			System.out.println("invalid data");
		else
			result = str1.substring(2, str1.length()) + str1.substring(0, 2);
		result2 = str1.substring(str1.length() - 2, str1.length()) + str1.substring(0, str1.length() - 2);
		if (str2.equals(result) || str2.equals(result2)) {
			System.out.println("true");
		} else
			System.out.println("string can not be obtained");
	}

	public static void main(String[] args) {

		String str1 = "geeks";
		String str2 = "eksge";
		stringRotation(str1, str2);

	}

}
