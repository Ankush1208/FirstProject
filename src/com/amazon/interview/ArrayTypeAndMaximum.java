package com.amazon.interview;

import java.util.Arrays;
import java.util.OptionalInt;

public class ArrayTypeAndMaximum {

	public static void main(String[] args) {

		// int[] array={1,2,3,4,5};
		// int[] array={5,4,3,2,1};
		int[] array = { 2, 1, 7, 5, 4, 3 };
		OptionalInt max1 = null;
		int flag2 = 0, flag3 = 0, i = 0, j = array.length - 1;
		while (i < array.length - 1 && array[i] <= array[i + 1])
			i++;
		if (i == array.length - 1) {
			System.out.println("Ascending with maximum element = " + array[array.length - 1]);
			return;
		}

		if (i == 0) {
			while (i < array.length - 1 && array[i] >= array[i + 1])
				i++;

			if (i == array.length - 1) {
				System.out.println("Descending with maximum " + "element =  " + array[0]);
				return;
			}
		}
		int mid = (array.length - 1) / 2;
		i = 0;
		while (i < mid && j > mid) {
			if (array[i] < array[j]) {

				max1 = Arrays.stream(array).max();
				flag2 = 1;
				i++;
				j--;

			} else if (array[i] > array[j]) {

				max1 = Arrays.stream(array).max();
				flag3 = 1;
				i++;
				j--;

			}
		}

		if (flag2 == 1)
			System.out.println("Descending rotated: " + max1.getAsInt());

		if (flag3 == 1)
			System.out.println("Ascending rotated: " + max1.getAsInt());

	}

}
