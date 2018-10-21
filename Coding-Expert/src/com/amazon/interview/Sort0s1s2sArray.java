package com.amazon.interview;

public class Sort0s1s2sArray {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 0, 1, 2, 1, 2, 2, 0, 1, 1, 0, 2, 0, 0, 0, 1 };
		int count[] = { 0, 0, 0 };
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;

		}

		int k = 0;
		for (int j = 0; j < arr.length; j++) {
			if (count[k] == 0) {
				k++;
				j--;
			} else {
				arr[j] = k;
				--count[k];

			}
		}
		for (int i : arr)
			System.out.print(i + " ");

	}

}
