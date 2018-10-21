package com.amazon.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class RunLengthEncoding {

	private static LinkedHashMap<Character, Integer> h1 = null;

	public static void main(String[] args) {

		String str = "wwwwaaadexxxxxx";
		char[] c1 = str.toCharArray();

		h1 = new LinkedHashMap<Character, Integer>();

		for (Character c2 : c1) {
			if (h1.containsKey(c2)) {
				h1.put(c2, h1.get(c2) + 1);
			} else
				h1.put(c2, 1);
		}

		for (Map.Entry<Character, Integer> e1 : h1.entrySet()) {
			System.out.print(e1.getKey() + "" + e1.getValue());
		} // System.out.println(str1);

	}

}
