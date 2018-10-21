package com.dynamicProgramming.examples;

public class MaxSumIncSubsequence {

	public static void main(String[] args) {

		int[] arr = { 1, 101, 2, 3, 100, 4, 5 };
		findMaxSumInc(arr, arr.length);
	}

	private static void findMaxSumInc(int[] arr, int length) {

		int maxSum = 0;
		int currSum = 0;

		for (int i = 0; i < length - 1; i++) {
			if (arr[i] < arr[i + 1] && currSum < arr[i + 1])
				currSum += arr[i];
			if (maxSum < currSum)
				maxSum = currSum;
		}

	}

}
