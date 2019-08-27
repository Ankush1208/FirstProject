package com.amazon.interview;

public class MissingNumber {

	public static void main(String[] args) {

		int list[] = { 1, 2, 4, 6, 3, 7, 8 };
		int n = list.length + 1, sum = 0;
		int formula = (n * (n + 1)) / 2;
		for (int i : list) {
			sum += i;
		}
		System.out.println(formula - sum);

	}

}
