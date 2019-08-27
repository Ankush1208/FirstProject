package com.amazon.interview;

public class KMPSelf {

	public static void main(String[] args) {

		String text = "AAAAABAAABA";
		String pattern = "AAAA";
		findPatternIndex(text, pattern);
	}

	private static void findPatternIndex(String text, String pattern) {

		int tl = text.length();
		int pl = pattern.length();
		int j = 0;
		int lps[] = new int[pl];
		computeLps(lps, pl, pattern);
		int i = 0;

		while (i < tl) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			}
			if (j == pl) {
				System.out.println("Pattern found at :" + (i - j));
				j = lps[j - 1];
			} else

			if (i < tl && text.charAt(i) != pattern.charAt(j)) {
				if (j != 0)
					j = 0;
				else
					i = i + 1;
			}

		}
	}

	private static void computeLps(int[] lps, int pl, String pattern) {
		int len = 0;
		lps[0] = 0;
		int i = 1;
		while (i < pl) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i++] = len;

			} else {
				if (len != 0)
					len = 0;
				else
					lps[i++] = len;

			}

		}
	}

}
