package com.amazon.interview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	int left = 0, right = 0, maxLevel = 0;
	private int max_Level;

	static class Node {
		Node left;

		Node right;

		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		new BinaryTree().run();
	}

	public void run() {
		// build the simple tree from chapter 11.
		Node root = new Node(5);
		// Node root = new Node(6);

		System.out.println("Binary Tree Example");
		System.out.println("Building tree with root value " + root.value);
		insert(root, 2);
		insert(root, 6);
		insert(root, 1);
		insert(root, 4);
		insert(root, 3);
		insert(root, 8);
		insert(root, 9);
		insert(root, 7);
		insert(root, 12);
		insert(root, 11);

		/*
		 * insert(root, 9); insert(root, 7); insert(root, 10); insert(root, 11);
		 */
		/*
		 * System.out.println("Traversing tree in order"); printInOrder(root);
		 * System.out.println("Traversing tree preorder"); printPreOrder(root);
		 * System.out.println("Traversing tree in postorder"); printPostOrder(root);
		 * System.out.println("Level order traversal"); printLevelOrder(root);
		 * System.out.println("difference between odd and even level nodes"); int diff =
		 * oddEvenDiff(root); System.out.println(diff); int max = maxlevelSum(root);
		 * System.out.println("the maximum level sum in binary tree");
		 * System.out.println(max); System.out.println("Spiral order traversal3");
		 * printSpiralOrder(root); System.out.println(); int longestLength =
		 * longestConsecutiveSeq(root, 1);
		 * System.out.println("Longest Consecutive seq is : " + longestLength);
		 */
		/*
		 * System.out.println("The lowest common ancestor is:"); Node lca =
		 * lowestCommonAncestor(root, 4, 8); System.out.println(lca.value);
		 */
		/*
		 * System.out.println("The left view order"); leftView(root, 1);
		 * System.out.println("\n\nThe right view order"); rightView(root, 1);
		 * System.out.println("\n\nreverse level order"); reverseOrder(root);
		 * System.out.println("\n\n Root to leaf path sum to given number"); boolean b =
		 * rootToleafPath(root, 28); System.out.println(b);
		 * 
		 * deleteTreeRef(root); System.out.println("tree deleted");
		 * 
		 * int d=distanceBetweenNodes(root,3,8); System.out.println(d);
		 */

		printBoundaries(root);

	}

	private void printBoundaries(Node root) {

		if (root != null)
			System.out.print(root.value + " ");
		printLeftBoundary(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRightBoundary(root.right);
	}

	private void printRightBoundary(Node right2) {

		if (right2 != null) {
			if (right2.right != null) {
				printRightBoundary(right2.right);
				System.out.print(right2.value + " ");
			} else if (right2.left != null) {
				printRightBoundary(right2.left);
				System.out.print(right2.value + " ");
			}
		}
	}

	private void printLeaves(Node left2) {

		if (left2 == null)
			return;
		printLeaves(left2.left);

		if (left2.left == null && left2.right == null)
			System.out.print(left2.value + " ");
		printLeaves(left2.right);
	}

	private void printLeftBoundary(Node left2) {

		if (left2 != null) {
			if (left2.left != null) {
				System.out.print(left2.value + " ");
				printLeftBoundary(left2.left);
			} else if (left2.right != null) {
				System.out.print(left2.value + " ");
				printLeftBoundary(left2.right);
			}
		}
	}

	private int distanceBetweenNodes(Node root, int n1, int n2) {

		int distx = rootToN(root, n1, 0) - 1;
		int disty = rootToN(root, n2, 0) - 1;
		int lca = lowestCommonAncestor(root, n1, n2).value;
		int lcadist = rootToN(root, lca, 0) - 1;
		return (distx + disty) - (2 * lcadist);

	}

	private int rootToN(Node root, int n, int d) {

		if (root == null)
			return 0;
		if (root.value == n)
			return d;
		return (rootToN(root.left, n, d + 1) | rootToN(root.right, n, d + 1));
	}

	private void deleteTreeRef(Node root) {
		deleteTree(root);
		root = null;

	}

	private void deleteTree(Node root) {
		if (root == null)
			return;
		deleteTree(root.left);
		deleteTree(root.right);
		System.out.println("the deleted node is : " + root.value);
		root = null;
	}

	private boolean rootToleafPath(Node root, int sum) {
		if (root == null) {
			if (sum == 0)
				return true;
			else
				return false;
		}

		if (root.left == null && root.right == null) {
			if (sum == root.value)
				return true;
			else
				return false;
		}

		return rootToleafPath(root.left, sum - root.value) || rootToleafPath(root.right, sum - root.value);
	}

	private void reverseOrder(Node root) {

		Queue<Node> queue = new LinkedList<Node>();
		Deque<Node> queue1 = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			queue1.addFirst(tempNode);

			// System.out.print(tempNode.value+ "->");
			if (tempNode.right != null)
				queue.add(tempNode.right);
			if (tempNode.left != null)
				queue.add(tempNode.left);
		}
		for (Node n : queue1)
			System.out.print(n.value + " ");
	}

	private void rightView(Node root, int i) {

		i = i + 1;
		if (root == null)
			return;
		if (max_Level < i) {
			System.out.print(root.value + " ");
			max_Level = i;
		}
		rightView(root.right, i);
		rightView(root.left, i);

	}

	private void leftView(Node root, int level) {
		level = level + 1;
		if (root == null)
			return;

		if (maxLevel < level) {
			System.out.print(" " + root.value);
			maxLevel = level;
		}

		// Recur for left and right subtrees
		leftView(root.left, level);
		leftView(root.right, level);

	}

	private Node lowestCommonAncestor(Node root, int n1, int n2) {
		if (root == null)
			return null;

		if (root.value == n1 || root.value == n2)
			return root;
		Node left = lowestCommonAncestor(root.left, n1, n2);
		Node right = lowestCommonAncestor(root.right, n1, n2);
		if (left != null && right != null)
			return root;
		return (left != null ? left : right);
	}

	private int longestConsecutiveSeq(Node root, int res) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return res;
		if (root.left != null && root.left.value == (root.value + 1)) {
			left = longestConsecutiveSeq(root.left, res + 1);
		} else
			left = longestConsecutiveSeq(root.left, 1);
		if (root.right != null && root.right.value == (root.value + 1)) {
			right = longestConsecutiveSeq(root.right, res + 1);
		} else
			right = longestConsecutiveSeq(root.right, 1);

		int max = Math.max(left, right);
		return max;
	}

	private void printSpiralOrder(Node root) {

		Deque<Node> queue = new LinkedList<Node>();
		queue.add(root);
		boolean spiral = false;
		while (!queue.isEmpty())

		{
			int count = queue.size();

			while (count-- != 0) {
				if (spiral) {
					Node tempNode = queue.pollFirst();
					System.out.print(tempNode.value + "->");
					if (tempNode.left != null)
						queue.addLast(tempNode.left);
					if (tempNode.right != null)
						queue.addLast(tempNode.right);
				} else {
					Node tempNode = queue.pollLast();
					System.out.print(tempNode.value + "->");
					if (tempNode.right != null)
						queue.addFirst(tempNode.right);
					if (tempNode.left != null)
						queue.addFirst(tempNode.left);
				}

			}
			spiral = !spiral;

		}
	}

	private int maxlevelSum(Node root) {
		int max = root.value;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			int sum = 0;

			while (count-- != 0) {
				Node tempNode = queue.poll();
				sum += tempNode.value;
				if (tempNode.left != null)
					queue.add(tempNode.left);
				if (tempNode.right != null)
					queue.add(tempNode.right);

			}
			if (max <= sum)

				max = sum;

		}
		return max;
	}

	private int oddEvenDiff(Node root) {
		if (root == null)

			return 0;

		else

			return root.value - oddEvenDiff(root.left) - oddEvenDiff(root.right);

	}

	private void printLevelOrder(Node root) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();

			System.out.print(tempNode.value + "->");
			System.out.println();
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
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

	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println("  Traversed inOrder " + node.value);
			printInOrder(node.right);
		}
	}

	public void printPreOrder(Node node) {
		if (node != null) {
			System.out.println("  Traversed PreOrder " + node.value);

			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}

	public void printPostOrder(Node node) {
		if (node != null) {

			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.println("  Traversed PostOrder" + node.value);

		}
	}

}
