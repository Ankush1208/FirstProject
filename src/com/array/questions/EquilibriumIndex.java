package com.array.questions;

public class EquilibriumIndex {

	public static void main(String[] args) {

		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
		
         int high=arr.length;
         findEquilbrium(arr,high);
}

	private static void findEquilbrium(int[] arr,int high) {

		int leftSum=0, sum=0;
	

		for(int i=0;i<high;++i)
			
			sum+=arr[i];
		
		for(int i=0;i<high;++i) {
			sum-=arr[i];
		if(leftSum==sum)
			System.out.println(i);
		leftSum+=arr[i];
		
		}
	}
}

