package com.amazon.interview;

public class TwoPrimeNumbers {

	public static void main(String[] args) {

		int n = 9990, temp = n;
		boolean flag = true;
		while (flag) {
			temp--;

			for (int i = 2; i <= Math.sqrt(temp); i++) {
				if (temp % i != 0) {
					flag = false;
				} else {
					flag = true;
					break;
				}
			}
		}
		if (flag == false)
			System.out.println("First no is: " + (n - temp) + " last no is:" + temp);
	}

}
