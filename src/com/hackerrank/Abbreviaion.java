package com.hackerrank;

public class Abbreviaion {

	public static void main(String[] args) {

		String a = "VLKHNlpsrlrvfxftslslrrh";
		String b = "VLKHN";

		checkPresent(a, b);
	}

	private static void checkPresent(String a, String b) {

		int index = 0;
		for (int i = 0; i < a.length(); i++) {
			if (Character.isLowerCase(a.charAt(i)))
				index = b.indexOf(Character.toUpperCase(a.charAt(i)), i);
			else
				index = b.indexOf(a.charAt(i), i);
			if (index != -1 && index < b.length()) {
				a = a.substring(0, i) + Character.toUpperCase(a.charAt(i)) + a.substring(i + 1);
			} else {
				if (Character.isLowerCase(a.charAt(i))) {
					a = a.substring(0, i) + a.substring(i + 1);
					i--;
				} else
					a = a.substring(0, i) + a.charAt(i) + a.substring(i + 1);
			}

		}
		System.out.println(a.equals(b));

	}

}
