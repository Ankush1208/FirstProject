package com.amazon.interview;

public class NumberPowerRaised {

	public static void main(String[] args) {

		int n = 256, temp = 0, flag = 0;

		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				temp = i;
				break;
			}
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (Math.pow(temp, i) == n) {
				flag = 1;
				System.out.println("yes");
				break;
			}
		}
		if (flag == 0) {
			System.out.println("no");
		}

	}

}
