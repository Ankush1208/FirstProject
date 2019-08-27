package com.amazon.interview;

public class RemoveCharForAnagram {

	public static void main(String[] args) {

		String s1 = "cde";
		char[] str1 = s1.toCharArray();
		String s2 = "abc";
		char[] str2 = s2.toCharArray();
		int[] count1 = new int[26], count2 = new int[26];

		for (int i = 0; i < s1.length(); i++)
			count1[str1[i] - 'a']++;

		for (int i = 0; i < s2.length(); i++)
			count2[str2[i] - 'a']++;

		int result = 0;
		for (int i = 0; i < 26; i++)
			result += Math.abs(count1[i] - count2[i]);

		System.out.println(result);
	}
}