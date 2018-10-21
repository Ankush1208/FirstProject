package com.amazon.interview;

import java.util.HashMap;

public class DictionaryMatchPattern {

	static String enCode(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		String result = "";
		int k = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!hm.containsKey(s.charAt(i)))
				hm.put(s.charAt(i), k++);
			result += hm.get(s.charAt(i));
		}
		return result;
	}

	public static void main(String args[]) {
		String dic[] = { "abab", "aba", "xyw", "ghi" };
		String pattern = "abc";
		String s = enCode(pattern);
		for (String i : dic) {
			if (enCode(i).equals(s))
				System.out.println(i);
		}
	}

}
