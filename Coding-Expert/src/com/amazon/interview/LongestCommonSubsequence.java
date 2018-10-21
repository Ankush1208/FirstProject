package com.amazon.interview;

public class LongestCommonSubsequence {

	private static int longestSequence(char[] s1, char[] s2) {
		if (s1 == null || s2 == null)
			return -1;

		return 0;
	}

	public static void main(String[] args) {

		String text1 = "geeksforgeeks";
		String text2 = "ksforngf";
		char s1[] = text1.toCharArray();
		char s2[] = text2.toCharArray();

		int longest = longestSequence(s1, s2);
		System.out.println(longest);
	}

}
