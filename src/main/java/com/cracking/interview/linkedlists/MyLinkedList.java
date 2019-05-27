package com.cracking.interview.linkedlists;

public class MyLinkedList {

	class Node{
		int val;
		Node next;
		
		Node(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	Node head;
	
	public void addNode(int value){
		Node newNode = new Node(value);
		
		if(head == null) head = newNode;
		else {
			Node node = head;
			while(node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		}
	}
	
	public void printList() {
		while(head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.print("NULL");
	}
}