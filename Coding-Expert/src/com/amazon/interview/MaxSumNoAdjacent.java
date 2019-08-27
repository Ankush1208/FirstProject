package com.amazon.interview;

public class MaxSumNoAdjacent {

	public static void main(String[] args) {

		// int a[]={5,5,10,100,10,5};
		// int a[]={1,2,3};
		int a[] = { 3, 2, 5, 10, 7 };

		int sumodd = 0;
		int sumeven = 0;

		for (int i = 0; i < a.length; i += 2) {
			if (i % 2 == 0) {
				sumodd += a[i];
			} else
				sumeven += a[i + 1];
		}

		if (sumodd > sumeven) {
			System.out.println(sumodd);
		} else
			System.out.println(sumeven);
	}

}
