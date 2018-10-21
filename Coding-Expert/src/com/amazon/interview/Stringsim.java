package com.amazon.interview;

public class Stringsim {

	public static int calculate(String s) {
		char[] arr = s.toCharArray();
		int length = arr.length;
		int count = length;
		for (int i = 1; i < length; i++) {
			int len = length - i;
			int j = 0;
			for (j = 0; j < len; j++)
				if (arr[j] != arr[j + i]) {
					break;
				}
			count += j;
		}
		return count;
	}

	public static void main(String[] args) {

		String s = "aaaa";
		System.out.println(calculate(s));
	}

}
