package com.cracking.interview.treesgraphs;

import java.util.HashSet;
import java.util.LinkedHashSet;

import com.cracking.interview.treesgraphs.Tree.Node;

public class Problem_4_12_PathsWithSum {
	
	static int count = 0;

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.left.left = new Node(3);
		tree.root.left.left.left = new Node(3);
		tree.root.left.left.right = new Node(-2);
		tree.root.left.right = new Node(2);
		tree.root.left.right.right = new Node(1);
		tree.root.right = new Node(-3);
		tree.root.right.right = new Node(11);
		
		int targetSum = 0;
		//findPaths(tree.root, value);
		countPathSums(tree.root, new LinkedHashSet<>(), targetSum, 0);
		System.out.println(count);
	}
	
	
	//Space: O(logN) as we store only elements as per depth of the tree, Time: O(N) as we need to visit all nodes
	private static void countPathSums(Node node, LinkedHashSet<Integer> set, int targetSum, int sum) {
		if(node == null) return;
		
		sum = sum + node.value;
		
		if(node.value == targetSum) count++;
		else if(sum == targetSum) count++;
		else if(set.contains(sum - targetSum)) count++;
		
		set.add(sum);
		
		countPathSums(node.left, set, targetSum, sum);
		if(node.left != null) {
			set.remove(sum + node.left.value);
		}
		
		countPathSums(node.right, set, targetSum, sum);
		if(node.right != null) {
			set.remove(sum + node.right.value);
		}
	}
	
	
	//Space: O(NlogN) as for each node we are finding the path with sum, Time: O(NlogN) as for each node, we traverse the sub-tree of the node.
	private static void findPaths(Node root, int value) {
		if(root == null) return;
		
		countSumPaths(root, value, 0);
		findPaths(root.left, value);
		findPaths(root.right, value);
	}

	private static void countSumPaths(Node root, int value, int sum) {
		if(root == null) return;
		
		sum = sum + root.value;
		if(sum == value) count++;
		
		countSumPaths(root.left, value, sum);
		countSumPaths(root.right, value, sum);
	}

}
