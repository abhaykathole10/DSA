package com.operative.java;

import java.util.Scanner;

public class Employee {
	
	static String userName;
	static String password;
	int age;
	
	static int choice;
	static Scanner scanner = new Scanner(System.in);
	
	static int totalCustomer=0;
	static Employee[] customer = new Employee[5];

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		Employee.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Employee.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private static int login(String userName2, String password2) {
		// TODO Auto-generated method stub
		for(int i=0; i<totalCustomer; i++) {
			if(customer[i].getUserName().equals(userName2) && customer[i].getPassword().equals(password2)) {
				return i;
			}
		}
		return -1;
	}

	private static void registration() {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		
		System.out.println("Enter username: ");
		e.setUserName(scanner.next());
		
		System.out.println("Enter password: ");
		e.setPassword(scanner.next());
		
		System.out.println("Enter age: ");
		e.setAge(scanner.nextInt());
		
		customer[totalCustomer] = e;
		
		totalCustomer++;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + userName + ", age=" + age + "]";
	}

	public static void main(String[] args)
	{
		
	    do {
	        System.out.println("**********************************");
	        System.out.println("\tEnter 1: Register");
	        System.out.println("\tEnter 2: Login");
	        System.out.println("\tEnter 3: Display");
	        System.out.println("\tEnter 4: Exit");
	        System.out.println("**********************************");

	        choice = scanner.nextInt();
	        switch(choice)
	        {
	            case 1:
	                registration();
	                break;
	            case 2:
	                System.out.print("\t Enter username: ");
	                userName = scanner.next();
	                System.out.print("\t Enter password: ");
	                password = scanner.next();
	                if(login(userName,password)!=-1)
	                {
	                    System.out.println("Login successfull");
	                    System.out.println("age of customer is: "+customer[login(userName,password)].getAge());
	                }
	                else
	                    System.out.println("Invalid username or password");
	                break;
	            case 3:
	                for(int i=0;i<totalCustomer;i++)
	                {
	                    System.out.println(customer[i].getUserName() + customer[i].getAge());
	                    System.out.println("----------------------------");
	                }
	                break;
	            case 4:
	                System.out.println("thanks for your time");
	                break;

	            default:
	                System.out.println("wrong choice");
	        }

	    }while(choice!=4);
	    System.out.println("================================================");

	}

}
