package com.amazon.interview;

public class sortingTwoLinkedList {

	static Node head1, tail1;
	static Node head2, tail2;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static void print(Node head) {
		Node temp = head;
		while (true) {
			if (temp == null)
				break;
			else
				System.out.println(temp.data);
			temp = temp.next;

		}

	}

	private static void insert(Node head, int data) {

		Node n = new Node(data);
		if (head1 == null) {
			head1 = n;
			tail1 = n;
		} else
			tail1.next = n;
		tail1 = n;

	}

	private static void insert1(Node head, int data) {

		Node n = new Node(data);
		if (head2 == null) {
			head2 = n;
			tail2 = n;
		} else
			tail2.next = n;
		tail2 = n;

	}

	public static void main(String[] args) {
		System.out.println("Inserting first linked list");
		insert(head1, 4);
		insert(head1, 5);
		insert(head1, 7);
		System.out.println("printing first linked list");
		print(head1);
		System.out.println("inserting second linked list");
		insert1(head2, 2);
		insert1(head2, 3);
		insert1(head2, 6);

		System.out.println("printing second linked list");
		print(head2);
		System.out.println("sorted Array");
		Node res = sortTwoList(head1, head2);
		print(res);
	}

	private static Node sortTwoList(Node head12, Node head22) {
		Node a = head12;
		Node b = head22;
		Node res = null;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.data <= b.data) {
			res = a;
			// System.out.println(res.data);
			res.next = sortTwoList(a.next, b);

		} else {
			res = b;
			// System.out.println(res.data);
			res.next = sortTwoList(a, b.next);
		}

		return res;
	}

}
