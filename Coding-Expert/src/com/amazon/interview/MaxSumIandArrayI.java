package com.amazon.interview;

public class MaxSumIandArrayI {

	public static void main(String[] args) {
		int[] arr = { 8, 3, 1, 2 };
		int firstSum = 0, res = 0;
		int sum1 = 0, nextval = 0;
		for (int i = 0; i < arr.length; i++) {
			sum1 += arr[i];
			firstSum += arr[i] * i;
		}

		for (int i = 1; i < arr.length; i++) {
			nextval = firstSum - (sum1 - arr[i - 1]) + arr[i - 1] * (arr.length - 1);
			firstSum = nextval;

			res = Math.max(res, nextval);
		}
		System.out.println(res);
	}

}
