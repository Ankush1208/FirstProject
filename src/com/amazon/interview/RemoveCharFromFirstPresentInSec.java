package com.amazon.interview;

public class RemoveCharFromFirstPresentInSec {

	public static void main(String[] args) {

		String s1="geeksforgeeks";
		String s2="mask";
		removeChar(s1,s2);
	}

	private static void removeChar(String s1, String s2) {

		int[] count=new int[256];
		String res="";
		
		for(int i=0;i<s2.length();i++)
			count[s2.charAt(i)]++;
		  for(int i=0;i<s1.length();i++)
		  {
			  if(count[s1.charAt(i)]==0)
			  {
				  res+=s1.charAt(i);
			  }
		  }
		  System.out.println(res.trim());
	}

}
