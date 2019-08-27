package com.amazon.interview;

public class MaximumDepthOrHeight {

	static class Node {
		Node left;

		Node right;

		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		new MaximumDepthOrHeight().run();
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
		insert(root, 10);
		insert(root, 11);

		int height = printMaximumDepth(root);
		System.out.println(height);
		boolean b = balancedHeight(root);
		System.out.println(b);

	}

	private boolean balancedHeight(Node root) {

		if (root == null)
			return false;
		int lheight = printMaximumDepth(root.left);
		int rheight = printMaximumDepth(root.right);
		System.out.println("leftsubtree Height: " + lheight + " " + "RightSubtree Height : " + rheight);
		return (Math.abs(lheight - rheight) > 1 ? false : true);
	}

	private int printMaximumDepth(Node node) {

		if (node == null) {
			return 0;
		} else {
			/* compute the depth of each subtree */
			int lDepth = printMaximumDepth(node.left);
			int rDepth = printMaximumDepth(node.right);
			/* use the larger one */
			if (lDepth > rDepth) {
				return (lDepth + 1);
			} else

				return (rDepth + 1);
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
