package com.amazon.interview;

import java.util.Scanner;

public class SetBits {

	private static Scanner sin;

	public static void main(String... a) {
		sin = new Scanner(System.in);
		int c = 0;
		int n = sin.nextInt();
		for (int i = 1; i <= n; i++) {
			c += binnaryCount(i);
			// System.out.println("count of :" +i + " element is:" +c);

		}
		System.out.println("The final count is:" + c);
	}

	private static int binnaryCount(int i) {

		int count = 0, temp = 0;

		while (i != 0) {
			temp = i % 2;
			i = i / 2;
			if (temp == 1)
				count++;
		}
		return count;

		// TODO Auto-generated method stub

	}

}
