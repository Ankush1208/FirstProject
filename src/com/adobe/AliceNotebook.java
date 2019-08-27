package com.adobe;

/*
 * import java.util.Arrays; import java.util.Random;
 * 
 * public class AliceNotebook {
 * 
 * public static void main(String[] args) {
 * 
 * int k = 3; int[] arr2= {2,9,4,6,18,40,90,64}; Random r1 = new Random(); int[]
 * arr1 = new int[100000]; for (int i = 0; i < arr1.length; i++) { arr1[i] =
 * r1.nextInt(100000); } // System.out.println(Arrays.toString(arr1));
 * computeLis(arr2,arr2.length,k);
 * 
 * }
 * 
 * private static void computeLis(int[] arr1, int length, int k) {
 * 
 * int[] lis = new int[length]; int max = 0; for (int i = 0; i < length; i++)
 * lis[i] = 1; for (int i = 1; i < length; i++) { for (int j = 0; j < i; j++) {
 * if (arr1[i] >= k * arr1[j] && lis[i] < lis[j] + 1) lis[i] = lis[j] + 1; } }
 * 
 * for (int i = 0; i < length; i++) { if (max < lis[i]) max = lis[i]; }
 * 
 * System.out.println(max); }
 * 
 * }
 * 
 */

//Java program to find length of longest increasing subsequence //in O(n Log
//  n) time 
import java.io.*;
import java.util.*;
import java.lang.Math;

public class AliceNotebook { // Binary search (note boundaries in the caller)
	// A[] is ceilIndex in the caller
	static int CeilIndex(int A[], int l, int r, int key) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (A[m] >= key)
				r = m;
			else
				l = m;
		}

		return r;
	}

	static int LongestIncreasingSubsequenceLength(int A[], int size) {
  
  int[] tailTable = new int[size]; int len; // always points empty slot
  
  tailTable[0] = A[0]; len = 1;
  for (int i = 1; i < size; i++) { 
	  if (A[i] <
  tailTable[0]) // new smallest value
	  tailTable[0] = A[i];
  
  else if (A[i] >= 3*tailTable[len - 1])
	  // A[i] wants to extend largest  subsequence 
	  tailTable[len++] = A[i];
  
  else 
  tailTable[CeilIndex(tailTable, -1,
  len - 1, A[i])] = A[i]; }
  
  return len; }

	// Driver program to test above function 
	public static void main(String[]
	args)

	{
		int arr[] = { 2, 9, 4, 6, 18, 40, 54 };
		int k = 3;
		int n = arr.length;
		Random r1 = new Random();
		int[] arr1 = new int[100000];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = r1.nextInt(100000);
		}
		System.out.println(
				"Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(arr, arr.length));
	}
}
