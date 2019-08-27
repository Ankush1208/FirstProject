package com.amazon.interview;

import java.util.*;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {

		String seq = "abcdefgejklmo";

		printPatternWithNoReaptingCharsInString(seq);
	}

	public static void printPatternWithNoReaptingCharsInString(String input) {
		 Map<Character, Integer> visited = new HashMap<>();
		    String output = "";
		    int start=0;
		    for (int  i = 0; i < input.length(); i++) {
		        char currChar = input.charAt(i);
		        if (visited.containsKey(currChar)) {
		            start = Math.max(visited.get(currChar)+1, start);
		        }
		        if (output.length() < i- start + 1) {
		            output = input.substring(start, i + 1);
		        }
		        visited.put(currChar, i);
		    }
		    System.out.println(output);
	}
}
