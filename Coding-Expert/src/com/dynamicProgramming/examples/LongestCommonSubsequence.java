package com.dynamicProgramming.examples;

public class LongestCommonSubsequence {

	private static int longestSequence(char[] s1, char[] s2, int m, int n) {

		int lci[][] = new int[m + 1][n + 1];
		if (s1 == null || s2 == null)
			return -1;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					lci[i][j] = 0;
				else if (s1[i - 1] == s2[j - 1])
					lci[i][j] = 1 + lci[i - 1][j - 1];
				else
					lci[i][j] = Math.max(lci[i - 1][j], lci[i][j - 1]);
			}
		}
		return lci[m][n];

	}

	public static void main(String[] args) {

		String text1 = "geeksforgeeks";
		String text2 = "ksforngf";
		char s1[] = text1.toCharArray();
		char s2[] = text2.toCharArray();
		int m = text1.length();
		int n = text2.length();
		int longest = longestSequence(s1, s2, m, n);
		System.out.println(longest);
	}

}
