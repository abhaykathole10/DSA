package com.operative.bank;

public abstract class Employee {
	private String username;
	private String password;
	private int age;
	
	public double balance;
	
	public abstract double getBalance();

	public String getUsername() {
		return username;
	}

	final void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	final void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + ", age=" + age + "]";
	}
	
	
}

