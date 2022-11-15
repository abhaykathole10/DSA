package com.operative.stackqueue2;

public class StackOp {
	Node top = null;
	
	boolean isEmpty() {
		if(top == null)
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
	
	void push(int data) {
	
		Node temp = new Node();
		temp.data = data;
		
		if(top == null){			
            temp.next = null;
            top = temp;
        }
        else{
            temp.next = top;
            top = temp;
        }
	}
	
	int pop() {
		int data = top.data;
		top = top.next;	
		return data;
	}
	
	void printStack() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}
		else {
			Node p = top;
			System.out.println("\n");
			while(p != null) {
				System.out.print("\t" + p.data);
				p = p.next;
			}
			System.out.println("\n");
		}
	}
	
}
