package com.dynamicProgramming.examples;

import java.util.*;

public class LargestArrayWith0Sum {

	private static HashMap<Integer, Integer> m1 = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		int arr[] = { 1, 1, 1, 1 };
		int l = arr.length;
		findLargestArray(arr, l);
	}

	private static void findLargestArray(int[] arr, int l) {

		int max_len = 0;
		int sum = 0;

		m1.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];

			/*
			 * if(sum==0) max_len=i+1;
			 */

			Integer index = m1.get(sum);
			if (index != null) {

				if (max_len < i - index) {
					max_len = i - index;
				}
			} else
				m1.put(sum, i);

		}
		System.out.println(max_len);

	}

}
