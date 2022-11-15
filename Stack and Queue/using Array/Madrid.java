package com.operative.stackqueue;

import java.util.Scanner;

public class Madrid {
	public static void main(String[] args)
	{
	    int choice,data;
	    Scanner scanner = new Scanner(System.in);
	    StackOp stackOp = new StackOp();
	    QueueOp queueOp = new QueueOp();

	    do
	    {
	    	System.out.println("\nStack Operations:");
	        System.out.println("\tEnter 1 : push");
	        System.out.println("\tEnter 2 : pop");
	        System.out.println("\tEnter 3 : isStackEmpty");
	        System.out.println("\tEnter 4 : isStackFull");
	        System.out.println("\tEnter 5 : printStack");
	        
	        System.out.println("Queue Operations:");
	        System.out.println("\tEnter 11 : enQueue");
	        System.out.println("\tEnter 12 : deQueue");
	        System.out.println("\tEnter 13 : isQueueEmpty");
	        System.out.println("\tEnter 14 : isQueueFull");
	        System.out.println("\tEnter 15 : printQueue");

	        System.out.println("\tEnter 9 : Exit");
	        
	        System.out.print("\nEnter your choice: ");
	        choice = scanner.nextInt();
	        switch(choice)
	        {
	            case 1:
	                if(stackOp.isFull())
	                    System.out.println("Stack is full now, cant insert more element");
	                else
	                {
	                    System.out.print("Enter data to insert in stack: ");
	                    data = scanner.nextInt();
	                    stackOp.push(data);
	                    System.out.println("Data Inserted successfully");
	                }

	                break;
	                
	            case 2:
	                if(stackOp.isEmpty())
	                    System.out.println("Stack is empty now, cant remove an element");
	                else
	                {
	                    data = stackOp.pop();
	                    System.out.println("Data retrieved from stack is: "+data);
	                }
	                break;
	                
	            case 3:
	                if(stackOp.isEmpty())
	                    System.out.println("Stack is empty");
	                else
	                    System.out.println("Stack is not empty");
	                break;
	                
	            case 4:
	                if(stackOp.isFull())
	                    System.out.println("Stack is full");
	                else
	                    System.out.println("Stack is not full");
	                break;
	                
	            case 5: 
	            	System.out.println("\n");
	            	stackOp.printStack(); 
	            	break;
	            	
	            	///////////////////////////////////
	            	
	            case 11:
	                if(queueOp.isFull())
	                    System.out.println("Queue is full now, can't insert more element");
	                else
	                {
	                    System.out.print("Enter data to insert in queue: ");
	                    data = scanner.nextInt();
	                    queueOp.enQueue(data);
	                    System.out.println("Data Inserted successfully");
	                }
	                break;

	            case 12:
	                if(queueOp.isEmpty())
	                    System.out.println("Queue is empty now, cant remove an element");
	                else
	                {
	                    data = queueOp.deQueue();
	                    System.out.println("Data retrieved from Queue is: "+data);
	                }
	                break;
	                
	            case 13:
	                if(queueOp.isEmpty())
	                    System.out.println("Queue is empty");
	                else
	                    System.out.println("Queue is not empty");
	                break;
	                
	            case 14:
	                if(queueOp.isFull())
	                    System.out.println("Queue is full");
	                else
	                    System.out.println("Queue is not full");
	                break;
	                
	            case 15: 
	            	System.out.println("\n");
	            	queueOp.printQueue(); 
            		break;    

	            case 9:
	                System.out.println("Thanks for your time");
	                break;
	                
	            default:
	                System.out.println("Wrong choice");

	        }

	    }while(choice !=9);
	}

}
