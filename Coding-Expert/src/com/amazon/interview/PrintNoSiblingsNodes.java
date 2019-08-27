package com.amazon.interview;

public class PrintNoSiblingsNodes {

	static class Node {
		Node left;

		Node right;

		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		new PrintNoSiblingsNodes().run();
	}

	public void run() {
		Node root = new Node(5);
		System.out.println("Binary Tree Example");
		System.out.println("Building tree with root value " + root.value);
		insert(root, 1);
		insert(root, 8);
		insert(root, 6);
		insert(root, 3);
		insert(root, 9);

		noSiblingsNodes(root);
	}

	private void noSiblingsNodes(Node node) {
		if (node == null)
			return;

		if (node.left != null && node.right != null) {
			noSiblingsNodes(node.left);
			noSiblingsNodes(node.right);
		}

		else if (node.right != null) {
			System.out.print(node.right.value + " ");
			noSiblingsNodes(node.right);
		}

		else if (node.left != null) {
			System.out.print(node.left.value + " ");
			noSiblingsNodes(node.left);
		}

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
