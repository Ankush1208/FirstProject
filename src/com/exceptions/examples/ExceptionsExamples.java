package com.exceptions.examples;

import java.io.IOException;

public class ExceptionsExamples {
	
	private final int x;
	
	public ExceptionsExamples( int x) {
		this.x=x;
		System.out.println(x);
	}

	/*
	 * public void findmatch(int i) { System.out.println("int"); }
	 */
	public void findmatch(Integer k) 
	{
		System.out.println("integer");
	}
	public void findmatch(long i) 
	{
		System.out.println("long");
	}
	

	public static void main(String[] args) {
		int a=10;
		int b=20;
		
      ExceptionsExamples e1=new ExceptionsExamples(10);
      ExceptionsExamples e2=new ExceptionsExamples(20);
  e1.findmatch(10);
      
		/*
		 * int sum=sum(a,b); System.out.println(sum);
		 */
		
		int i=10;
		int j=0;
		
		try {
			int l=i/j;
			System.out.println("surpass exception");
			
		}
		catch(ArithmeticException e) {
			System.out.println("ae reached" );

			
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
