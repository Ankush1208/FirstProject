package com.dynamicProgramming.examples;

public class LargestSubArray {

	public static void main(String[] args) {

		// int[] arr= {-2,-3,4,-1,-2,1,5,-3};
		int[] arr = { -1, 2, -3, -4, -5, -10, 0, 1 };
		int l = arr.length;
		findLargestSub(arr, l);

	}

	private static void findLargestSub(int[] arr, int l) {

		/*
		 * int max_so_far = 0, max_ending_here = 0; for (int i = 0; i < l; i++) {
		 * max_ending_here = max_ending_here + arr[i]; if (max_ending_here < 0)
		 * max_ending_here = 0;
		 * 
		 * Do not compare for all elements. Compare only when max_ending_here > 0 else
		 * if (max_so_far < max_ending_here) max_so_far = max_ending_here; }
		 * 
		 * System.out.println(max_so_far);
		 */

		/****** better approach to handle negative values ***/

		int cur_max = arr[0];
		int max_so_far = arr[0];
		for (int i = 1; i < arr.length; i++) {
			cur_max = Math.max(cur_max + arr[i], arr[i]);
			max_so_far = Math.max(cur_max, max_so_far);

		}

		System.out.println(max_so_far);

	}

}
