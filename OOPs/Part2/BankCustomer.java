package com.operative.bank;

import java.util.Random;

//Inheritance(Multiple)
public class BankCustomer extends Employee implements ForgotPassword{

	private int accountNumber;
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Override
	public int getOtp() {

//		Random rnd = new Random();
//		int n = 1000 + rnd.nextInt(10000);
//		return n;
		//return (int) (Math.floor(1000 + Math.random() * 9999));
		
		return (int) ((Math.random() * (9999 - 1000)) + 1000);
		
//		Random random = new Random();
//		return random.nextInt(9999 - 1000) + 1000;
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}
	
	//Overloading(Polymorphism)
	public void transaction(double amount) {
		this.balance = this.balance + amount;
	}
	
	public void transaction(double amount, BankCustomer obj) {
		this.balance = this.balance - amount;
		obj.balance = obj.balance + amount;
	}
	
}
