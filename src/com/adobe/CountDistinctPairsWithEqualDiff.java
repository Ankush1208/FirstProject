package com.adobe;

import java.util.*;

public class CountDistinctPairsWithEqualDiff {

	public static void main(String[] args) {

		int[] arr= {1,5,3,4,2};
		int k=3;
		int length=arr.length;
		findPairs(arr,k,length);
	}

	private static void findPairs(int[] arr, int k, int length) {

		Set<Integer> s1=new HashSet<Integer>();
		int temp=0;
		for(int i=0;i<length;i++)
		{
			int sum=k-arr[i];
			if(arr[i]-k>0 && s1.contains(arr[i]-k))
			{
				System.out.println("pair = {" + arr[i] + " ," + (arr[i]-k) + "}");
			}
			if(arr[i]-k<=0 && s1.contains(arr[i]+k))
			{
				System.out.println("pair = {" + arr[i] + " ," + (arr[i]+k) + "}");

			}
			
			s1.add(arr[i]);
			
		}
		
	}

}
