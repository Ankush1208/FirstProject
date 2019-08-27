package com.amazon.interview;

public class LongestPallindrome {

	public static void main(String[] args) {

		String seq = "GEEKSFORGEEKS";
		char[] array = seq.toCharArray();
		int l = longestPalindrome(array, 0, array.length - 1);
		System.out.println(l);
	}

	private static int longestPalindrome(char[] seq, int i, int j) {

		if (i > j)
			return 0;
		if (i == j)
			return 1;
		else if (seq[i] == seq[j])

			return longestPalindrome(seq, i + 1, j - 1) + 2;

		return Math.max(longestPalindrome(seq, i + 1, j), longestPalindrome(seq, i, j - 1));
	}

}
