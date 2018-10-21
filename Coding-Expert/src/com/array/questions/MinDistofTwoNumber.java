package com.array.questions;

public class MinDistofTwoNumber {

	public static void main(String[] args) {

		int[] arr= {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		int x=3;
		int y=6;
		int l=arr.length;
		findMinDistance(arr,l,x,y);
	}

	private static void findMinDistance(int[] arr, int l, int x, int y) {

		int first=0;
		int min=Integer.MAX_VALUE,i=0;
		for( i=0;i<l;i++)
		{
			if(arr[i]==x|| arr[i]==y)

				{
				first=i;
			break;
				}
		}
		for(i=first;i<l;i++)
		{
			if(arr[i]==x||arr[i]==y)
			{
				if(arr[i]!=arr[first]&& (i-first)<min)
				{
					min=i-first;
					first=i;
				}
				first=i;
			}
		}
		System.out.println(min);
		
	}

}
