package com.amazon.interview;

public class CoverDistanceIn123Steps {

	public static void main(String[] args) {
		int n = 3;
		int count = countSteps(n);
		System.out.println(count);
	}

	private static int countSteps(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		else
			return countSteps(n - 1) + countSteps(n - 2) + countSteps(n - 3);
	}

}
