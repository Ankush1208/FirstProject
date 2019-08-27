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

	@SuppressWarnings("unused")
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
		 
		  correctBst(root);
		 
		 System.out.println();
		 
	}

	private void correctBst(Node root) {

		if(root==null)
			return;
		 Node x=new Node(0);
		  Node y=new Node(0);
		  Node prev=new Node(Integer.MIN_VALUE);
		  correctBst(root,x,y,prev);
			 if(x!=null&&y!=null)
			 {
				 Node temp=x;
				 x=y;
				 y=temp;
			 }
	}

	private void correctBst(Node root,Node x,Node y,Node prev) {
		
		if(root==null)
			return;
		correctBst(root.left, x, y, prev);
        if(root.value<prev.value)
        {
        	if(x==null)
        		x=new Node(prev.value);
        	else
        		y=new Node(root.value);
        }
        prev=root;
        correctBst(root.right, x, y, prev);
		
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
