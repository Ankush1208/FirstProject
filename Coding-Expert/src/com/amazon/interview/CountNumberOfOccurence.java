package com.amazon.interview;

import java.util.Arrays;

public class CountNumberOfOccurence {

	public static void main(String[] args) {

		int[] arr = { 0, 0, 2, 1, 1, 2, 2, 2, 2, 4, 4, 5 };
		int[] count = new int[arr.length];
		int x = 2;
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		System.out.println(count[7]);
	}

}
