package com.adobe;

import java.util.Arrays;

public class Sort0s1s2sLinkedList {
	static LNode head, tail;

	static class LNode{
		LNode next;
		int data;
		
		
		public  LNode(int data) {
			this.data=data;
			this.next=null;
			
		}
	}
	
	
	private static LNode reverse(LNode head)
	{
		LNode temp=head;
		LNode prev=null;
		LNode next=null;
		while(temp!=null)
		{
			
			next=temp.next;
			temp.next=prev;
			prev=temp;
		   temp=next;
		   
		}
		 head=prev;
		 return head;
	}
	private static void insert( int data) {

		LNode n = new LNode(data);
		System.out.println("adding element: " + data);

		if (head == null) {
			head = n;
			tail = n;
		} else

			tail.next = n;
		tail = n;

	}

	public static void main(String[] args) {
		
		insert(1);
		insert(1);
		insert(0);
		insert(2);
		insert(0);
		/*
		 * System.out.println("before sorting");print(); System.out.println(); sort();
		 * System.out.println("after sorting"); print();
		 */
     reverse(head);
     print();

	}
	private static void sort() {

		int[] count=new int[3];
		Arrays.fill(count, 0);
        LNode temp=head;
        while(temp!=null)
        {
        	count[temp.data]++;
        	temp=temp.next;
        }
        temp=head;
        int k=0;
        while(temp!=null)
        {
        	if(count[k]==0)
        	{
        		k++;
        	}
        	else
        	{
        		temp.data=k;
        		temp=temp.next;
        		count[k]--;
        	}
        		
        }
	}

	private static void print() {
		LNode temp = head;
		while (true) {
			if (temp == null)
				break;
			else
				System.out.print(temp.data + " --> ");
			temp = temp.next;

		}

	}

}
