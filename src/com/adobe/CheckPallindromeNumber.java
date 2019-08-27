package com.adobe;

public class CheckPallindromeNumber {

	public static void main(String[] args) {

		int i=2002;
		checkPallindrome(i);
	}

	private static void checkPallindrome(int i) {
		
		int temp=i,res=0;
		
		while(i>0)
		{
			 res=(res*10)+i%10;
			 i=i/10;
		}
		if(res==temp)
		{
			System.out.println("pallindrome");
		}
		else
			System.out.println("not pallindrome");
	}

}
