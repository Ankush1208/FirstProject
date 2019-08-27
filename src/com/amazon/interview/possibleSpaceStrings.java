package com.amazon.interview;

public class possibleSpaceStrings {

	private static void patternPrint(String s, int i) {
		if (i < s.length()) {
			patternPrint(s, i + 1);
			patternPrint(s.substring(0, i) + " " + s.substring(i), i + 2);
		} else
			System.out.println(s);
	}

	public static void main(String[] args) {
		String str = "ABCDE";
		patternPrint(str, 1);

	}
}
