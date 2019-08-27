package com.adobe;

import java.util.Arrays;

public class Sort0s12sArray {

	public static void main(String[] args) {

		int[] arr= {1,1,0,0,2,2};
		int length=arr.length;
		sort(arr,length);
		
	}

	private static void sort(int[] arr, int length) {

		int[] count =new int[3];
		for(int i=0;i<length;i++)
		{
			count[arr[i]]++;
		}
		int k=0;
		for(int i=0;i<length;i++)
		{
			if(count[k]==0)
			{
				k++;
				i--;
			}
			else
			{
				arr[i]=k;
			    count[k]--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
