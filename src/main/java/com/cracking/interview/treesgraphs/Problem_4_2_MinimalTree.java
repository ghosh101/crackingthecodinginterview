package com.cracking.interview.treesgraphs;

import com.cracking.interview.treesgraphs.Tree.Node;

public class Problem_4_2_MinimalTree {

	public static void main(String[] args) {

		int[] arr = {10,20,30,40,50,60,70};

		createMinimalTree(arr);
		createMinimalTreeRecursion(arr);
	}

	//Space: O(N) because of recursion, Time: O(N)
	private static Node createMinimalTreeRecursion(int[] arr) {
		Node root = null;
		
		root = createTree(arr, root, 0, arr.length - 1);
		return root;
	}

	private static Node createTree(int[] arr, Node node, int l, int r) {
		if(l > r) return null;
		
		int mid = l + (r-l)/2;
		
		node = new Node(arr[mid]);
		
		node.left = createTree(arr, node, l, mid-1);
		node.right = createTree(arr, node, mid+1, r);
		
		return node;
	}

	
	private static Node createMinimalTree(int[] arr) {

		int len = arr.length;
		int mid = len/2;

		Node root = new Node(arr[mid]);
		Node node = root;

		for(int i = 0; i<arr.length; i++) {
			if(i == mid) {
				node = root;
			}
			else if(arr[i] < node.value) {
				node.left = new Node(arr[i]);
				node = node.left;
			}else {
				node.right = new Node(arr[i]);
				node = node.right;
			}
		}

		return root;
	}

}
