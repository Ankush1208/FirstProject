package com.amazon.interview;

public class SortedSubSequence {

	public static void main(String[] args) {
		int[] arr = { 12, 11, 10, 5, 6, 2, 30 };
		// int[] arr={7,6,4,5,1,2,3};
		int k1 = Integer.MAX_VALUE, k2 = Integer.MAX_VALUE;
		int res1 = -1;
		int res2 = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < k1) {
				k1 = arr[i];
			} else if (arr[i] < k2) {
				k2 = arr[i];
				res1 = k1;
				res2 = k2;

			} else {
				System.out.println(res1 + " " + res2 + " " + arr[i]);
				break;
			}
		}

	}

}
