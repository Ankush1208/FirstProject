package com.amazon.interview;

public class Secondlargest {

	public static void main(String[] args) {

		int[] arr = { 3, 2, 6, 5, 6 };
		// int[] arr={2,2,2,2,2,2,2,2};

		int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (first < arr[i]) {
				second = first;
				first = arr[i];
			} else if (second < arr[i] && arr[i] != first)
				second = arr[i];

		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == first)
				count++;
			if (count > 1)
				second = first;
		}

		System.out.println(first + " " + second);
	}

}
