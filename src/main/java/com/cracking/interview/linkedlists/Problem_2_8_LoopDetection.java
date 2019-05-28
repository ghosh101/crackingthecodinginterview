package com.cracking.interview.linkedlists;

import java.util.HashSet;
import java.util.Set;

import com.cracking.interview.linkedlists.MyLinkedList.Node;

public class Problem_2_8_LoopDetection {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.addNode(60);
		list.getNode(60).next = list.getNode(50); //forming the circular loop

		Node head = list.head;
		
		Node loop = checkLoop(head);
		if(loop != null) System.out.println(loop.val);
	}
	
	//Space: O(1), Time:O(2N)
	/*The fastpointer & slowpointer intersect within the loop.
	As we analyze, we see that if the loop starts after k elements from head, the fastpointer is always situated k elements from the start of the loop. 
	Hence, we assign the slowpointer to head and increment both the fastpointer and slowpointer by 1.
	This time they intersect at the start of the loop*/
	private static Node checkLoop(Node head) {
		Node fastPointer = head;
		Node slowPointer = head;
		
		while(fastPointer.next != null && fastPointer.next.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			
			if(fastPointer == slowPointer) break;
		}
		
		if(fastPointer.next == null || fastPointer.next.next == null) return null;
		
		slowPointer = head;
		while(slowPointer != fastPointer) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}
		
		return slowPointer;
	}

	//Space: O(N) as we are using a HashSet, Time: O(N)
	private static Node checkLoopWithSpace(Node head) {
		Node node = head;
		Set<Node> set = new HashSet<>();
		
		while(node != null) {
			if(set.contains(node)) return node;
			set.add(node);
			node = node.next;
		}
		return null;
	}
}
