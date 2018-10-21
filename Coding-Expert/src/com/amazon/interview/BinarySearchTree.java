package com.amazon.interview;

public class BinarySearchTree {
	static class Node {
		Node left;

		Node right;

		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		new BinarySearchTree().run();
	}

	public void run() {
		// build the simple tree from chapter 11.
		Node root = new Node(5);
		System.out.println("Binary Tree Example");
		System.out.println("Building tree with root value " + root.value);
		insert(root, 1);
		insert(root, 8);
		insert(root, 6);
		insert(root, 3);
		insert(root, 9);
		Node search = search(root, 6);

		System.out.println("Element found: " + search.value);

		System.out.println("\n\n whether its bianry search tree or not");
		System.out.println(checkBST(root));
	}

	boolean checkBST(Node root) {

		return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	boolean isBSTUtil(Node node, int min, int max) {
		if (node == null)
			return true;
		if (node.value < min || node.value > max)
			return false;
		return (isBSTUtil(node.left, min, node.value - 1) && isBSTUtil(node.right, node.value + 1, max));
	}

	private Node search(Node root, int i) {
		if (root == null || root.value == i) {
			return root;
		} else if (root.value > i)
			return search(root.left, i);
		else
			return search(root.right, i);

	}

	public void insert(Node node, int value) {
		if (value < node.value) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				System.out.println("  Inserted " + value + " to left of " + node.value);
				node.left = new Node(value);
			}
		} else if (value > node.value) {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				System.out.println("  Inserted " + value + " to right of " + node.value);
				node.right = new Node(value);
			}
		}
	}
}
