package com.dynamicProgramming.examples;

public class UglyNumber {

	public static void main(String[] args) {

		int n = 7;
		int n1 = findUglyNumber(n);

		System.out.println(n1);
	}

	private static int findUglyNumber(int n) {

		int count = 1;
		if (n == 0)
			return -1;
		if (n == 1)
			return 1;
		for (int i = 2; i <= n; i++) {

			if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0)
				count++;
		}
		return count;
	}

}
