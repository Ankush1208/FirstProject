package com.string.example;

import java.time.LocalDate;
import java.time.Month;

public class B{
	
	public static void main(String[] a1)
	{
		int[] arr= {2,3,10,2,4,8,1};
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
				max=arr[i];
			if(arr[i]<min)
				min=arr[i];
		}
		
		int diff= max-min;
		System.out.println(diff);
		
			
		
	}
}
