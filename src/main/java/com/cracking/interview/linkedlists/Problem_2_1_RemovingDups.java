package com.cracking.interview.linkedlists;

import java.util.HashSet;
import java.util.Set;

import com.cracking.interview.linkedlists.MyLinkedList.Node;

public class Problem_2_1_RemovingDups {

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
		list.addNode(5);

		Node head = list.head;

		//removeDuplicates(head);
		removeDuplicatesWithoutSpace(head);

		list.printList();
	}

	//Using a HashSet takes use of O(N) space and execution is done in O(N) time
	private static void removeDuplicates(Node head) {
		Set<Integer> set = new HashSet<>();
		Node node = head;
		Node prev = null;

		while(node != null) {
			if(set.contains(node.val)) {
				node = node.next;
				prev.next = node;
			}else {
				set.add(node.val);
				prev = node;
				node = node.next;
			}
		}
	}
	
	//Using 2 pointers we can solve the problem in O(1) space but execution is done in O(N^2) time
	private static void removeDuplicatesWithoutSpace(Node head) {
		Node slowPointer = head;
		
		while(slowPointer != null) {
			Node fastPointer = slowPointer;
			
			while(fastPointer.next != null) {
				if(fastPointer.next.val == slowPointer.val) {
					fastPointer.next = fastPointer.next.next;
				}else {
					fastPointer = fastPointer.next;
				}
			}
			slowPointer = slowPointer.next;
		}
	}

}
