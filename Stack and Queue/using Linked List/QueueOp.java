package com.operative.stackqueue2;

public class QueueOp {
	Node front = null, rear = null;
	
	boolean isEmpty() {
		if(front == null)
			return true;
		else
			return false;
	}
	
	@SuppressWarnings("unused")
	boolean isFull() {
		Node temp = new Node();
		if(temp == null)
			return true;
		else
			return false;
	}
	
	void enQueue(int data) {
		Node temp = new Node();
		temp.data = data;
		
		if(front == null) {
			front = temp;
			rear = temp;
			front.next = null;
		}
		else {
			rear.next = temp;
			rear = temp;
			rear.next = null;
		}
	}
	
	int deQueue() {
		int data = front.data;
		front = front.next;
		return data;
	}
	
	void printQueue() {
		if(isEmpty())
			System.out.println("Queue is empty");
		else {
			Node p = front;
			System.out.println("\n");
			while(p != null) {
				System.out.print("\t" + p.data);
				p = p.next;
			}
		}
		System.out.println("\n");	
	}
}
