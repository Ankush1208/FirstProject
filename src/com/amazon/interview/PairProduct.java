package com.amazon.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class PairProduct {

	private static HashSet<Integer> set;

	public static void main(String[] args) {

		int arr[] = { -10, 20, -9, 40, 30, 1, 0 };
		int x = 90;

		boolean b = pairProd(arr, x);

		System.out.println(b);
	}

	private static boolean pairProd(int[] arr, int x) {
		set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				if (x == 0)
					return true;
				else
					continue;
			}

			if (x % arr[i] == 0) {
				if (set.contains(x / arr[i]))

					return true;

				set.add(arr[i]);
			}
		}
		return false;

	}
}
