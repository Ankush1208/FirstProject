package com.string.example;

import java.util.*;

public class EArlierRepeating {

	public static void main(String[] args) {
       int n=9;
            n&=n-1;
		int[] arr={1,2,3,4,2,1};
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
		System.out.println(repe);
		System.out.println(12>>2);
		
	}

}
