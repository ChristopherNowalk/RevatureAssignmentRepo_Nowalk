package dev.nowalk.models;

public class Account {
	//fields for our account object, may add more when needed
	private int id;
	private String type;
	private double balance;
	private int userId;
	
	//no args constructor
	public Account() {
		super();
	}
	
	//all args constructor
	public Account(int id, String type, double balance, int userId) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.userId = userId;
	}
	
	//id less constructor if we need it
	public Account(String type, double balance, int userId) {
		super();
		this.type = type;
		this.balance = balance;
		this.userId = userId;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//overridden toString method
	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", balance=" + balance + ", userId=]" + userId + "]";
	}
	
	
}
