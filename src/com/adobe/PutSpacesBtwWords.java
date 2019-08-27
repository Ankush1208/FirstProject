package com.adobe;

public class PutSpacesBtwWords {

	public static void main(String[] args) {

		String s="BruceWayneIsBatman";
		convertString(s,s.length());
	}

	private static void convertString(String s, int length) {

		char[] s1=s.toCharArray();
		for(int i=0;i<s1.length;i++)
		{
			if(s1[i]>='A' && s1[i]<='Z')
			{
				s1[i]=(char) (s1[i]+32);
				System.out.print(" ");
				System.out.print(s1[i]);

			}
			else
				System.out.print(s1[i]);
				
		}
	}

}
