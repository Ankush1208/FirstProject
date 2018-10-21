package com.amazon.interview;

public class ProductArrayPuzzle {

	public static void main(String[] args) {

		int[] array = { 10, 3, 5, 6, 2 };
		int[] prod = new int[array.length];
		int product = 1;
		for (int i = 0; i < array.length; i++) {
			product *= array[i];
		}
		for (int i = 0; i < array.length; i++) {
			prod[i] = product / array[i];
			System.out.println(prod[i]);
		}

		// prodArray(array,prod,i);

	}

}
