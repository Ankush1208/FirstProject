package com.amazon.interview;

import java.util.*;

public class SortStackusingRecursion {

	public static void main(String[] args) {

		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(4);
		s1.push(1);
		s1.push(10);
		s1.push(-1);
		s1.push(5);

		sortStack(s1);
		print(s1);

	}

	private static void print(Stack<Integer> s1) {
		ListIterator<Integer> itr = s1.listIterator();
		while (itr.hasNext())
			itr.next();

		while (itr.hasPrevious())
			System.out.println(itr.previous());

	}

	static void sortStack(Stack<Integer> s) {
		if (!s.isEmpty()) {
			int x = s.pop();

			sortStack(s);

			sortedInsert(s, x);
		}
	}

	static void sortedInsert(Stack<Integer> s, int x) {

		if (s.isEmpty() || x > s.peek()) {
			s.push(x);
			return;
		}
		int temp = s.pop();
		sortedInsert(s, x);
		s.push(temp);
	}

}
