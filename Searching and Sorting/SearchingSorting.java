package com.operative.searchsort;

import java.util.Scanner;

public class SearchingSorting {
	
	//Create an array
	
	int[] createArray(int[] arr, int len) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<len; i++) {
			System.out.print("Enter element: ");
			arr[i] = sc.nextInt();
		}
		return arr;
	}
	
	//Display the array
	
	void display(int[] arr, int len) {
		for(int i=0; i<len; i++) {
			System.out.print("\t" + arr[i]);
		}
	}
	
	//LINEAR SEARCH
	
	int linearSearch(int[] arr, int len, int key) {
		for(int i=0; i<len; i++) {
			if(arr[i] == key)
				return i;
		}
		return -1;
	}
	
	//BINARY SEARCH
	
	int binarySearch(int[] arr, int len, int key) {
		int first=0, last=arr.length-1;
		
        while(first<=last) {
        	
            int mid=first+(last-first)/2;
            
            if(arr[mid]<key) {
                first=mid+1;
            }
            else if(arr[mid]==key) {
                return mid;
            }
            else {
                last=mid-1;
            }
        }
        return -1;

	}
	
	//Order to follow while sorting
	int orderMenu() {
		System.out.println("1. Ascending\n2. Descending");
		System.out.print("Enter your choice: ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		return choice;
	}
	
	//BUBBLE SORT(Comparing with neighbour element)
	
	void bubbleSort(int[] arr, int len, int order) {
		int flag = 0;
		
		for(int i = 0; i<len-1; i++) {
			for(int j=0; j<len-i-1; j++) {
				
				if(order == 1) {
					
					//Checking if adjacent element is smaller
					if(arr[j] > arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						
						//setting flag "1"
						flag = 1;
					}
				}
				else {
					
					//Checking if adjacent element is larger
					if(arr[j] < arr[j+1]) {
						int temp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = temp;
						
						//setting flag "1"
						flag = 1;
					}
				}
				
			}
			
			//Checking if sorting happened or not
			if(flag == 0) {
				System.out.println("Already sorted");
				break;
			}
		}
		
	}
	
	//SELECTION SORT(Comparing selected element with other elements)
	
	void selectionSort(int[] arr, int len, int order) {
		int flag = 0;
	    for(int i = 0; i < len-1 ; i++){
	    	
	    	//Set x to "i"th element
	        int x = i;

	        for(int j = i+1 ; j < len; j++){

	        	//Ascending
	            if(order == 1){
	            	//Checking if there exist any number smaller then current minimum "x"
		            if(arr[j] < arr[x]){
		                x = j;
		                flag = 1;
		            }
	            }
	            
	            //Descending
	            else {
	            	//Checking if there exist any number larger then current maximum "x"
		            if(arr[j] > arr[x]){
		                x = j;
		                flag = 1;
		            }
	            }
	            
	        }
	        
	      //Swap "i"th element with the smallest element in array i.e "x"th
	        int temp = arr[i];
	        arr[i] = arr[x];
	        arr[x] = temp;
	        
	        if(flag == 0) {
	        	System.out.println("Already sorted");
	        	break;
	        }
	    }
	}
	
	//INSERTION SORT(Inserting elements from unsorted to sorted array)
	
	void insertionSort(int arr[], int len, int order) {
		int flag =0;
		
	    for(int i=1 ; i<len ; i++){
	        int value = arr[i];
	        int hole = i;

	      //ascending order
	        if(order == 1) {
	        	
	        	//Shifting logic
		        while(hole > 0 && arr[hole-1] > value){
		            arr[hole] = arr[hole-1];
		            hole--;
		            flag = 1;
		        }
		        
		        arr[hole] = value;
	        }

	      //descending order
	        else {
	        	
	        	//Shifting logic
		        while(hole > 0 && arr[hole-1] < value){
		            arr[hole] = arr[hole-1];
		            hole--;
		            flag = 1;
		        }
		        
		        arr[hole] = value;
	        }
	        
	        if(flag == 0) {
	        	System.out.println("Already sorted");
	        	break;
	        }
	    }
	    
	}
	
	//QUICK SORT
	
	int partitionEle(int[] arr, int start,int end, int order) {
		
		//Setting pivot to rightmost element of the array i.e "end"
	    int pivot = arr[end];

	    //Setting "i" to "start-1" i.e "to nothing"
	    int i = start-1;

	    //Iterating from start to end till the pivot
	    for(int j = start ; j < end ; j++){

	    	if(order == 1) {
	    		//If an element is smaller than pivot
		        if(arr[j] <= pivot){

		            //Step 1: increase "i"
		            i++;

		            //Step 2: Swap the "smaller element" with current "i" i.e the "just incremented i"	            
		            int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;

		        }
	    	}
	    	else {
	    		//If an element is bigger than pivot
		        if(arr[j] >= pivot){

		            //Step 1: increase "i"
		            i++;

		            //Step 2: Swap the "bigger element" with current "i" i.e the "just incremented i"	            
		            int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;

		        }
	    	}
	    }

	    //Step 3: Swap Pivot with the "i + 1 th" element
	    int temp = arr[i+1];
		arr[i+1] = arr[end];
		arr[end] = temp;

	    //Return the next index to "i" i.e "the just swapped"
	    return (i + 1);
	}
	
	void quickSort(int[] arr, int start, int end, int order) {
	    if(start < end){

	        //Partition "pi" will return the point from which the Array will be divided to search further
	        int pi = partitionEle(arr, start, end, order);

	        //Running Quick sort on the left sub-array
	        quickSort(arr, start, pi - 1, order);

	        //Running Quick sort on the right sub-array
	        quickSort(arr, pi + 1, end, order);
	    }

	}
	
}
























