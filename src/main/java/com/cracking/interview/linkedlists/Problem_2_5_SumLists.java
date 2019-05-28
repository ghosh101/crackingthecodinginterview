package com.cracking.interview.linkedlists;

import com.cracking.interview.linkedlists.MyLinkedList.Node;

public class Problem_2_5_SumLists {

	public static void main(String[] args) {
		MyLinkedList list1 = new MyLinkedList();
		list1.addNode(7);
		list1.addNode(1);
		list1.addNode(6);
		list1.addNode(9);
		
		MyLinkedList list2 = new MyLinkedList();
		list2.addNode(5);
		list2.addNode(9);
		list2.addNode(4);

		Node head1 = list1.head;
		Node head2 = list2.head;
		
		Node sum = sumLists(head1, head2);
		MyLinkedList.printList(sum);
	}

	//Space: O(1), Time: O(N), where N is the length of the longer linked list
	private static Node sumLists(Node head1, Node head2) {
		Node sumHead = null; //to refer the head of the result list
		Node prev = null; //to iterate through the list with prev.next
		Node temp = null; //the value to stored in the next element of the prev node
		
		int sum = 0;
		int carry = 0;
		int val1;
		int val2;
		while(head1 != null || head2 != null) {
			val1 = 0;
			val2 = 0;
			
			if(head1 != null) {
				val1 = head1.val;
				head1 = head1.next;
			}
			
			if(head2 != null) {
				val2 = head2.val;
				head2 = head2.next;
			}
			
			sum = val1 + val2 + carry;
			if(sum >= 10) {
				sum = sum - 10;
				carry = 1;
			}else {
				carry = 0;
			}
			
			if(sumHead == null) {
				sumHead = new Node(sum);
				prev = sumHead;
			}else {
				temp = new Node(sum);
				prev.next = temp;
				prev = prev.next;
			}
		}
		if(carry == 1) {
			temp = new Node(carry);
			prev.next = temp;
		}
		
		return sumHead;
	}
}
