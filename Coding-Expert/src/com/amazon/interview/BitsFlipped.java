package com.amazon.interview;

import java.util.Scanner;

public class BitsFlipped {

	private static Scanner sin;

	public static void main(String[] args) {

		sin = new Scanner(System.in);

		System.out.println("Enter the first number");
		int a = sin.nextInt();
		System.out.println("Enter the second number");
		int b = sin.nextInt();

		int c = a ^ b;
		int count = 0, temp = 0;

		while (c != 0) {
			temp = c % 2;
			c = c / 2;
			if (temp == 1)
				count++;
		}
		System.out.println(count);

	}

}
