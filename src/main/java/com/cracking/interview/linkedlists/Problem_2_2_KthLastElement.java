package com.cracking.interview.linkedlists;

import com.cracking.interview.linkedlists.MyLinkedList.Node;

public class Problem_2_2_KthLastElement {

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
		
		int k = 4;
		int value = findKthLastElement(head, k);
		System.out.println(value);
	}

	private static int findKthLastElement(Node head, int k) {
		Node dummy = new Node(0); //if the kth element is the head node, that is why the dummy node is needed.
		dummy.next = head;
		
		Node slowPointer = dummy;
		Node fastPointer = dummy;
		
		while(fastPointer.next != null) {
			if(k <= 1) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}else {
				fastPointer = fastPointer.next;
				k--;
			}
		}
		return slowPointer.val;
	}

}
