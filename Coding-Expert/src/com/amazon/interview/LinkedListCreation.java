package com.amazon.interview;

public class LinkedListCreation {

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
		Node third = null, forth = null, fifth = null, sixth = null, seventh = null, eight = null;

		insert(first, 1);
		insert(second, 2);
		insert(third, 3);
		insert(forth, 4);
		insert(fifth, 5);
		/*
		 * insert(sixth, 4); insert(seventh, 20); insert(eight, 20);
		 */

		// addAfter(20,45);
		// print();
		/*
		 * pairWiseSwap(); System.out.println(" \n\nlink list after pair wise swap");
		 * print(); System.out.println("\n\nlink list aftger oddeventogether");
		 * oddEvenTogether(); print();
		 * 
		 * System.out.println("\n\nDeleting Kth nodes"); deleteKthNode(7); print();
		 * 
		 * System.out.println("\n\n Segregating Even Odd Nodes "); segregateOddEven();
		 * print();
		 * 
		 * System.out.println("\n\n sort 0's 1's 2's list"); sort0s1s2sList(); print();
		 */

		swapLinkedList(2, 4);
		print();

		/*
		 * reverseLinkedList(); print(); recursiveToReverseLinkedList(head);
		 * removeDuplicates(); print();
		 */

	}

	/*
	 * private static void removeDuplicates() {
	 * 
	 * Node current = head;
	 * 
	 * Pointer to store the next pointer of a node to be deleted Node next_next;
	 * 
	 * do nothing if the list is empty if (head == null) return;
	 * 
	 * Traverse list till the last node while (current.next != null) {
	 * 
	 * Compare current node with the next node if (current.data ==
	 * current.next.data) { next_next = current.next.next; current.next = null;
	 * current.next = next_next; } else // advance if no deletion current =
	 * current.next; } }
	 */

	private static void recursiveToReverseLinkedList(Node temp) {
		if (temp.next != null) {
			recursiveToReverseLinkedList(temp.next);
		}
		if (temp != null)
			System.out.print(temp.data + "->");

	}

	private static void reverseLinkedList() {

		Node temp = head;
		Node prev = null, next = null;
		while (temp != null) {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		head = prev;
	}

	private static void swapLinkedList(int i, int j) {

		Node tempa = head, tempb = head;
		Node preva = null;
		Node prevb = null;

		if (i == j)
			return;
		while (tempa != null && tempa.data != i) {
			preva = tempa;
			tempa = tempa.next;
		}
		while (tempb != null && tempb.data != j) {
			prevb = tempb;
			tempb = tempb.next;
		}

		if (preva != null)
			preva.next = tempb;
		else
			head = preva;
		if (prevb != null)
			prevb.next = tempa;

		Node temp = tempb.next;
		tempb.next = tempa.next;
		tempa.next = temp;

	}

	private static void sort0s1s2sList() {

		Node temp = head;
		int count[] = { 0, 0, 0 };
		while (temp != null) {
			count[temp.data]++;
			temp = temp.next;
		}
		int i = 0;
		temp = head;
		while (temp != null) {
			if (count[i] == 0)
				i++;
			else {
				temp.data = i;
				--count[i];
				temp = temp.next;
			}
		}

	}

	private static void segregateOddEven() {
		Node temp = head;
		Node oddNodes = null, oddStart = null, evenNodes = null, evenStart = null;
		Node h = null;
		int count1 = 0, count2 = 0;
		if (head == null)
			return;

		while (true) {
			if (temp == null)
				break;

			if (temp.data % 2 == 0) {
				if (temp == head || count1 == 0) {
					evenNodes = temp;
					head = evenNodes;
					temp = temp.next;
					count1++;
				} else {
					count1++;
					evenNodes.next = temp;
					temp = temp.next;
					evenNodes = evenNodes.next;
				}
			} else {
				if (temp == head || count2 == 0) {
					oddNodes = temp;
					oddStart = oddNodes;
					temp = temp.next;
					count2++;
				} else {
					count2++;
					oddNodes.next = temp;
					temp = temp.next;
					oddNodes = oddNodes.next;
				}
			}

		}
		evenNodes.next = oddStart;

	}

	private static Node deleteKthNode(int k) {

		int count = 0;
		Node temp = head;
		Node temp1 = null;
		if (k == 0)

			return head;

		if (k == 1) {
			head = null;
			return temp;
		} else

			while (temp.next != null) {
				count++;

				if (count == k - 1) {
					temp1 = temp.next;

					if (temp1.next != null) {
						temp.next = temp1.next;
						temp = temp1.next;
						count = 0;
					} else
						temp.next = null;

				} else
					temp = temp.next;

			}
		return temp;
	}

	private static void oddEvenTogether() {
		Node odd = head;
		Node even = head.next;
		Node evenfirst = even;
		if (head == null)

			return;

		while (odd != null && even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenfirst;
		// System.out.println();
		// temp.next=temp1;

	}

	private static void pairWiseSwap() {

		Node temp = head;
		while (temp != null && temp.next != null) {
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}

	}

	private static void addAfter(int i, int j) {
		Node temp = head;
		Node temp2 = null;
		while (true) {
			if (temp.data == i) {
				temp2 = temp;
				break;

			}
			temp = temp.next;

		}
		if (temp2 != null) {
			Node nd = new Node(j);
			nd.next = temp.next;
			if (temp == tail) {
				tail = nd;
			}
			temp.next = nd;

		} else {
			System.out.println("Unable to find the given element...");
		}

	}

	private static void print() {
		Node temp = head;
		while (true) {
			if (temp == null)
				break;
			else
				System.out.print(temp.data + " --> ");
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
