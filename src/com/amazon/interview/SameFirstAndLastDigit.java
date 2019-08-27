package com.amazon.interview;

public class SameFirstAndLastDigit {

	public static void main(String[] args) {
		int start = 7;
		int end = 68;
		int c = CountDigit(start, end);
		System.out.println(c);

	}

	private static int CountDigit(int start, int end) {
		int c = 0, lastDigit = 0, firstDigit = 0;
		if (start < 10) {
			while (start < 10) {

				start++;
				c++;
			}

		}

		else
			while (start <= end) {
				lastDigit = 0;
				firstDigit = 0;
				lastDigit = start % 10;
				while (start != 0) {
					start = start / 10;
					firstDigit = start;
				}
				if (lastDigit == firstDigit)
					c++;
				start++;
			}
		return c;

	}

}
