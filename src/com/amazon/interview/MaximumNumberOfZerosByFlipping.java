package com.amazon.interview;

public class MaximumNumberOfZerosByFlipping {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 };
		int max = 0;
		int countOnes = 0;
		int countZeros = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				countZeros++;
				countOnes = 0;

			} else {

				countOnes++;
				if (countOnes > 0 && countOnes > max) {
					max = countOnes;
				}

			}
		}
		System.out.println(countZeros + max);

	}

}
