package com.adobe;

import java.math.BigInteger;
import java.util.Scanner;

public class CountOdd0andOdd1 {
	

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		BigInteger n = sin.nextBigInteger(); // int n=430510914326;
		String s1 = n.toString(2);
		System.out.println(s1);
		//System.out.println("res = "+ res);
		findSubstring(s1);
	}

	private static void findSubstring(String n) {
		int countOdd1 = 0;
		int countOdd0 = 0;
		StringBuilder s1 = new StringBuilder();
		String s2 = null;
		for (int i = 0; i < n.length(); i++) {
			for (int j = i + 1; j <= n.length(); j++) {
				s1 = new StringBuilder();
				// System.out.println(n.substring(i,j));
				countOdd1 += findSetBits(new BigInteger(n.substring(i, j), 2));
				if (n.charAt(i) == '0')
					s2 = s1.append(n.substring(i, j)).append('1').reverse().toString();
				else
					s2 = n.substring(i, j);
				countOdd0 += findUnsetBits(new BigInteger(s2, 2));
			}
		}

		System.out.println(countOdd0 + " " + countOdd1);
	}

	private static int findSetBits(BigInteger num) {
		int count = 0;

		if (num.bitCount() % 2 != 0)
			return 1;
		return 0;
	}

	private static int findUnsetBits(BigInteger n) {
		BigInteger x = n;

		n = n.or(n.shiftRight(1));
		n = n.or(n.shiftRight(2));
		n = n.or(n.shiftRight(4));
		n = n.or(n.shiftRight(8));
		n = n.or(n.shiftRight(16));

		BigInteger l = x.xor(n);
		if (l.bitCount() % 2 != 0)
			return 1;

		return 0;

	}

}
