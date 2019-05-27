package com.cracking.interview.linkedlists;

import com.cracking.interview.linkedlists.MyLinkedList.Node;

public class Problem_1_3_DeleteMiddleNode {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(1);
		list.addNode(1);
		list.addNode(2);
		list.addNode(13);
		list.addNode(7);
		list.addNode(3);
		list.addNode(5);
		list.addNode(2);
		list.addNode(8);

		Node node = list.getNode(7);
		
		deleteMiddleNode(node);
	}

	//this solution is not possible if the given node is the last node
	private static void deleteMiddleNode(Node node) {
		Node next = node.next;
		node.val = next.val;
		node.next = next.next;
		
		return;
	}

}
