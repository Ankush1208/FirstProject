package com.amazon.interview;

import java.math.BigInteger;

public class MaxSumNoAdjacent {

	
	
	static int fib(int n) { 
		BigInteger b1=new BigInteger("121231313123131221321");
		System.out.println(b1);
		/*BigInteger phi = new BigInteger((long) ((1 + Math.sqrt(5)) / 2)); 
		return (int) Math.round(Math.pow(phi, n) 
								/ Math.sqrt(5)); 
		} */
		return n;
	}
	public static void main(String[] args) {
		// int a[]={5,5,10,100,10,5};
		// int a[]={1,2,3};
		int a[] = {5,  5, 10, 40, 50, 35};
		int incl=a[0];
		int excl=0;
		for(int i=1;i<a.length;i++)
		{
			int excl_new=excl>incl?excl:incl;
			incl=excl+a[i];
			excl=excl_new;
			
		}
		System.out.println(excl>incl?excl:incl);
	}

}
