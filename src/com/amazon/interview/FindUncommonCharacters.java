package com.amazon.interview;

public class FindUncommonCharacters {

	private static int count[]=new int[256];
	public static void main(String[] args) {

		String s1="characters";
			String 	s2 = "alphabets";
			findunCommon(s1,s2);
	}

	private static void findunCommon(String s1, String s2) {

		for(int i=0;i<s1.length();i++)
			count[s1.charAt(i)]++;
		for(int i=0;i<s2.length();i++)
		{
			if(count[s2.charAt(i)]==0)
			 count[s2.charAt(i)]++;
			else
				count[s2.charAt(i)]--;
			 
		}
		for(int i=0;i<256;i++)
		{
			if(count[i]>=1)
			{
				System.out.print((char)i + " ");
			}
		}
	}

}
