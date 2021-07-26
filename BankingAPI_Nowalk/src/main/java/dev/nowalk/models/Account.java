package dev.nowalk.models;

public class Account {
	//fields for our account object, may add more when needed
	private int a_id;
	private String type;
	private double balance;
	private int user_Id;
	
	//no args constructor
	public Account() {
		super();
	}
	
	//all args constructor
	public Account(int id, String type, double balance, int userId) {
		super();
		this.a_id = id;
		this.type = type;
		this.balance = balance;
		this.user_Id = userId;
	}
	
	//id less constructor if we need it
//	public Account(String type, double balance, int userId) {
//		super();
//		this.type = type;
//		this.balance = balance;
//		this.userId = userId;
//	}
	
	//getters and setters
	public int getId() {
		return a_id;
	}
	
	public void setId(int id) {
		this.a_id = id;
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
		return user_Id;
	}
	
	public void setUserId(int userId) {
		this.user_Id = userId;
	}
	
	//overridden toString method
	@Override
	public String toString() {
		return "Account [id=" + a_id + ", type=" + type + ", balance=" + balance + ", user_Id=]" + user_Id + "]";
	}
	
	
}
