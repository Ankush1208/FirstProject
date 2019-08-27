package com.amazon.interview;

import java.util.Arrays;
import java.util.*;

public class CustomSortOddEven {

	public static void main(String[] args) {

		int[] arr = {17,4,8 };

		List<Integer> l1=new ArrayList<Integer>();
		l1.add(17);
		l1.add(4);
		l1.add(8);
		System.out.println(moves(l1));
		int j = 0, k = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				j++;
			else
				k++;
		}

		int[] oddarr = new int[k];
		int[] evenarr = new int[j];
		j = 0;
		k = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				evenarr[j++] = i;
			else
				oddarr[k++] = i;
		}
		int min = 0;
		/*
		 * if(j==k) min=j; else
		 */
		min = Math.min(j, k);
		for (int i = 0; i < min; i++) {
			if (oddarr[i] < evenarr[--j]) {
				count++;
			}
		}
		System.out.println(count);

	}
	static int moves(List<Integer> l1)
	{
		int j = 0, k = 0,count=0,min=0;
		for (int i = 0; i < l1.size(); i++) {
			if (l1.get(i) % 2 == 0)
				j++;
			else
				k++;
		}
		int[] oddarr = new int[k];
		int[] evenarr = new int[j];
		j = 0;
		k = 0;
		for (int i = 0; i < l1.size(); i++) {
			if (l1.get(i) % 2 == 0)
				evenarr[j++] = i;
			else
				oddarr[k++] = i;
		}
		min = Math.min(j, k);
		for (int i = 0; i < min; i++) {
			if (oddarr[i] < evenarr[--j]) {
				count++;
			}
		}
		return count;
		
	}
}
