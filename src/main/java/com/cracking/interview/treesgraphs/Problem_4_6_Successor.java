package com.cracking.interview.treesgraphs;

import com.cracking.interview.treesgraphs.Tree.Node;

public class Problem_4_6_Successor {

	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = tree.root;
		root = new Node(20);
		root.parent = null;

		root.left = new Node(10);
		root.left.parent = root;
		root.right = new Node(30);
		root.right.parent = root;

		root.left.left = new Node(5);
		root.left.left.parent = root.left;
		root.left.right = new Node(15);
		root.left.right.parent = root.left;

		root.left.left.left = new Node(3);
		root.left.left.left.parent = root.left.left;

		root.left.right.left = new Node(12);
		root.left.right.left.parent = root.left.right;
		root.left.right.right = new Node(17);
		root.left.right.right.parent = root.left.right;

		root.right.left = new Node(25);
		root.right.left.parent = root.right;
		root.right.right = new Node(60);
		root.right.right.parent = root.right;

		root.right.right.left = new Node(40);
		root.right.right.left.parent = root.right.right;
		root.right.right.right = new Node(90);
		root.right.right.right.parent = root.right.right;

		Node successor = findInOrderSuccessor(root.right.right.right);
		if(successor != null) System.out.println(successor.value);
		else System.out.println("NULL");
	}

	//Space: O(1), Time: O(H) as we can max traverse to the root node of the tree from a leaf node
	private static Node findInOrderSuccessor(Node node) {
		if(node.right != null) {
			node = node.right;
			while(node.left != null) {
				node = node.left;
			}
			return node;
		}else {

			Node parentNode = node.parent;
			while(parentNode != null) {
				if(parentNode.value > node.value) return parentNode;
				parentNode = parentNode.parent;
			}
			return parentNode;
		}
	}

}
