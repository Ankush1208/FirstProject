package com.amazon.interview;

public class SquareRoot {

	public static void main(String[] args) {

		int n = 1225;
		int start = 0;
		int end = n;
		int res = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (mid * mid == n) {
				res = mid;
				break;
			} else if (mid * mid < n) {
				start = mid + 1;
				res = mid;
			} else
				end = mid - 1;

		}
		System.out.println(res);

	}

}
