package com.amazon.interview;

public class MedianOfTwoArrays {

	public static void main(String[] args) {

		int[] arr = { 1, 12, 15, 26, 38 };
		int[] arr2 = { 2, 13, 17, 30, 45 };

		int median = findmedian(arr, 0, arr.length - 1, arr2, 0, arr.length - 1);
		System.out.println(median);
	}

	public static int findmedian(int[] arr1, int l1, int h1, int[] arr2, int l2, int h2) {
		int mid1 = (h1 + l1) / 2;
		int mid2 = (h2 + l2) / 2;

		if (h1 - l1 == 1)
			return (Math.max(arr1[l1], arr2[l2]) + Math.min(arr1[h1], arr2[h2])) / 2;
		else if (arr1[mid1] > arr2[mid2])
			return findmedian(arr1, l1, mid1, arr2, mid2, h2);
		else
			return findmedian(arr1, mid1, h1, arr2, l2, mid2);
	}

}
