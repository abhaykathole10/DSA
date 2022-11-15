package com.operative.linkedlist2;
import java.util.Scanner;

public class LinkedList2 {
	
	//just creating a reference
	Node head;
    static Scanner scanner = new Scanner(System.in);
        
    public void add(int data) {
        if (head == null) {
        	//creating a new node 
            head = new Node();
            head.data = data;
            head.next = null;
        } else {
        	//Reference node 'temp'
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            //creating new node
            temp.next = new Node();
            
            temp = temp.next;
            temp.data = data;
            temp.next = null;
        }
    }
    
    public void displayLL() {
        if (head != null) {
            Node temp = head;
            
            while (temp != null) {
                System.out.print("\t" + temp.data);
                temp = temp.next;
            }
            System.out.println();
        } else {
            System.out.println("List is empty");
        }
    }
    
    public void add(int position, int data) {

    	Node p=head, temp, q = null;
    	int length=size();
    	
    	//If inserting at first
    	if(position==0) {
    		head = new Node();
    		head.data = data;
    		head.next = p;
    		
    		System.out.println("Data Inserted!");
    	}
    	else {
    		if(position>length) {
    			System.out.println("Enter valid position");
    		
    		}
    		else {
    			//Other than first place
    			for(int i=0; i<position; i++) {
    				q = p;
    				p = p.next;
    			}
    			temp = new Node();
    			temp.data = data;
    			q.next = temp;
    			temp.next = p;
    			
    			System.out.println("Data Inserted!");
    		}
    	}
			
        }
      
    public void remove(int position) {
    	
        Node p = head;
        if (position > size()) {
        	System.out.println("Enter valid value");
        }
        
        else if(position == 1) {
          head = head.next;
          p.next = null;
          System.gc();
        }
        
        else {
        	Node temp, q=null;
	    	for(int i=1; i<position; i++) {
				q = p;
				p = p.next;
			}
	    	temp = p;
			p = p.next;
			
			temp = null;
			System.gc();
	
			q.next = p;
        }

    }
    
    public int size() {
        int length = 1;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    
    public boolean isEmpty() {
        if (size() == 0)
            return true;
        return false;
    }
    
    public boolean contains(int data) {
        Node p = head;
        while (p != null) {
            if (p.data == data)
                return true;
            p = p.next;
        }
        return false;
    }
    
    public int indexOf(int data) {
        Node p = head;
        int index = 0;
        while (p != null) {
            if (p.data == data)
                return index;
            index++;
            p = p.next;
        }
        return -1;
    }
    
    public int get(int index) {
        Node p = head;
        
        if(index < size() && index > 0) {
        	for (int i = 0; i < index; i++) {
                p = p.next;
            }
        }
        else {
        	System.out.println("Please enter valid index");
        }
       
        return p.data;
    }
    
    public int set(int index, int data) {
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        int prev = p.data;
        p.data = data;
        return prev;
    }
    
    public int lastIndexOf(int data) {
        Node p = head;
        int index = 0;
        int lastIndex = -1;
        while (p != null) {
            if (p.data == data)
                lastIndex = index;
            index++;
            p = p.next;
        }
        return lastIndex;
    }

}
