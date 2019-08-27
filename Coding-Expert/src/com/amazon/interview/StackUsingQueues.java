package com.amazon.interview;

import java.util.*;

public class StackUsingQueues {

	private static Queue<Integer> q1 = new LinkedList<Integer>();
	private static int top = 0;

	public static void main(String[] args) {

		push(1);
		push(2);
		push(3);
		System.out.println(q1);
		System.out.println("the top element is: " + top());

		boolean isEmpty = isEmpty();
		System.out.println(isEmpty);
	}

	private static boolean isEmpty() // o(1) complexity
	{
		return q1.isEmpty();
	}

	private static int top() // o(1) complexity
	{
		if (q1.isEmpty())
			return -1;
		else

			return q1.peek();

	}

	static int pop() // o(1) complexity
	{
		if (q1.isEmpty()) {
			System.out.println("No elements");
			return -1;
		}
		int x = q1.remove();
		return x;
	}

	private static void push(int x) // o(n) complexity
	{
		int size = q1.size();
		q1.add(x);
		for (int i = 0; i < size; i++) {
			top = q1.remove();
			q1.add(top);
		}

	}

}
