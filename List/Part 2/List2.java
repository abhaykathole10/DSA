package com.operative.linkedlist2;

import java.util.Scanner;

class Node {
    public int data;
    public Node next;
    public Node() {
        System.out.println("New Node Created.");
    }
    @Override
    public void finalize() {
    	System.out.println("Node Deleted.");
    }
}

public class List2 {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args)
	{
	    int choice, data, pos, index;
			System.out.println("this is main");
			LinkedList2 list = new LinkedList2();
			do
			{
			    System.out.println("\tEnter 1 : insert data");
			    System.out.println("\tEnter 2 : Display");
			    System.out.println("\tEnter 3 : insert at First");
			    System.out.println("\tEnter 4 : insert in middle");
			    System.out.println("\tEnter 5 : delete at First");
			    System.out.println("\tEnter 6 : delete in last");
			    System.out.println("\tEnter 7 : delete as per given position");
			    
			    System.out.println("\tEnter 11 : Check linked list is Empty or not");
			    System.out.println("\tEnter 12 : Check specified element exists in the given list or not");
			    System.out.println("\tEnter 13 : Get the index of first occurrence of given element");
			    System.out.println("\tEnter 14 : Get the element at given index");
			    System.out.println("\tEnter 15 : Update the element at the specified index ");
			    System.out.println("\tEnter 16 : Get last index of the occurrence of the specified element");
			    
			    System.out.println("\tEnter 9 : Exit");
			    
			    System.out.print("Enter your choice: ");
			    choice = scanner.nextInt();
			    switch(choice)
			    {
			        case 1:
			            System.out.print("Enter Data: ");
			            data = scanner.nextInt();
			            list.add(data);
			            break;
			        case 2:
			        	System.out.println("\n");
			            list.displayLL();
			            System.out.println("\n ---------------------------");
			            break;
			        case 3:
			            System.out.print("Enter Data: ");
			            data = scanner.nextInt();
			            list.add(0,data);
			            break;
			        case 4:
			        	System.out.print("Enter Data: ");
			            data = scanner.nextInt();
			            System.out.print("Enter position to enter data: ");
			            pos = scanner.nextInt();
			            list.add(pos-1,data);
			            break;
			        case 5:
			            list.remove(1);
			            System.out.println("Data deleted successfully");
			            break;
			        case 6:
			            list.remove(list.size()-1);
			            System.out.println("Data deleted successfully");
			            break;
			        case 7:
			            System.out.print("Enter position: ");
			            pos = scanner.nextInt();
			            list.remove(pos);
			            System.out.println("Element at " + pos + " deleted Successfully!");
			            break;
			        case 11:
			            if(list.isEmpty())
			                System.out.println("List is empty");
			            else
			                System.out.println("List is not empty");
			            break;
			        case 12:
			            System.out.print("Enter Data: ");
			            data = scanner.nextInt();
			            if(list.contains(data))
			                System.out.println(data+ " is present in linked list");
			            else
			                System.out.println(data+ " is not present in linked list");
			            break;
			        case 13:
			            System.out.print("Enter Data: ");
			            data = scanner.nextInt();
			            if(list.indexOf(data) == -1)
			                System.out.println(data+ " is not present in linked list");
			            else
			                System.out.println(data+ " is present in linked list at index: "+list.indexOf(data));
			            break;
			        case 14:
			            System.out.print("Enter Index: ");
			            index = scanner.nextInt();
			            System.out.println("Element present at index: "+index+" is: "+list.get(index));
			            break;
			        case 15:
			            System.out.print("Enter Index: ");
			            index = scanner.nextInt();
			            System.out.print("Enter Data: ");
			            data = scanner.nextInt();
			            data = list.set(index,data);
			            System.out.println("Value updated, Previous Element present at index: "+index+" is: "+data);
			            break;
			        case 16:
			            System.out.print("Enter Data: ");
			            data = scanner.nextInt();
			            if(list.lastIndexOf(data) == -1)
			                System.out.println(data+ " is not present in linked list");
			            else
			                System.out.println(data+ " is present in linked list at index : "+list.lastIndexOf(data));
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
