package com.amazon.interview;

public class LinkedListIntersection {

	static Node head1 = null, head2 = null;

	static class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		LinkedListIntersection list = new LinkedListIntersection();
		list.head1 = new Node(16);
		list.head1.next = new Node(15);
		list.head1.next.next = new Node(30);
		list.head1.next.next.next = new Node(3);
		list.head1.next.next.next.next = new Node(6);

		// creating second linked list
		list.head2 = new Node(10);
		list.head2.next = new Node(15);
		list.head2.next.next = new Node(30);

		int intersection = findIntersection(head1, head2);
		System.out.println(intersection);
		print(head1);

	}

	private static int findIntersection(Node head12, Node head22) {

		int c1 = 0, c2 = 0;
		Node temp = head12;

		if (head12 == null || head22 == null) {
			return 0;
		}
		while (temp != null) {
			c1++;
			temp = temp.next;
		}
		temp = head22;
		while (temp != null) {
			c2++;
			temp = temp.next;
		}
		if (c1 > c2) {
			for (int i = 0; i < c1 - c2; i++) {
				head12 = head12.next;
			}

		} else {
			for (int i = 0; i < c2 - c1; i++) {
				head22 = head22.next;
			}
		}
		while (head12 != null && head22 != null)

		{
			if (head12.value == head22.value) {
				return head12.value;
			}
			head12 = head12.next;
			head22 = head22.next;
		}

		return 0;
	}

	private static void print(Node head12) {

		Node temp = head12;
		while (temp != null) {
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
	}

}
