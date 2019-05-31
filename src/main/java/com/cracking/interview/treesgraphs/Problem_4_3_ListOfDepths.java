package com.cracking.interview.treesgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.cracking.interview.treesgraphs.Tree.Node;

public class Problem_4_3_ListOfDepths {

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = new Node(54);
		tree.root.left = new Node(70);
		tree.root.left.left = new Node(80);
		tree.root.left.right = new Node(89);
		tree.root.right = new Node(23);
		tree.root.right.right = new Node(60);

		//createListOfDepths(tree.root);
		createListOfDepthsRecursion(tree.root);
	}
	
	//Using DFS
	//Space: O(N). Even though there are O(logN) recursions, each using its own stack. But, the data returned is O(N). 
	//Time: O(N), as we are traversing all the tree elements
	private static List<LinkedList<Node>> createListOfDepthsRecursion(Node root) {
		List<LinkedList<Node>> resultList = new ArrayList<>();
		int depth = 0;
		
		createList(resultList, root, depth);
		return resultList;
	}

	private static void createList(List<LinkedList<Node>> resultList, Node node, int depth) {
		if(node == null) return;
		
		if(resultList.size() != 0 && depth < resultList.size()) {
			resultList.get(depth).add(node);
		}else {
			LinkedList<Node> list = new LinkedList<>();
			list.add(node);
			resultList.add(list);
		}
		
		createList(resultList, node.left, depth+1);
		createList(resultList, node.right, depth+1);
	}


	//Using BFS.
	//Space: O(N), as we are using a queue. Time: O(N), as we are traversing all the tree elements
	private static List<LinkedList<Node>> createListOfDepths(Node root) {
		List<LinkedList<Node>> resultlist = new ArrayList<>();

		Queue<Node> queue = new LinkedList<>();
		
		LinkedList<Node> newList = new LinkedList<>();
		newList.add(root);
		resultlist.add(newList);

		for(int i=0; i < resultlist.size(); i++) {
			List<Node> list = resultlist.get(i);
			
			for(Node node: list) {
				queue.add(node);
			}
			
			newList = new LinkedList<>();
			while(!queue.isEmpty()) {
				root = queue.poll();

				if(root.left != null) {
					newList.add(root.left);
				}

				if(root.right != null) {
					newList.add(root.right);
				}
			}
			if(newList != null && newList.size() != 0) resultlist.add(newList);
		}
		return resultlist;
	}

}