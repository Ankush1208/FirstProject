package com.amazon.interview;

import java.util.HashMap;

public class LargestSubArrayWith0Sum {

	public static void main(String[] args) {
		int[] array = { 1, -1, 1, -1 };
		// int[] array={1,2,3};
		// int[] array={1,0,3};
		// int[] array={15, -2, 2, -8, 1, 7, 10, 23};
		int result = maxLength(array);
		System.out.println(result);
	}

	public static int maxLength(int A[]) {
		int n = A.length;

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int sum = 0;
		int maxLength = 0;
		hashMap.put(0, -1); // initialization
		for (int i = 0; i < n; i++) {
			sum = sum + A[i];
			Integer pSumIndex = hashMap.get(sum);
			if (pSumIndex != null) {
				int localLength = i - pSumIndex;
				if (maxLength < localLength) {
					maxLength = localLength;
				}
			} else {
				hashMap.put(sum, i);
			}
		}
		return maxLength;
	}
}
