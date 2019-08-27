package com.dynamicProgramming.examples;

public class LongestSquenceInArray {

	private static int longestSequence(int[] arr) {
		int length = arr.length;
		int j = 0;
		if (length == 0)
			return 0;
		if (length == 1)
			return arr[0];
		for (int i = 0; i < length; i++) {
			if (arr[i] < arr[i + 1]) {
				j++;
			}
			if (i == j) {
				System.out.println("length of longest sequence is :" + j);

			}
		}

		return 0;
	}

	public static void main(String[] args) {

		int[] arr = { 3, 10, 2, 1, 20 };
		int arr2[] = { 3, 2 };
		int arr3[] = { 50, 3, 10, 7, 40, 80 };

	}

}
