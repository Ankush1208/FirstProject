package com.amazon.interview;

public class LinkedListPallindrome {

	static Node head, head1, tail;
	static boolean isPalindrom = true;

	static class Node {
		char data;
		Node next;

		public Node(char data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		char[] str = { 'a', 'd', 'c', 'b', 'a' };
		for (int i = 0; i < str.length; i++)
			insert(str[i]);
		print();
		head1 = head;
		boolean res = isPallindrome(head);
		System.out.println(res);

	}

	private static boolean isPallindrome(Node head2) {

		if (head2.next != null && head2 != null) {
			isPallindrome(head2.next);
		}
		if (!checkPallindrome(head2)) {
			return false;
		}

		return true;
	}

	private static boolean checkPallindrome(Node temp)

	{

		if (head1 != null && head1.data == temp.data) {
			head1 = head1.next;
			return true;
		}

		return false;
	}

	private static void print() {
		Node temp = head;
		while (true) {
			if (temp == null)
				break;
			else
				System.out.print(temp.data + "->");
			temp = temp.next;

		}
		System.out.println("NULL");

	}

	private static void insert(char data) {

		Node n = new Node(data);
		System.out.println("adding element: " + data);

		if (head == null) {
			head = n;
			tail = n;
		} else

			tail.next = n;
		tail = n;

	}

}
