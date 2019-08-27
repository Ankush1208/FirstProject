package com.adobe;

import java.math.BigInteger;
import java.util.Arrays;

public class FindIfNoIsPowerOf2 {

	
	static BigInteger b1=new BigInteger("184467440737095516167");
	  
	
	public static void main(String[] args) {

		System.out.println(Arrays.binarySearch(args, 1));
		int n = 16;
		if(b1.and(b1.subtract(new BigInteger("1"))).compareTo(new BigInteger("0"))==0 )
		{
			System.out.println("yes");
		}
		if (n != 0 && ((n & (n - 1)) == 0))
			System.out.println("the number is a power of 2");
		else
			System.out.println("The number is not a power of 2");

	

	}



}
