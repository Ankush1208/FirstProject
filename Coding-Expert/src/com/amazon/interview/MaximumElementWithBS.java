package com.amazon.interview;

public class MaximumElementWithBS {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 50, 10, 9, 7, 6 };
		// int[] arr={1,3,4,10,50,7,6};
		// int[] arr = {10, 20, 30, 40, 50};
		int l = 0;
		int r = arr.length - 1;
		int max = maximumElement(arr, l, r);
		System.out.println(max);

	}

	private static int maximumElement(int[] arr, int l, int r) {
		if (r == l)
			return arr[l];
		if (r == l + 1 && arr[l] > arr[r])
			return arr[l];
		if (r == l + 1 && arr[l] < arr[r])
			return arr[r];
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
				return arr[mid];
			else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1])
				return maximumElement(arr, l, mid - 1);
			else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1])
				return maximumElement(arr, mid + 1, r);

		}
		return 0;
	}

}
