package com.amazon.interview;

import java.util.HashSet;

public class PairsWhoseSumIsX {

	public static void main(String[] args) {

		int[] arr1 = { -1, -2, 4, -6, 5, 7 };
		int[] arr2 = { 6, 3, 4, 0 };
		int x = 8;
		HashSet<Integer> h = new HashSet<Integer>();

		for (int i = 0; i < arr1.length; i++)
			h.add(arr1[i]);

		for (int i = 0; i < arr2.length; i++) {

			if (h.contains(x - arr2[i])) {

				System.out.println(arr2[i] + " " + (x - arr2[i]));

			}
		}
	}

}
