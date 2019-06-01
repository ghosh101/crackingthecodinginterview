package com.cracking.interview.treesgraphs;

import com.cracking.interview.treesgraphs.Tree.Node;

public class Problem_4_5_ValidateBST {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(30);
		tree.root.left = new Node(15);
		tree.root.left.left = new Node(10);
		tree.root.left.right = new Node(20);
		tree.root.right = new Node(50);
		tree.root.right.left = new Node(45);
		tree.root.right.right = new Node(60);
		
		boolean check = validateBST(tree.root);
		System.out.println(check);
	}

	//DFS Solution.
	//Space: O(logN) as we do recursions on N/2 tree branches. Time: O(N), as we cover all tree nodes
	private static boolean validateBST(Node node) {
		
		int lRange = Integer.MIN_VALUE;
		int rRange = Integer.MAX_VALUE;
		
		boolean chk = validate(node, lRange, rRange);
		return chk;
	}

	private static boolean validate(Node node, int lRange, int rRange) {
		if(node == null) return true;
		
		if(node.value >= lRange && node.value < rRange) {}
		else return false;
		
		return(validate(node.left, lRange, node.value) && validate(node.right, node.value, rRange));
	}

}
