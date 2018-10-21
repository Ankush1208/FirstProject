package com.amazon.interview;

import java.util.Stack;

public class QueueUsingStacks {

	private static Stack<Integer> s1 = new Stack<Integer>();
	private static Stack<Integer> s2 = new Stack<Integer>();

	public static void main(String[] args) {

		push(2);
		push(3);
		push(4);
		push(5);
		System.out.println(s1);
		int top = pop();

		System.out.println(top);

	}

	private static int pop() {

		if (s1.isEmpty())
			return -1;
		else
			return s1.pop();

	}

	private static void push(int a) {

		if (s1.size() == 0) {
			s1.push(a);
		} else {
			int size = s1.size();

			for (int i = 0; i < size; i++) {
				s2.push(s1.pop());
			}
			s1.push(a);
			for (int i = 0; i < size; i++)
				s1.push(s2.pop());
		}

	}

}
