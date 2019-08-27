package com.amazon.interview;

import java.util.ArrayList;
import java.util.*;

public class SlidingWindowMaximum {

	public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (nums == null || nums.length == 0 || k < 0) {
			return rst;
		}
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < k; i++) {
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				deque.pollLast();
			}
			deque.offerLast(i);
		}

		for (int i = k; i < nums.length; i++) {
			rst.add(nums[deque.peekFirst()]);
			if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.pollFirst();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
				deque.pollLast();
			}
			deque.offerLast(i);
		}

		// Last move's result needs to be recorded:
		rst.add(nums[deque.peekFirst()]);
		return rst;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 7, 1, 2, 4, 2, 5, 2, 6, 3, 6 };
		int k = 4;
		System.out.println(maxSlidingWindow(arr, k));
		Deque<Integer> d1 = new LinkedList<Integer>();
		System.out.println(d1.peekLast());

		/******************** Naive Approach ***************************************/

		for (int i = 0; i <= arr.length - k; i++) {
			while (--k > 0) {

				if (arr[i] < arr[k + i]) {
					arr[i] = arr[k + i];

				}

			}
			k = 4;
		}
		for (int i = 0; i <= arr.length - k; i++)
			System.out.print((arr[i] + " "));

	}

}
