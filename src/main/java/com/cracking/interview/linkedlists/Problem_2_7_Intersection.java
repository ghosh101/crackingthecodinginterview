package com.cracking.interview.linkedlists;

import com.cracking.interview.linkedlists.MyLinkedList.Node;

public class Problem_2_7_Intersection {

	public static void main(String[] args) {
		MyLinkedList list1 = new MyLinkedList();
		list1.addNode(1);
		list1.addNode(2);
		list1.addNode(3);
		list1.addNode(4);
		list1.addNode(5);
		list1.addNode(6);
		
		MyLinkedList list2 = new MyLinkedList();
		list2.addNode(11);
		list2.addNode(10);
		list2.addNode(7);
		list2.addNode(8);
		list2.addNode(9);
		list2.getNode(9).next = list1.getNode(4); //forming the intersection

		Node head1 = list1.head;
		Node head2 = list2.head;
		
		Node intersection = findIntersection(head1, head2);
		if(intersection != null) System.out.println(intersection.val);
	}

	//Space: O(1), Time: O(M+N) as for lists of unequal length we would need to iterate both the linked lists completely
	private static Node findIntersection(Node head1, Node head2) {
		Node node1 = head1;
		Node node2 = head2;
		
		while(node1 != null || node2 != null) {
			
			if(node1 == null) node1 = head2;
			if(node2 == null) node2 = head1;
			
			if(node1 == node2) return node1;
			
			node1 = node1.next;
			node2 = node2.next;
		}
		return null;
	}

}
