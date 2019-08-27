package com.array.questions;

import java.util.*;

public class SmallestOnLeftSide {

	private static Stack<Integer> s1=new Stack<Integer>();
	public static void main(String[] args) {

		String feed=null;
		feed=Optional.ofNullable(feed).orElse(" ");
		System.out.println(feed);
		int[] arr= {1,6,4,10,2,5};
		int l=arr.length;
		findSmallestOnLeft(arr,l);
	}

	
	private static void findSmallestOnLeft(int[] arr, int l) {

		for(int i=0;i<l;i++)
		{
			while(!s1.isEmpty() && s1.peek()> arr[i])
			{
				s1.pop();
			}
			if(!s1.isEmpty())
			System.out.print(","+s1.peek());
			else
			System.out.print("_");
			s1.push(arr[i]);
		}
		
	}

}
