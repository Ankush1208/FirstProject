package com.amazon.interview;

import java.util.*;

public class TwoNonRepeatingElement {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 7, 9, 11, 2, 3, 11 };
		Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (m1.containsKey(i))
				m1.put(i, m1.get(i) + 1);
			else
				m1.put(i, 1);

		}
		for (int i : arr) {
			if (m1.get(i) == 1)
				System.out.println(i);
		}

	}

}
