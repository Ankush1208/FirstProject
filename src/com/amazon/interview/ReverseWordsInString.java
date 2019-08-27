package com.amazon.interview;

public class ReverseWordsInString {

	public static void main(String... a)

	{

		String s1 = "getting good at coding needs a lot of practice";

		String s3 = "";

		String[] s2 = s1.split(" ");

		for (int i = s2.length - 1; i >= 0; i--)

			s3 = s3 + s2[i] + " ";

		System.out.println(s3.trim());

	}

}
