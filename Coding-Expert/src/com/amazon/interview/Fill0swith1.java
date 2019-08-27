package com.amazon.interview;

public class Fill0swith1 {
	private static int iteration = 0;

	static void countZeros(int array[])

	{

		boolean isZeroFound = true;
		while (isZeroFound) {
			isZeroFound = false;
			boolean pIgnore = false;
			for (int i = 0; i < array.length; i++) {
				int previous = i - 1;
				int next = i + 1;

				if (array[i] == 0) {
					isZeroFound = true;
					if (previous >= 0 && array[previous] == 1 && pIgnore == false) {
						array[i] = 1;
						pIgnore = true;
					} else if (next <= array.length && array[next] == 1) {
						array[i] = 1;
					} else {
						pIgnore = false;
					}
				} else {
					pIgnore = false;
				}
			}
			if (isZeroFound)
				iteration++;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1 };
		countZeros(arr);
		System.out.println(iteration);

	}
}