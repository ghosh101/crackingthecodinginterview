package com.cracking.interview.treesgraphs;

import com.cracking.interview.treesgraphs.Tree.Node;

public class Problem_4_8_FirstCommonAncestor {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(3);
		tree.root.left = new Node(5);
		tree.root.left.left = new Node(6);
		tree.root.left.right = new Node(2);
		tree.root.left.right.left = new Node(7);
		tree.root.left.right.right = new Node(4);
		tree.root.right = new Node(1);
		tree.root.right.left = new Node(0);
		tree.root.right.right = new Node(8);
		
		Node p = tree.root;
		Node q = tree.root.right.right;
		
		Node lcaNode = findCommonAncestor(p, q	, tree.root);
		System.out.println(lcaNode.value);
	}

	//Space: O(logN) as we recursing over a binary tree, Time: O(N) as we might need to traverse all nodes of the tree
	private static Node findCommonAncestor(Node p, Node q, Node node) {
		if(node == null) return null;
		
		if(node == p || node == q) return node;
		
		Node node1 = findCommonAncestor(p, q, node.left);
		Node node2 = findCommonAncestor(p, q, node.right);
		
		if(node1 != null && node2 != null) return node;
		if(node1 != null) return node1;
		if(node2 != null) return node2;
		
		return null;
	}

}
