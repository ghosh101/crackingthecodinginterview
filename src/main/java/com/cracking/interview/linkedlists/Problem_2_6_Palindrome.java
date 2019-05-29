package com.cracking.interview.linkedlists;

import java.util.Stack;

import com.cracking.interview.linkedlists.MyLinkedList.Node;

public class Problem_2_6_Palindrome {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(1);
		list.addNode(3);
		list.addNode(5);
		list.addNode(8);
		list.addNode(8);
		list.addNode(5);
		list.addNode(3);
		list.addNode(1);

		Node head = list.head;

		boolean check = checkPalindromeWithStack(head);
		System.out.println(check);
	}
	
	//Space: O(N), Time: O(N)
	private static boolean checkPalindromeWithStack(Node head) {
		Node node = head;
		Stack<Integer> stack = new Stack<>();
		
		while(node != null) {
			stack.push(node.val);
			node = node.next;
		}
		
		node = head;
		while(node != null) {
			if(stack.pop() != node.val) return false;
			node = node.next;
		}
		
		return true;
	}

	//Space: O(1), Time: O(N)
	//we reverse only the 2nd half of the linkedlist and then compare it with the first half
	private static boolean checkPalindrome(Node head) {
		Node node = head;
		int len = 0;
		
		while(node != null) {
			node = node.next;
			len++;
		}

		int mid = len / 2;
		int count = mid;

		Node prev = null;
		Node temp = null;
		node = head;
		
		while(count > 0) {
			prev = node;
			node = node.next;
			count--;
		}
		
		if(len % 2 != 0) node = node.next; //for a list with odd number of elements, we can ignore the middle element
		
		prev.next = null;
		prev = null;
		
		while(node != null) { //reversing the nodes after the mid
			temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}

		while(prev != null) {
			if(prev.val != head.val) return false;
			head = head.next;
			prev = prev.next;
		}

		return true;
	}

}
