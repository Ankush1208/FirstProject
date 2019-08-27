package com.amazon.interview;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] array = { 1, 20, 3, 10, 11, 5 };
		int sum = 33;
		int add = 0, j = 0, i = 0;
		for (i = 0; i < array.length; i++) {
			add += array[i];
			if (sum == add) {
				break;
			}
			if (add > sum) {
				while (add > sum) {
					add = add - array[j];
					j++;
				}
				if (add == sum)
					break;
			}
		}
		System.out.println("The Subarray is between: " + j + " " + i);

	}

}
