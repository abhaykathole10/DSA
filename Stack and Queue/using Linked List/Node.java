package com.operative.stackqueue2;

public class Node {
	
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
