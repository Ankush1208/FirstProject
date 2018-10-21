package com.dynamicProgramming.examples;

public class MaximumDifference {

	public static void main(String[] args) {

		int[] arr = { 100, 2, 3, 4, 5, 10, 200 };
		int curr_sum = arr[1] - arr[0];
		int max = curr_sum;
		for (int i = 1; i < arr.length - 1; i++) {
			if (curr_sum > 0)
				curr_sum += arr[i + 1] - arr[i];
			else
				curr_sum = arr[i + 1] - arr[i];
			max = Math.max(curr_sum, max);
		}
		System.out.println(max);
	}

}
