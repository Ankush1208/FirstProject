package com.amazon.interview;

import java.util.Arrays;

public class NextGreaterNumber {
	static void swap(char ar[], int i, int j) {
		char temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	static void findNext(char ar[], int n) {
		int i;

		for (i = n - 1; i > 0; i--) {
			if (ar[i] > ar[i - 1]) {
				break;
			}
		}

		if (i == 0) {
			System.out.println("Not possible");
		} else {
			int x = ar[i - 1], min = i;

			for (int j = i + 1; j < n; j++) {
				if (ar[j] > x && ar[j] < ar[min]) {
					min = j;
				}
			}
			/****************
			 * Below solution also works but upper one is quite good*********88/ /* for(int
			 * j=i;j<ar.length-1;j++) { if(ar[j]>ar[j+1]) min=j+1;
			 * 
			 * }
			 */

			swap(ar, i - 1, min);

			Arrays.sort(ar, i, n);
			System.out.print("Next number with same" + " set of digits is ");
			for (i = 0; i < n; i++)
				System.out.print(ar[i]);
		}
	}

	public static void main(String[] args) {
		String str1 = "534976";
		char[] digits = str1.toCharArray();
		int n = digits.length;
		findNext(digits, n);
	}
}