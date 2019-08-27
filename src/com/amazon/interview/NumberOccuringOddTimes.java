package com.amazon.interview;

import java.util.HashMap;
import java.util.Map;

public class NumberOccuringOddTimes {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 3, 1, 3 };
		HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();
		for (int i : array) {

			if (h1.containsKey(i)) {
				h1.put(i, h1.get(i) + 1);

			} else
				h1.put(i, 1);

		}
		for (Map.Entry<Integer, Integer> entry : h1.entrySet()) {
			if (entry.getValue() % 2 != 0) {
				System.out.println(entry.getKey());
			}
		}
	}

}
