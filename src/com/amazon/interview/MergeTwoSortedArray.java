package com.amazon.interview;

public class MergeTwoSortedArray {

	public static void main(String[] args) {

		int[] arr1 = { 9, 8, 0, 1, 10 };
		int[] arr2 = { 2, 4, 3, 11 };
		int m = arr1.length;
		int n = arr2.length;
		int i = 0, j = 0, k = 0;
		int[] arr3 = new int[m + n];
		while (i < m && j < n) {
			if (arr1[i] < arr2[j])
				arr3[k++] = arr1[i++];
			else
				arr3[k++] = arr2[j++];
		}
		while (i < m)
			arr3[k++] = arr1[i++];
		while (j < n)
			arr3[k++] = arr2[j++];

		for (int x = 0; x < n + m; x++) {
			System.out.print(arr3[x] + " ");
		}
	}

}
