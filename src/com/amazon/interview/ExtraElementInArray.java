package com.amazon.interview;

import java.util.*;

public class ExtraElementInArray {

	public static void main(String[] args) {
		int[] array1 = { 2, 4, 6, 8, 9, 10, 12 };
		int[] array2 = { 2, 4, 6, 8, 10, 12 };
		int index = 0;
		Set<Integer> s1 = new HashSet<Integer>();

		for (int i : array2) {
			s1.add(i);
		}

		for (int i = 0; i < array1.length; i++) {
			if (s1.add(array1[i])) {
				index = i;
			}
		}
		System.out.println(index);
	}

}
