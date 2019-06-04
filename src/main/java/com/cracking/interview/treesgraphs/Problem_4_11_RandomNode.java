package com.cracking.interview.treesgraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.cracking.interview.treesgraphs.BinarySearchTree.Node;

class BinarySearchTree{
	Node root;

	static class Node{
		int value;
		Node left;
		Node right;

		public Node(int value){
			this.value = value;
		}
	}

	public Node find(Node root, int value) {
		Node node = root;
		while(node != null) {
			if(node.value == value) return node;

			if(node.value > value) {
				node = node.left;
			}else {
				node = node.right;
			}
		}
		return null;
	}

	public void insert(int value) {
		if(root == null) {
			root = new Node(value);
			return;
		}

		Node node = root;

		while(node != null) {
			if(node.value > value) {
				if(node.left == null) {
					node.left = new Node(value);
					break;
				}
				node = node.left;
			}else {
				if(node.right == null) {
					node.right = new Node(value);
					break;
				}
				node = node.right;
			}
		}
	}

	public Node delete(Node root, int value) {
		if(root == null) return null;

		if(root.value > value) {
			root.left = delete(root.left, value);
		}
		else if(root.value < value) {
			root.right = delete(root.right, value);
		}
		else {
			if(root.left == null && root.right == null) return null;
			else if(root.left == null || root.right == null) {
				if(root.left == null) return root.right;
				else if(root.right == null) return root.left;
			}else {
				Node node = findInOrderSuccessor(root.right);
				root.value = node.value;

				root.right = delete(root.right, root.value);
			}
		}
		return root;
	}

	private Node findInOrderSuccessor(Node node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public Node getRandomNode() {
		List<Node> list = new ArrayList<>();
		getInOrderTraversal(root, list);
		
		Random generator = new Random();
		int size = list.size();
		int random = generator.nextInt(size);
		
		return(list.get(random));
	}

	private void getInOrderTraversal(Node node, List<Node> list) {
		if(node == null) return;
		
		getInOrderTraversal(node.left, list);
		list.add(node);
		getInOrderTraversal(node.right, list);
	}

}


public class Problem_4_11_RandomNode {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(30);
		bst.insert(15);
		bst.insert(10);
		bst.insert(50);
		bst.insert(45);
		bst.insert(60);
		bst.insert(5);
		bst.insert(0);
		bst.insert(32);
		bst.insert(67);
		bst.insert(21);
		bst.insert(9);
		
		System.out.println(bst.getRandomNode().value);
		System.out.println(bst.getRandomNode().value);
		System.out.println(bst.getRandomNode().value);
		System.out.println(bst.getRandomNode().value);
		System.out.println(bst.getRandomNode().value);

		bst.find(bst.root, 50);
		bst.find(bst.root, 15);

		bst.delete(bst.root, 10);
		bst.delete(bst.root, 30);

		return;
	}

}
