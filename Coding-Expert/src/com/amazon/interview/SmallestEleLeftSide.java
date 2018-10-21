package com.amazon.interview;

import java.util.Stack;

public class SmallestEleLeftSide {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 0, 2, 5 };
		Stack<Integer> S = new Stack<Integer>();
		for (int i = 0; i < arr.length; i++) {

			while (!S.empty() && S.peek() >= arr[i]) {
				S.pop();
			}
			if (S.empty())
				System.out.print("_");
			else
				System.out.print(S.peek() + " ");

			S.push(arr[i]);
		}

	}

}
