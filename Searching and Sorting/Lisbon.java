package com.operative.searchsort;

import java.util.Scanner;

public class Lisbon {
	public static void main(String[] args)
	{
	    int choice;
	    int size,data, pos;
	    int array[];

	    Scanner scanner = new Scanner(System.in);
	    SearchingSorting ss = new SearchingSorting();
	    System.out.print("Enter the size of array: ");
	    size = scanner.nextInt();
	    array = new int[size];
	    array = ss.createArray(array,size);
	    do {
	        System.out.println("\n**********************************");
	        System.out.println("\tEnter 11: Display Array");
	        System.out.println("\tEnter 1: Linear Search");
	        System.out.println("\tEnter 2: Binary Search");
	        System.out.println("\tEnter 3: Bubble Sort");
	        System.out.println("\tEnter 4: Selection Sort");
	        System.out.println("\tEnter 5: Insertion Sort");
	        System.out.println("\tEnter 6: Quick Sort");

	        System.out.println("\tEnter 9: Exit");
	        System.out.println("**********************************");

	        System.out.print("Enter operation: ");
	        choice = scanner.nextInt();
	        switch(choice)
	        {
	            case 11:
	                ss.display(array,size);
	                break;

	            case 1:
	                System.out.print("Enter data to search in array: ");
	                data = scanner.nextInt();
	                pos = ss.linearSearch(array,size,data);
	                if(pos == -1)
	                    System.out.println("Given element is not present in array");
	                else
	                    System.out.println("Given element is present at position: "+(pos+1));
	                break;
	            case 2:
	                System.out.print("Enter data to search in array: ");
	                data = scanner.nextInt();
	                pos = ss.binarySearch(array,size,data);
	                if(pos == -1)
	                    System.out.println("Given element is not present in array");
	                else
	                    System.out.println("Given element is present at position: "+(pos+1));
	                break;
	            case 3:
	                choice = ss.orderMenu();
	                if(choice !=0)
	                {
	                    ss.bubbleSort(array,size,choice);
	                }
	                break;
	            case 4:
	                choice = ss.orderMenu();
	                if(choice !=0)
	                {
	                    ss.selectionSort(array,size,choice);
	                }
	                break;
	            case 5:
	                choice = ss.orderMenu();
	                if(choice !=0)
	                {
	                    ss.insertionSort(array,size,choice);
	                }
	                break;
	            case 6:
	                choice = ss.orderMenu();
	                if(choice !=0)
	                {
	                    // You are free to change parameters of this
	                    ss.quickSort(array,0,size-1,choice);
	                }           	
	                break;
	            case 9:
	                System.out.println("thanks for your time");
	                break;

	            default:
	                System.out.println("wrong choice");
	        }

	    }while(choice!=9);
	    System.out.println("================================================");

	}

}
