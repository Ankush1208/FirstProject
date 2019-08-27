package com.amazon.interview;

public class MaximumJminusI {

	public static void main(String[] args) {

		int[] arr= {34, 8, 10, 3, 2, 80, 30, 33, 1};
		findMaximum(arr,arr.length);
		}

	private static void findMaximum(int[] arr, int length) {

		int[] leftMin=new int[length];
		int[] rightMax=new int[length];
		
		leftMin[0]=arr[0];
		rightMax[length-1]=arr[length-1];
		for(int i=1;i<length;i++)
		{
			leftMin[i]=Math.min(leftMin[i-1], arr[i]);
		}
		for(int i=length-2;i>=0;i--)
			rightMax[i]=Math.max(rightMax[i+1], arr[i]);
		
		int i=0,j=0,max=0;
	while(i<length&&j<length)
	{
		if(leftMin[i]<rightMax[j]) {
			max=Math.max(max, j-i);
			j=j+1;
			
		}
		else
			i=i+1;
	}
	System.out.println(max);
	
	}

}
