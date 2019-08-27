package com.adobe;

public class MinimumNumberOfStepsToReachEnd {

	public static void main(String[] args) {

		int[] arr= {1,3,5,7,8,9,2,5,8,9};
		int n=arr.length;
		int maxReach=arr[0];
		int jump=1;
		int steps=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(i==arr.length-1)
				System.out.println(jump);
			maxReach=Math.max(maxReach, i+arr[i]);
			steps--;

			if(steps==0)
			{
				jump++;
				steps=maxReach-1;
			}
		}
	}

}
