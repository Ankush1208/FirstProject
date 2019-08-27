package com.amazon.interview;

//import java.lang.Math;
public class Replace0with5 {

	public static void main(String[] args) {

		int n = 10210;
		String temp = Integer.toString(n);
		temp = temp.replace('0', '5');
		int res = Integer.parseInt(temp);
		System.out.println(res);

		int d = 0;
		int rev = 0;
		while (n != 0) {
			d = n % 10;
			if (d == 0) {
				d = 5;
			}
			rev = (int) ((rev / 10) + d * (Math.pow(10, temp.length() - 1)));
			n = n / 10;
		}
		System.out.println(rev);
	}
}
