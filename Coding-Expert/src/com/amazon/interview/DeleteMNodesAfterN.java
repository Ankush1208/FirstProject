package com.amazon.interview;

public class DeleteMNodesAfterN {

	static Node head, tail;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		Node first = null;
		Node second = null;
		Node third = null, fourth = null, fifth = null, sixth = null;
		insert(first, 10);
		insert(second, 20);
		insert(third, 30);
		insert(fourth, 40);
		insert(fifth, 50);
		insert(sixth, 60);
		System.out.println("LinkedListBefore Deletion");
		print();
		deleteMNodes(2, 2);
		System.out.println("linked list after deleting n nodes after m ");
		print();

	}

	private static void deleteMNodes(int m, int n) {

		Node temp = head;
		Node temp1 = null;
		while (true) {
			for (int c = 1; c < m && temp != null; c++) {
				temp = temp.next;
			}

			if (temp == null) {
				break;
			}
			temp1 = temp.next;
			for (int x = 0; x < n && temp1 != null; x++) {
				temp1 = temp1.next;
			}
			temp.next = temp1;
			temp = temp1;
		}

	}

	private static void print() {
		Node temp = head;
		while (true) {
			if (temp == null)
				break;
			else
				System.out.println(temp.data);
			temp = temp.next;

		}

	}

	private static void insert(Node n, int data) {

		n = new Node(data);
		System.out.println("adding element: " + data);

		if (head == null) {
			head = n;
			tail = n;
		} else

			tail.next = n;
		tail = n;

	}

}
