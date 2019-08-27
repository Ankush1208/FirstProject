package com.adobe;

import java.util.Stack;

public class SpecialStack {
	
	Stack<Integer> s1=new Stack<Integer>();
	int min=0;
	
	 public  void push(int num)
	 {
		 if(s1.isEmpty())
		 {
			 min=num;
			 s1.push(num);
		 }
		 else
		 {
			 if(num <min)
			 {
				 s1.push(num);
				 min=num;
			 }
			 else
				 s1.push(num);
		 }
	 }
	 
	 public void pop() {
		 if(s1.isEmpty()) {
			 
			 System.out.println("empty");
			 return;
		 }
		 int t=s1.pop();
		
			 if(t<min) {
				 System.out.println(min);
				 min=t;
			 }
			 else
				 System.out.println(t);
	 }
	 
	 public void getMin() {
		 if(s1.isEmpty())
		 {
			 System.out.println("no min element");
			 return ;
		 }
		 
System.out.println(min);
}
	public static void main(String[] args) {
 
		
		SpecialStack s2= new SpecialStack();
		s2.push(1);
		s2.push(10);
		s2.push(9);
		s2.getMin();
		s2.pop();
		s2.push(0);
		s2.push(5);
		s2.getMin();
		s2.pop(); 
		
				
		
	}

}
