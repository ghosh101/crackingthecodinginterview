package com.cracking.interview.treesgraphs;

public class Tree {
	
	Node root;
	
	static class Node{
		int value;
		Node left;
		Node right;
		Node parent;
		
		Node(int value){
			this.value = value;
		}
	}

}
