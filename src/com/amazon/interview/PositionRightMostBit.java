package com.amazon.interview;

import java.util.Scanner;

public class PositionRightMostBit {

	private static Scanner sin;

	public static void main(String[] args) {

		sin = new Scanner(System.in);

		int n = sin.nextInt();

		int count = 0, temp = 0;
		while (n != 0) {
			temp = n % 2;
			count++;
			n = n / 2;
			if (temp == 1) {
				System.out.println("position of 1 is :" + count);
				break;

			}
		}
		// System.out.println("position of 1 is :" +count);
	}

}
