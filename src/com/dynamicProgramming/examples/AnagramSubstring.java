package com.dynamicProgramming.examples;

public class AnagramSubstring {

	public static void main(String[] args) {

		String str = "abcdbcadccbn";
		String pattern = "abcd";
		findPermutation(str, pattern);
	}

	private static void findPermutation(String str, String pattern) {

		int m = pattern.length();
		int n = str.length();
		int countPatt[] = new int[2560];
		int countText[] = new int[2560];
		for (int i = 0; i < m; i++) {
			countPatt[pattern.charAt(i) - 'a']++;
			countText[str.charAt(i) - 'a']++;
		}

		for (int i = m; i < n; i++) {
			if (compare(countPatt, countText))
				System.out.println("fount at :" + (i - m));

			countText[str.charAt(i) - 'a']++;
			countText[str.charAt(i - m) - 'a']--;
		}
		if (compare(countPatt, countText))
			System.out.println("found at : " + (n - m));

	}

	private static boolean compare(int[] countPatt, int[] countText) {

		for (int i = 0; i < 256; i++)

			if (countPatt[i] != countText[i])
				return false;
		return true;

	}

}
