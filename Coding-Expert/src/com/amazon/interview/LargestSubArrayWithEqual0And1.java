package com.amazon.interview;

import java.util.HashMap;

public class LargestSubArrayWithEqual0And1 {

	public static void main(String[] args) {

		int[] arr1 = { 1, 1, 0, 1, 1, 0, 0 };

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int sum = 0;
		int maxLength = 0;
		int from = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == 0)
				arr1[i] = -1;
		}

		for (int i = 0; i < arr1.length; i++) {

			sum = sum + arr1[i];
			Integer pSumIndex = hashMap.get(sum);
			if (pSumIndex != null) {

				int localLength = i - pSumIndex;
				if (maxLength < localLength) {
					from = pSumIndex;
					maxLength = localLength;
				}
			} else {
				hashMap.put(sum, i);
			}
		}
		if (maxLength != 0)
			System.out.println("largest SubArray is from " + from + " to " + (maxLength));
		else
			System.out.println("No SUbArray");
	}

}
