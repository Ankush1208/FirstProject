package com.amazon.interview;

import java.util.*;
import java.util.Collections;

public class SmallestPositiveFromUnsorted {
	static int min1 = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Set<Integer> s1 = new HashSet<Integer>();
		int[] arr = { 2, 3, 0, -2, 56, 45, 222 };
		int smallestPositive = 0;
		for (int i : arr) {
			if (i > 0)
				s1.add(i); // o(1) complexity
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min1)
				min1 = arr[i];
		}
		System.out.println(min1);

		int min = Collections.min(s1); // o(n) complexity
		int max = Collections.max(s1); // o(n) complexity
		if (min != 1)
			smallestPositive = 1;
		else
			for (int i = min; i <= max; i++) {
				if (s1.add(i)) // o(1) complexity
				{
					smallestPositive = i;
					break;

				} else
					smallestPositive = max + 1;
			}
		System.out.println(smallestPositive);

	}

}
