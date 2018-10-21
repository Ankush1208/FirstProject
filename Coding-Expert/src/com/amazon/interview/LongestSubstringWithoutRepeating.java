package com.amazon.interview;

import java.util.*;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {

		String seq = "abcdefgedhjiklomn";

		printPatternWithNoReaptingCharsInString(seq);
	}

	public static void printPatternWithNoReaptingCharsInString(String s) {

		char[] arr = s.toCharArray();

		Map<Character, Integer> charMap = new HashMap<Character, Integer>();

		int size = 0;

		StringBuilder str = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {

			if (!charMap.containsKey(arr[i])) {

				charMap.put(arr[i], i);

			} else {

				if (size <= charMap.size()) {

					size = charMap.size();

					if (str.length() <= size) {

						String sub = s.substring(i - size, i);
						str.delete(0, str.length()).append(sub);

					}

				}

				i = charMap.get(arr[i]);

				charMap.clear();

			}

		}

		if (size != 0)

			System.out.println(""

					+ str.toString() + " with size " + size);

		else

			System.out.println(""

					+ s + " with size " + s.length());

	}
}
