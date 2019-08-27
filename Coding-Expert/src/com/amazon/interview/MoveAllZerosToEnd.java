package com.amazon.interview;

public class MoveAllZerosToEnd {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 0, 4, 3, 0, 5, 0 };
		int count = 0;
		for (int i : arr) {
			if (i != 0) {
				arr[count] = i;
				count++;
			}
		}
		while (count < arr.length) {
			arr[count] = 0;

			count++;
		}
		for (int i : arr)
			System.out.print(i + " ");
	}

}
