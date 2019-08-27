package com.amazon.interview;

public class Arraywith0and1 {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 1, 1, 1, 0, 0, 1 };

		int x = 0, y = 0, x1 = 0, y1 = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				x++;
			else
				y++;
		}
		int[] zeros = new int[x];
		int[] ones = new int[y];

		for (int i : arr) {
			if (i == 0) {
				zeros[x1] = i;
				x1++;
			} else if (i == 1) {
				ones[y1] = i;
				y1++;
			}
		}

		for (int i : ones) {

			System.out.print(i);
		}
		System.out.println("zeros");
		for (int j : zeros)
			System.out.print(j);
	}

}
