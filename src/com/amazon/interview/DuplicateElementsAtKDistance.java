package com.amazon.interview;

import java.util.HashSet;

public class DuplicateElementsAtKDistance {

	public static void main(String[] args) {

		int[] array = { 1, 2, 3, 4, 4 };
		int k = 4;

		boolean b = seachElement(array, k);
		System.out.println(b);
	}

	private static boolean seachElement(int[] array, int k) {
		HashSet<Integer> l1 = new HashSet<Integer>();

		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (l1.add(array[i]) == false) {

				index = i;
			}

		}
		if (index == k)
			return true;
		else
			return false;

	}

}
