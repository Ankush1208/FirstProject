package com.exceptions.examples;

import java.io.IOException;

public class ExceptionsExamples {
	
	

	public static void main(String[] args) {
		int a=10;
		int b=20;
		

		int sum=sum(a,b);
		System.out.println(sum);
		
		
		int i=10;
		int j=0;
		
		try {
			int l=i/j;
			System.out.println("surpass exception");
			
		}
		catch(ArithmeticException e) {
			System.out.println("ae reached");
			
		}
		catch(RuntimeException e)
		{
			System.out.println("caught");
		}
		finally {
			System.out.println("finally");
		}
		
	}

	private static int sum(int a, int b) {
		int sum=0;
		try{
		    sum=a+b;
		
	throw new UnsupportedOperationException();
		}catch(UnsupportedOperationException e)
		{
			return sum;
		}
		finally{
			
			System.out.println(sum);
		}
		
	}

}
