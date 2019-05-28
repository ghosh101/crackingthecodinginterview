package com.cracking.interview.linkedlists;

import com.cracking.interview.linkedlists.MyLinkedList.Node;

public class Problem_2_4_Partition {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(32);
		list.addNode(3);
		list.addNode(5);
		list.addNode(8);
		list.addNode(5);
		list.addNode(10);
		list.addNode(2);
		list.addNode(1);

		Node head = list.head;
		
		int value = 5;
		Node node = partition(head, value);

		MyLinkedList.printList(node);
	}

	//Space: O(1), Time: O(N)
	private static Node partition(Node head, int val) {
		Node node = head;
		Node temp = null;
		
		Node head_lesser = null;
		Node prev_lesser = null;
		
		Node head_greater = null;
		Node prev_greater = null;
		
		while(node != null) {
			if(node.val < val) {
				if(head_lesser == null) {
					head_lesser = new Node(node.val);
					prev_lesser = head_lesser;
				}
				else {
					temp = new Node(node.val);
					prev_lesser.next = temp;
					prev_lesser = prev_lesser.next;
				}
			}else {
				if(head_greater == null) {
					head_greater = new Node(node.val);
					prev_greater = head_greater;
				}else {
					temp = new Node(node.val);
					prev_greater.next = temp;
					prev_greater = prev_greater.next;
				}
			}
			node = node.next;
		}
		prev_lesser.next = head_greater;
		return head_lesser;
	}

}
