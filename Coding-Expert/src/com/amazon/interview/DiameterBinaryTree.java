package com.amazon.interview;

// A utility class to pass heigh object
class Height {
	int h;
}

/* Class to print the Diameter */
public class DiameterBinaryTree {
	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;

	/*
	 * define height =0 globally and call diameterOpt(root,height) from main
	 */
	int diameterOpt(Node root, Height height) {
		/*
		 * lh --> Height of left subtree rh --> Height of right subtree
		 */
		Height lh = new Height(), rh = new Height();

		if (root == null) {
			height.h = 0;
			return 0; /* diameter is also 0 */
		}

		lh.h++;
		rh.h++;
		int ldiameter = diameterOpt(root.left, lh);
		int rdiameter = diameterOpt(root.right, rh);

		height.h = Math.max(lh.h, rh.h) + 1;

		return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
	}

	int diameter() {
		Height height = new Height();
		return diameterOpt(root, height);
	}

	static int height(Node node) {
		if (node == null)
			return 0;

		/*
		 * If tree is not empty then height = 1 + max of left height and right heights
		 */
		return (1 + Math.max(height(node.left), height(node.right)));
	}

	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		DiameterBinaryTree tree = new DiameterBinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The diameter of given binary tree is : " + tree.diameter());
	}
}
