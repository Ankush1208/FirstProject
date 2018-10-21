package com.amazon.interview;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
	public static void main(String[] args) {

		int a[] = { 1, 2, 2, 3, 4, 5 };
		arrayRotation(a, a.length, 3);
		printArrayRotated(a);

	}

	private static void printArrayRotated(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");

	}

	private static void arrayRotation(int[] arr, int n, int d) {

		int k = 0, j = 0, temp = 0;
		for (int i = 0; i < gcd(d, n); i++) {
			temp = arr[i];
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;

			}

			arr[j] = temp;
		}

	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}