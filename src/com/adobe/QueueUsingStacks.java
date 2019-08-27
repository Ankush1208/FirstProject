package com.adobe;

import java.util.Stack;

public class QueueUsingStacks {

	static Stack<Integer> s1=new Stack<Integer>();
	static Stack<Integer> s2=new Stack<Integer>();

	public static void main(String[] args) {

		
		push(1);
		push(2);
		push(3);

       System.out.println(s1);	
       pop();
	}
private static void pop()
{
	if(!s1.isEmpty())
	{
		int temp=s1.pop();
		System.out.println(temp);
	}

	else
		System.out.println("underflow");
}
	private static void push(int i) {

	
		while(!s1.isEmpty())
		{
			s2.push(s1.pop());
			
		}
		s1.push(i);
		while(!s2.isEmpty())
		{
			s1.push(s2.pop());
		}
	
	}

}
