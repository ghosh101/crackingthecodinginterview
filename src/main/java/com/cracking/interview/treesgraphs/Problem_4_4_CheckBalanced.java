package com.cracking.interview.treesgraphs;

import com.cracking.interview.treesgraphs.Tree.Node;

public class Problem_4_4_CheckBalanced {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(54);
		tree.root.left = new Node(70);
		tree.root.left.left = new Node(80);
		tree.root.left.right = new Node(90);
	
		
		boolean isBalanced = false;
		int check = checkBalanced(tree.root);
		if(check == 0) isBalanced = true;
		System.out.println(isBalanced);
	}

	//DFS Solution
	//Space: O(H) as we are recursing to the height of tree at once. Time: O(N), as all elements of tree are traversed
	private static int checkBalanced(Node node) {
		if(node == null) return 0;
		
		int lh = checkBalanced(node.left);
		if(lh == -1) return -1;
		
		int rh = checkBalanced(node.right);
		if(rh == -1) return -1;
		
		if(Math.abs(lh - rh) > 1) return -1;
		return Math.max(lh, rh)+1;
	}

}
