package com.amazon.interview;

public class SortedArraytoBST {
	static class Node {
		Node left;

		Node right;

		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };
		Node root = createBST(arr, 0, arr.length - 1);
		System.out.println("sorted tree is ");
		preOrder(root);

	}

	static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	private static Node createBST(int[] arr, int start, int end) {

		if (start > end)
			return null;

		int mid = (start + end + 1) / 2;
		Node root = new Node(arr[mid]);
		root.left = createBST(arr, start, mid - 1);
		root.right = createBST(arr, mid + 1, end);
		return root;

	}
}
