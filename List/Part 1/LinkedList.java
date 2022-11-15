package com.operative.linkedlist;

import java.util.Scanner;

class Node{
	public int data;
	public Node next = null;
	
	Node(){
		System.out.println("New node created");
	}

	public void finalize(){
		System.out.println("Node deleted");
    }
	
}

public class LinkedList {
	
	static Scanner sc = new Scanner(System.in);
	
		Node createLL(Node head) {
			Node p;
			
			if(head==null){
				head = new Node();
				System.out.print("Enter data: ");
				head.data = sc.nextInt();
				head.next = null;
			}
			else {
				p=head;
				while(p.next!=null) {
					p = p.next;
				}
				p.next = new Node();
				p = p.next;
				System.out.print("Enter data: ");
				p.data = sc.nextInt();
				p.next = null;
			}
			return head;
		}
			
		void displayLL(Node head) {
			System.out.print("Linked list: ");
			while(head!=null) {
				System.out.print(" " + head.data);
				head = head.next;
			}
			
		}
		
		Node insertFirst(Node head) {
			Node p = head;			
			head = new Node();
			System.out.print("Enter data: ");			
			
			head.data = sc.nextInt();
			head.next = p;
			return head;
		}
		
		int insertMiddle(Node head) {
			Node p = head, temp, q=null;
			int pos=0,length=0;
//			LinkedList llMain = new LinkedList();
			
			System.out.print("Enter position: ");
			pos = sc.nextInt();
			length = getLength(head);
			
			//Checking if position exists- 
			if(pos > length || pos==0) {
				System.out.println("Invalid, enter value between 1 - " + length);
				return 0;
			}
			else {
				p = head;
				for(int i=1; i<pos; i++) {
					q = p;
					p = p.next;
				}
				
				temp = new Node();
				System.out.print("Enter data: ");
				temp.data = sc.nextInt();
				
				temp.next = q.next;
				q.next = temp;
			}
			return 1;
			
		}
		
		Node deleteFirst(Node head) {
			Node p = head;
	        head = head.next;
	        p = null;
	        System.gc();
	        System.out.println("First element deleted Successfully!");
	        return head;
		}
		
		void deleteLast(Node head) {
			Node p = head;
			while(head.next != null) {
				p = head;
				head = head.next;
			}
			head = null;
			System.gc();
			System.out.println("Last element deleted Successfully!");
			p.next = null;
		}
		
		void deleteMiddle(Node head) {
			Node p = head, temp, q=null;
			int pos=0,length=0;
//			LinkedList llMain = new LinkedList();
			
			System.out.print("Enter position: ");
			pos = sc.nextInt();
			length = getLength(head);
			
			if(pos > length || pos==0) {
				System.out.println("Invalid, enter value between 1 - " + length);
			}
			else {
				p = head;
				for(int i=1; i<pos; i++) {
					q = p;
					p = p.next;
				}
				temp = p;
				p = p.next;
				
				temp = null;
				System.gc();
				System.out.println("Element at " + pos + " deleted Successfully!");
				
				q.next = p;
			}
			
		}
		
		static int getLength(Node head) {
			int length = 0;
			
			while(head != null) {
				length++;
				head = head.next;
			}
			return length;
		}

	    public static void main(String[] args)
	    {
	        int choice;
	        Node head = null;
	    
	        LinkedList llBasic = new LinkedList();
	        do
	        {
	            System.out.println("\n\tEnter 1 : insert data");
	            System.out.println("\tEnter 2 : Display");
	            System.out.println("\tEnter 3 : insert at First");
	            System.out.println("\tEnter 4 : insert in middle");
	            System.out.println("\tEnter 5 : delete at First");
	            System.out.println("\tEnter 6 : delete in last");
	            System.out.println("\tEnter 7 : delete as per given position");
	            
	            System.out.println("\tEnter 11 : Check linked list is Empty or not");
	            
	            System.out.println("\tEnter 9 : Exit");
	            
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            switch(choice)
	            {
	                case 1:
	                    head = llBasic.createLL(head);
	                    break;
	                case 2:
	                    llBasic.displayLL(head);
	                    break;
	                case 3:
	                    head = llBasic.insertFirst(head);
	                    break;
	                case 4:
	                    if(llBasic.insertMiddle(head)==1)
	                        System.out.println("Data inserted successfully");
	                    break;
	                case 5:
	                    head = llBasic.deleteFirst(head);
	                    break;
	                case 6:
	                    llBasic.deleteLast(head);
	                    break;
	                case 7:
	                    llBasic.deleteMiddle(head);
	                    break;
	                case 9:
	                    System.out.println("Thanks for your time");
	                    break;
	                    
	                    ///////////////////////
	                    
	                case 11:
	                	if(llBasic.isEmpty(head)) {
	                		System.out.println("Yes, Linked list is empty");
			        	}
			        	else
			        		System.out.println("No, Linked list is not empty");
	                	break;
                	
	            }

	        }while(choice !=9);
	    }

		private boolean isEmpty(Node head) {
//			LinkedList llMain = new LinkedList();
			if(getLength(head) == 0) {
				return true;
			}
			else
				return false;
		}

}


