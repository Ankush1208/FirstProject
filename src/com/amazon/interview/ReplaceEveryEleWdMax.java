package com.amazon.interview;

public class ReplaceEveryEleWdMax {

	public static void main(String[] args) {

		int[] arr = { 10, 1 };
		int l = 0, r = arr.length - 1;
		NextGreatestElementOnRight(arr, l, r);

	}

	private static void NextGreatestElementOnRight(int[] arr, int l, int r) {

		int max = arr[r];
		arr[r] = -1;

		for (int i = r - 1; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = max;
			if (max < temp) {
				max = temp;
			}
		}
		for (int i : arr) {

			System.out.print(i + " ");
		}

	}

}
