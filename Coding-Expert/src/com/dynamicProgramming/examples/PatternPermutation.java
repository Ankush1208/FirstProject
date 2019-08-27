package com.dynamicProgramming.examples;

import java.io.Serializable;

public class PatternPermutation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public static void main(String[] args) {

		String s = "abacabacbbcc";
		String pat = "abc";
		char[] count = new char[3];
		for (int i = 0; i < pat.length(); i++)
			count[pat.charAt(i)]++;
		for (int i = 0; i < s.length(); i++) {

		}
	}

}
