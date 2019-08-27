package com.amazon.interview;

import java.util.HashMap;
import java.util.Map;

public class ElementAppearsOnce {

	public static void main(String[] args) {
		System.out.println(5.0 % 2);
		int[] n = new int[] { 1, 2, 3, 4, 2, 2, 4, 4, 3, 4, 5 };
		HashMap<Integer, Integer> h1 = new HashMap<Integer, Integer>();

		for (Integer n1 : n) {
			if (h1.containsKey(n1)) {
				h1.put(n1, h1.get(n1) + 1);

			} else
				h1.put(n1, 1);
		}
		for (Map.Entry<Integer, Integer> e1 : h1.entrySet()) {
			if (e1.getValue() == 1) {
				System.out.println(e1.getKey());
			}
		}
	}
}
