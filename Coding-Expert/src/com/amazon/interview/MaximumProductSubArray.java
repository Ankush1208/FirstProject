package com.amazon.interview;

public class MaximumProductSubArray {

	public static void main(String[] args) {

		int[] arr = { -1, -3, -10, 0, 60 };

		int max = 0, min = 0;
		int res = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			int temp = max;
			max = Math.max(max, Math.max(arr[i] * max, arr[i] * min));
			min = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * min));
			res = Math.max(res, max);

		}
		System.out.println(res);
	}

}
