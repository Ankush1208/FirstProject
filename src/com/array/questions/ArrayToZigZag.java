package com.array.questions;

import java.util.Arrays;

public class ArrayToZigZag {

	public static void main(String[] args) {

		int[] arr= {1,4,3,2};
		convertToZigZag(arr,arr.length);
	}

	private static void convertToZigZag(int[] arr, int length) {

		boolean flag=true;
		int temp=0;
		for(int i=0;i<=arr.length-2;i++)
		{
		if(flag)
		{
			if(arr[i]>arr[i+1])
			{
	
		temp=arr[i];
			arr[i]=arr[i+1];
			arr[i+1]=temp;
			}
		
	}
		else
		{
			if(arr[i]<arr[i+1])
			{
				 temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		
		flag=!flag;
		}
		System.out.println(Arrays.toString(arr));
	}
}
