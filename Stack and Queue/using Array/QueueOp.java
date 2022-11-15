package com.operative.stackqueue;

public class QueueOp {
	final int size = 5;
	int[] queue = new int[size];
	int front = -1, rear = -1;
	
	boolean isEmpty() {
		if(rear == -1)
			return true;
		return false;
	}
	
	boolean isFull() {
		if(rear == size-1) 
			return true;
		return false;
	}
	
	void enQueue(int data) {
		if(front == -1)
			front = 0;
		queue[++rear] = data;
	}
	
	int deQueue() {
	  int data = queue[front];

      if (front >= rear) {
        front = -1;
        rear = -1;
        System.gc();
      }
      else {
        front++;
      }
      System.out.println( data + " Deleted");
      return (data);
    }
	  
	void printQueue() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}
		else {
			for(int i=front; i<=rear; i++) {
				System.out.print("\t" + queue[i]);
			}
			System.out.println("\n");
		}
	}
}
