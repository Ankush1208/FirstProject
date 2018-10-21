package com.amazon.interview;

import java.util.*;

public class StackAndQueue {

	public static void main(String[] args) {

		Stack<Integer> s1 = new Stack<Integer>();
		Queue<Integer> q1 = new LinkedList<Integer>();

		s1.push(1);
		s1.push(2);
		q1.add(1);
		q1.add(2);
		System.out.println(s1);
	}

}
