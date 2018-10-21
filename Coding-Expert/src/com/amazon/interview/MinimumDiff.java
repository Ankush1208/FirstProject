package com.amazon.interview;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumDiff {

	private static Scanner sin;

	public static void main(String[] args) {

		sin = new Scanner(System.in);
		System.out.println("Enter the size");
		int size = sin.nextInt();
		int n[] = new int[size];
		System.out.println("Enter the array");
		for (int i = 0; i < size; i++) {
			n[i] = sin.nextInt();

		}
		Arrays.sort(n);
		int diff = Integer.MAX_VALUE;

		for (int i = 0; i < size - 1; i++) {
			if (n[i + 1] - n[i] < diff)
				diff = n[i + 1] - n[i];
		}
		System.out.println(diff);

	}

}
