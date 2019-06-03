package com.cracking.interview.treesgraphs;

import com.cracking.interview.treesgraphs.Tree.Node;

public class Problem_4_10_CheckSubtree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(30);
		tree.root.left = new Node(15);
		tree.root.left.left = new Node(10);
		tree.root.left.right = new Node(20);
		tree.root.right = new Node(50);
		tree.root.right.left = new Node(45);
		tree.root.right.right = new Node(60);
		
		Node t2 = tree.getNode(15, tree.root);
		
		Node t1 = findSubTree(tree.root, t2);
		boolean check = checkSubTree(t1, t2);
		System.out.println(check);
	}

	private static Node findSubTree(Node root1, Node root2) {
		if(root1 == null || root2 == null) return null;
		
		if(root1 == root2) return root1;
		
		Node node = findSubTree(root1.left, root2);
		return node != null ? node : findSubTree(root1.right, root2);
	}
	
	private static boolean checkSubTree(Node t1, Node t2) {
		if(t1 == null && t2 == null) return true;
		else if(t1 == null || t2 == null) return false;
		else if(t1 != t2) return false;
		
		return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
	}

}
