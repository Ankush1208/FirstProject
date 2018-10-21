package com.collections.examples;

public class ReverseWords {
	
	String s1="I LOVE CODING";
	String s3;
	
	
String[] s2=s1.split(" ");

private void findReverseStrings()
{
	
	for(int i=s2.length-1;i>=0;i--)
	{
		if(s3==null)
		{
			s3=s2[i] + " ";
		}
		else
			
		s3= s3 +s2[i] + " ";
	//	System.out.println(s3);
	}	
	System.out.println(s3);
	
}

public static void main(String...a)
{
	ReverseWords r1=new ReverseWords();
	r1.findReverseStrings();
	//System.out.println(r1.s3);
}
}
