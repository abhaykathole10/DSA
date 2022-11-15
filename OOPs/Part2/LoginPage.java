package com.operative.bank;

import java.util.Scanner;

public class LoginMain {

	static String userName, password;
	static int age, choice, totalCustomer=0, index, i;
	static double balance;
	static int accountNumber;
	static BankCustomer customer[] = new BankCustomer[10], tempAddress[], tempObj;
	static Scanner scanner = new Scanner(System.in);
	
	static double amount;
	
	public static void main(String[] args)
	{
	    int choice;
	    do {
	        System.out.println("**********************************");
	        System.out.println("\tEnter 1: Register");
	        System.out.println("\tEnter 2: Login");
	        System.out.println("\tEnter 3: Display");
	        System.out.println("\tEnter 4: Forgot password");
	        System.out.println("\tEnter 9: Exit");
	        System.out.println("**********************************");

	        System.out.print("Enter your choice1: ");
	        choice = scanner.nextInt();
	        switch(choice)
	        {
	            case 1:
	                registration();
	                break;
	            case 2:
	                if(totalCustomer==0)
	                {
	                    System.out.println("There are no user enrolled for this APP");
	                }
	                else
	                {
	                    System.out.print("\t Enter username: ");
	                    userName = scanner.next();
	                    System.out.print("\t Enter password: ");
	                    password = scanner.next();
	                    index = login(userName,password);
	                    if(index !=-1)
	                    {
	                    	System.out.println("Login successfull");
	                        bankMenu();
	                    }
	                    else
	                        System.out.println("Invalid username or password");
	                }

	                break;
	            case 3:
	                if(totalCustomer==0)
	                    System.out.println("There is no user enrolled for this APP");
	                else
	                for(int i=0;i<totalCustomer;i++)
	                {
	                    System.out.println(customer[i]);
	                    System.out.println("----------------------------");
	                }
	                break;
	            case 4:
	                System.out.print("\t Enter username: ");
	                userName = scanner.next();
	                getPassword(userName);
	                break;
	            case 9:
	                System.out.println("thanks for your time");
	                break;

	            default:
	                System.out.println("Invalid choice");
	        }

	    }while(choice!=9);
	    System.out.println("================================================");

	}
	
	static void registration() {
		BankCustomer e = new BankCustomer();
		
		System.out.print("\nEnter username: ");
		e.setUsername(scanner.next());
		
		System.out.print("Enter password: ");
		e.setPassword(scanner.next());
		
		System.out.print("Enter age: ");
		e.setAge(scanner.nextInt());
		
		System.out.print("Enter acc no: ");
		e.setAccountNumber(scanner.nextInt());
		
		System.out.print("Enter balance: ");
		e.balance = scanner.nextDouble();
		
		customer[totalCustomer] = e;
		
		totalCustomer++;
	}
	
	static int login(String username2, String password2) {
		for(int i=0; i<totalCustomer; i++) {
			if(customer[i].getUsername().equals(username2) && customer[i].getPassword().equals(password2)) {
				return i;
			}
		}
		return -1;
		
	}
	
	static void getPassword(String username2) {
		tempObj = new BankCustomer();
        for (int j = 0; j < totalCustomer; j++) {
            if (customer[j].getUsername().equals(username2)) {
                int otp = tempObj.getOtp();
                
                System.out.println("OTP is " + otp);
                System.out.print("Please enter OTP : ");
                
                int in = scanner.nextInt();
                if (otp == in) {
                    System.out.println("Your Password is : " + customer[j].getPassword());
                }
                else {
                    System.out.println("Incorrect OTP");
                }
                return;
            }
        }
        System.out.println("\nNo such account exist");
	}
	
	public static void bankMenu() {
		
		do {
			
			System.out.println("**********************************");
	          System.out.println("\tEnter 1: Deposit");
	          System.out.println("\tEnter 2: Withdraw");
	          System.out.println("\tEnter 3: Check Balance");
	          System.out.println("\tEnter 4: Transfer");
	          System.out.println("\tEnter 9: Logout");
	        System.out.println("**********************************");  
	        
	          System.out.print("Enter your choice2: ");
	          choice = scanner.nextInt();
	        
	        switch(choice)
	        {
	            case 1:
	                deposit();
	                break;
	            case 2:
	                withdraw();
	                break;
	            case 3:
	                checkBalance();
	                break;
	            case 4:
	                transfer();
	                break;
	            case 9:
	                System.out.println("\nThank you!");
	                break;    

	            default:
	                System.out.println("\nInvalid choice");
	        }

	    }while(choice!=9);
	    System.out.println("================================================");
		
}

	private static void deposit() {
		System.out.print("Enter amount: ");
        amount = scanner.nextDouble();
        customer[index].transaction(amount);
        System.out.println("\nAmount Deposited");
	}
	private static void withdraw() {
		System.out.print("Enter amount: ");
        amount = scanner.nextDouble();
        customer[index].transaction(-amount);
        System.out.println("\nAmount Withdrawn");
		
	}
	private static void checkBalance() {
		System.out.println("\nBalance is " + customer[index].getBalance());
		
	}
	private static void transfer() {
		System.out.print("\nEnter Receiver's acc no: ");
		accountNumber = scanner.nextInt();
		
		int flag = 0;
		for(int i=0; i<totalCustomer; i++) {
			if(accountNumber == customer[i].getAccountNumber()) {
				System.out.print("Enter amount: ");
				amount = scanner.nextDouble();
				customer[index].transaction(amount, customer[i]);
				System.out.println("\nAmount Transferred");
				flag = 1;
			}
		}
		if(flag==0) {
			System.out.println("Invalid Account");
		}
	}
	
}
