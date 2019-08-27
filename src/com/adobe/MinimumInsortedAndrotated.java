package com.adobe;

public class MinimumInsortedAndrotated {

	public static void main(String[] args) {

		int arr[] = { 5, 6, 7, 1, 2, 3 };
		int[] arr2 = { 2, 3, 5, 6, 7, 1 };
		int high = arr.length - 1;
		int low = 0;

		int min = findMin(arr, low, high);
		System.out.println(min);
	}

	private static int findMin(int[] arr, int low, int high) {

		if (high == low)
			return arr[low];
		if (high < low)
			return arr[0];
		int mid = low + (high - low) / 2;
		if (arr[mid] > arr[mid + 1])
			return arr[mid + 1];
		if (arr[mid] < arr[mid - 1])
			return arr[mid];
		if (arr[high] > arr[mid])
			return findMin(arr, low, mid - 1);
		return findMin(arr, mid + 1, high);

	}

}
