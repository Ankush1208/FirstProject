package com.amazon.interview;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KthSmallestElementInArray {

	private static final String Iterater = null;

	public static int find(int[] A, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		/*
		 * for(int i=0;i<A.length;i++) { pq.add(A[i]); }
		 */
		pq.add(2);
		pq.add(3);
		pq.add(8);
		pq.add(1);
		pq.add(0);
		pq.add(7);
		// System.out.println(pq);

		Iterator it = pq.iterator();

		while (it.hasNext()) {
			System.out.print(it.next() + " ");

		}
		int n = -1;
		System.out.println();

		while (k > 0) {
			n = pq.poll();
			System.out.println(n);

			k--;
		}

		return n;
	}

	public static void main(String[] args) {
		int[] A = { 8, 1, 2, 10, 20, 40, 32, 44, 51, 6, 9 };
		int k = 5;

		System.out.println("4th smallest element:" + find(A, 6));

	}

}