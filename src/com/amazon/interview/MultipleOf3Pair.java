package com.amazon.interview;

public class MultipleOf3Pair {

	static int count = 0;

	public static void main(String[] args) {

		int[] arr = { 3, 6, 7, 2, 9 };

		int c1 = findPair(arr, arr.length, 1);

		System.out.println(c1);
	}

	private static int findPair(int[] arr, int l, int c) {
		int a[] = new int[3];
		a[0] = arr[0];

		while (l != 1) {
			for (int i = c; i <= arr.length - 1; i++) {
				a[1] = arr[i];
				if ((a[0] + a[1]) % 3 == 0) {

					count++;
				}
			}
			l--;
			c++;
			a[0] = arr[c - 1];
		}
		return count;
	}

}
