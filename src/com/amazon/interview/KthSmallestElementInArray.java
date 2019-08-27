package com.amazon.interview;

import java.util.Iterator;
import java.util.PriorityQueue;

public class KthSmallestElementInArray {


	public static void find(int[] a, int k) {
		PriorityQueue<Integer> pq = null;
	
		for(int i=0;i<a.length-1;i++)
		{
			System.out.println("for element" +a[i] +" the next kth largest element is ");
			findKth(pq,a,k,i+1);
			System.out.println();
		}
		

		/*
		 * Iterator it = pq.iterator();
		 * 
		 * while (it.hasNext()) { System.out.print(it.next() + " ");
		 * 
		 * } int n = -1; System.out.println();
		 * 
		 * while (k > 0) {
		 * 
		 * n = pq.poll(); System.out.println(n);
		 * 
		 * k--; }
		 */

	
	}
	 static double getMedian(  PriorityQueue<Integer> maxHeap,  PriorityQueue<Integer> minHeap)
	    {
	               int maxHeapSize=maxHeap.size();
	          int minHeapSize=minHeap.size();
	          if(maxHeapSize==minHeapSize)
	          return ((double) (maxHeap.peek()+ minHeap.peek()) )/2;
	          if(maxHeapSize > minHeapSize)
	           return (double) maxHeap.peek();
	           else
	                      return (double) minHeap.peek();

	    }

	private static void findKth(PriorityQueue<Integer> pq, int[] a, int k,int i) {
		pq=new PriorityQueue<>((x, y) -> y - x);
		for(int j=i;j<a.length;j++)
			pq.add(a[j]);
		
		int n = -1;
		while (k > 0) {
			
			n = pq.poll();
			k--;
		}
		System.out.print(n);
	}

	public static void main(String[] args) {
		int[] a = { 8, 1, 2, 10, 20, 40, 32, 44, 51, 6, 9 };
		int k = 2;

          find(a, k);
	}

}