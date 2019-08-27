package com.adobe;

import java.util.*;
//Java program to check if Binary tree is sum tree or not 


class Node {
	int data;
	Node left, right, nextRight;

	Node(int item) {
		data = item;
		left = right = nextRight = null;
	}
}

public class BinaryTree {
	Node root;
     static int maxLevel=0;
	public static void main(String args[]) {
		
		int[] arr= {2,4,3};
		

		BinaryTree tree = new BinaryTree();
		tree.root=new Node(arr[0]);
		for(int i=1;i<arr.length;i++)
		{
			insert(tree.root,arr[i]);
		}
		
       printPreOrder(tree.root);
		/*
		 * tree.root = new Node(26); tree.root.left = new Node(10); tree.root.right =
		 * new Node(3); tree.root.left.left = new Node(4); tree.root.left.right = new
		 * Node(6); tree.root.right.right = new Node(3);
		 */
		/*
		 * if (tree.isSumTree(tree.root) != 0)
		 * System.out.println("The given tree is a sum tree"); else
		 * System.out.println("The given tree is not a sum tree");
		 * 
		 * System.out.println("before mirror tree inorder is"); tree.inOrder();
		 * 
		 * System.out.println(); convertBinaryTreeToMirrorTree(tree.root);
		 * System.out.println("after conversion mirror tree is: "); tree.inOrder();
		 * printSpiralAfterChangingTwoLevel(tree.root);
		 */
		//PrintLevelorderSpiral(tree.root);
		//printrightView(tree.root, 0);

	}

	private static void printPreOrder(Node root2) {

		if(root2==null)
			return;
		System.out.print(root2.data + " ");
		printPreOrder(root2.left);
		printPreOrder(root2.right);
	}

	private static void connectNodeAtSameLevel(Node root)
	{
		if(root==null)
			return;
		Queue<Node> q1=new LinkedList<Node>();
		q1.add(root);
		q1.add(null);
		while(!q1.isEmpty())
		{
			Node temp=q1.poll();
			if(temp!=null)
			{
				temp.nextRight=q1.peek();
				
				if(temp.left!=null)
					q1.add(temp.left);
				if(temp.right!=null)
					q1.add(temp.right);
			}
			else
				if(!q1.isEmpty())
				{
					q1.add(null);
				}
		}
	}
	private static void insert(Node root,int i) {

		if(root==null)
			return;
		if(i<root.data)
		{
			if(root.left!=null)
				insert(root.left, i);
			else
				root.left=new Node(i);
		}
		else {
			if(root.right!=null)
				insert(root.right, i);
			else
				root.right=new Node(i);
		}
	}

	void inOrder() {
		inOrder(root);
	}

	void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	private static Node convertBinaryTreeToMirrorTree(Node root2) {

		if (root2 == null)
			return root2;
		Node left = convertBinaryTreeToMirrorTree(root2.left);
		Node right = convertBinaryTreeToMirrorTree(root2.right);

		root2.left = right;
		root2.right = left;
		return root2;
	}

	private int isSumTree(Node root2) {
		int ls, rs;
		if (root2 == null || isLeafNode(root2))
			return 1;
		if (isSumTree(root2.left) != 0 && isSumTree(root2.right) != 0) {
			if (root2.left == null)
				ls = 0;
			else if (isLeafNode(root2.left))
				ls = root2.left.data;
			else
				ls = 2 * (root2.left.data);
			if (root2.right == null)
				rs = 0;
			else if (isLeafNode(root2.right))
				rs = root2.right.data;
			else
				rs = 2 * root2.right.data;

			if (root2.data == ls + rs)
				return 1;
			else
				return 0;
		}

		return 0;
	}

	private boolean isLeafNode(Node root2) {
		if (root2 == null)
			return false;
		if (root2.left == null && root2.right == null)
			return true;
		return false;
	}

	private static void PrintLevelorderSpiral(Node root) {
		Deque<Node> queue = new LinkedList<Node>();
		queue.add(root);
		boolean spiral = false;
		while (!queue.isEmpty())
		{
			int count = queue.size();
			while (count-- != 0) {
				if (spiral) {
					Node tempNode = queue.pollFirst();
					System.out.print(tempNode.data + "->");
					if (tempNode.left != null)
						queue.addLast(tempNode.left);
					if (tempNode.right != null)
						queue.addLast(tempNode.right);
				} else {
					Node tempNode = queue.pollLast();
					System.out.print(tempNode.data + "->");
					if (tempNode.right != null)
						queue.addFirst(tempNode.right);
					if (tempNode.left != null)
						queue.addFirst(tempNode.left);
				}
			}
			spiral = !spiral;
			System.out.println();
		}
	}

	private static void printSpiralAfterChangingTwoLevel(Node root) {
		if (root == null)
			return;
		Queue<Node> q1 = new LinkedList<Node>();
		Stack<Node> s1 = new Stack<Node>();
		int count = 0;
		boolean spiral = false;
		q1.add(root);
		while (!q1.isEmpty()) {
			count++;
			int size = q1.size();
			while (size-- != 0) {
				Node temp = q1.poll();
				if (!spiral)
					System.out.print(temp.data + " ");
				else
					s1.push(temp);
				if (temp.left != null)
					q1.add(temp.left);
				if (temp.right != null)
					q1.add(temp.right);
			}
			if (spiral) {
				while (!s1.isEmpty()) {
					Node temp = s1.pop();
					System.out.print(temp.data + " ");
				}
			}
			if (count == 2) {
				spiral = !spiral;
				count = 0;
				System.out.println();
			}

		}
	}
	
	private static void printrightView(Node root,int level)
	{
		level+=1;
		if(root==null)
			return;
		if(maxLevel<level)
		{
			maxLevel=level;
			System.out.println(root.data);
		}
		printrightView(root.right, level);
		printrightView(root.left, level);

	}

}
