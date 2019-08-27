package com.amazon.interview;

public class MaximumSumIncreasing {

	public static void main(String[] args) {
		int array[] = { 1, 101, 2, 3, 100, 4, 5 };
		maximumSumIncreasing(array, array.length);

	}

	private static void maximumSumIncreasing(int[] array, int length) {

		int[] longest = new int[length];
		int max = 0;
		longest[0]=1;
		for (int i = 1; i < length; i++) {
			longest[i] = array[i];

			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && longest[i] < longest[j] + array[i]) {
					longest[i] = array[i] + longest[j];
				}
			}
		}
		for (int i = 0; i < length; i++) {
			if (max < longest[i])
				max = longest[i];
			// System.out.println(max);
		}
		System.out.println(max);

	}

}
