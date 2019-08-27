package com.amazon.interview;

import java.util.HashMap;
import java.util.Map;

public class CheckDuplicatesWithinKDistance {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 4 };
		int k = 4;
		checkDuplicates(arr, k);
	}

	private static void checkDuplicates(int[] arr, int k) {

		int flag = 0;
		Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (m1.containsKey(arr[i])) {
				if (i - m1.get(arr[i]) <= k)
					flag = 1;
				else
					flag = 0;
			}
			m1.put(arr[i], i);
		}
		if (flag == 1)
			System.out.println(true);
		else
			System.out.println(false);
	}

}
