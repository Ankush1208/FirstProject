package com.array.questions;

public class PrintDplicatesInO1Space {

	public static void main(String[] args) {

		int[] arr= {1,1,2,3,4,4};
		printDuplicates(arr,arr.length);
		
	}

	private static void printDuplicates(int[] arr, int n) {

		for(int i=0;i<n;i++)
			arr[i]=arr[i]-1;
		for(int i=0;i<n;i++)
			arr[arr[i]%n]=arr[arr[i]%n] +n;
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]/n>1)
				System.out.println(i+1);
		}
	}

}
