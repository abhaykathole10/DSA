package com.operative.stackqueue;

public class StackOp {
	final int size = 5;
	int[] stack = new int[size];
	int top=-1;
	
	boolean isFull() {
		if(top == size-1)
			return true;
		return false;		
	}
	
	boolean isEmpty() {
		if(top == -1) 
			return true;
		return false;
	}
	
	void push(int data) {
		stack[++top] = data;
	}
	
	int pop() {
		return stack[top--];
	}
	
	void printStack() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}
		else {
			for(int i=0; i<=top; i++) {
				System.out.print("\t" + stack[i]);
			}
			System.out.println("\n");
		}
	}
	
}
