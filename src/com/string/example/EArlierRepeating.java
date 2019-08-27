package com.string.example;

import java.util.*;

public class EArlierRepeating {

	public static void main(String[] args) {
       int n=9;
            n&=n-1;
		int[] arr={1,2,3,4,1,2,1};
		int repe=0;
		Set<Integer> s1=new HashSet<Integer>();
	
		for(int i:arr)
		{
			if(s1.add(i)==false)
			{
			    repe=i;
			    break;
			}
				
		}
		/*
		 * Integer a1=127; Integer a2=127;
		 */
	    int a1=1270;
	    int a2=1270;
	    System.out.println(a1==a2);
		System.out.println("Sad"+1+2);
		System.out.println(12<<1);
		
	}

}
