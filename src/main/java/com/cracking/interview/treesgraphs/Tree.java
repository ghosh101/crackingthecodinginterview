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
	
	public Node getNode(int value, Node node){
		
		if(node == null) return null;
		if(value == node.value) return node;
		
		Node node1 = getNode(value, node.left);
		node1 = getNode(value, node.right);
		
		return node1;
	}

}
