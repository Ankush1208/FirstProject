package com.amazon.interview;

import java.util.Arrays;

public class RearrangePositiveAndNegaive {

	public static void main(String[] args) {

		int[] arr= { -1, 2, -3, 4, 5, 6, -7, 8, 9};
		reArrange(arr);
	}

	private static void reArrange(int[] arr) {

	   int i=-1,temp=0;
	   for(int j=0;j<arr.length;j++)
	   {
		   if(arr[j]<0) {
			   i++;
			   temp=arr[i];
		      arr[i]=arr[j];
		      arr[j]=temp;
		      
		   }
	   }
	   int pos=i+1,neg=0;
	   while(pos<arr.length & 0>arr[neg] && pos>neg)
	   {
		   temp=arr[neg];
		   arr[neg]=arr[pos];
		   arr[pos]=temp;
		   pos++;
		   neg+=2;
	   }
	   System.out.println(Arrays.toString(arr));
	   
	   
	}

}
