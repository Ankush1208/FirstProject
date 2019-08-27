package com.adobe;

public class BinaryToDecimal {

	public static void main(String[] args) {

		int num=111;
		convertToDecimal(num);
	}

	private static void convertToDecimal(int num) {

		int temp=0,i=0,res=0;
		while(num>0)
		{
			temp=num%10;
			res+=temp*Math.pow(2, i++);
			num=num/10;
			
		}
		
		System.out.println(res);
	}

}
