package com.amazon.interview;

import java.util.*;

public class StackUsingQueues {

	private static Queue<Integer> q1 = new LinkedList<Integer>();
	private static Queue<Integer> q2 = new LinkedList<Integer>();

	private static int top = 0;

	public static void main(String[] args) {

		push2(1);
		push2(2);
		push2(3);
		System.out.println(q1);
		System.out.println("the top element is: " + top2());

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
	
	private static int top1() // o(1) complexity
	{
		if (q2.isEmpty())
			return -1;
		else

			return q2.peek();

	}
	private static int top2() // o(1) complexity
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
	private static void push1(int x)
	{
		q1.add(x);
		while(!q2.isEmpty()) {
			int temp=q2.poll();
			q1.add(temp);
		}
		Queue<Integer> q3=q2;
		q2=q1;
		q1=q3;
	//	q1=q2;
	}
	private static void push2(int x)
	{
	
		while(!q1.isEmpty()) {
			int temp=q1.poll();
			q2.add(temp);
		}
		q1.add(x);
		while(!q2.isEmpty()) {
			int temp=q2.poll();
			q1.add(temp);
		}
		
	//	q1=q2;
	}
	private static void push(int x) // o(n) complexity
	{
		int size = q1.size();
		q1.add(x);
		while(!q1.isEmpty()){
			top = q1.remove();
			q1.add(top);
		}

	}

}
