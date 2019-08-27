package com.amazon.interview;

import java.util.Arrays;

public class PssibleTraingles {

	public static void main(String[] args) {

		// int[] array={10, 21, 22, 100, 101, 200, 300};
		int[] array = { 3, 4, 6, 7 };
		int count = 0;
		int b = 0;
		Arrays.sort(array);
		for (int i = 0; i < array.length - 2; i++) {
			b = i + 2;

			for (int j = i + 1; j < array.length; j++) {

				while (b < array.length && array[i] + array[j] > array[b]) {
					++b;
				}
				count += b - j - 1;

			}
		}

		System.out.println(count);

	}

}
