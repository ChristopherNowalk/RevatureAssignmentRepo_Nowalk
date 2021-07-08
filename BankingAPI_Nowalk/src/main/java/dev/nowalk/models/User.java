package dev.nowalk.models;

public class User {

	//our fields for the user, may expand these when needed, like an accounts list or map
	private int u_id;
	private String name;
	private int numOfAccounts;;
	
	//no args constructor
	public User() {
		super();
	}
	
	//all args constructor
	public User(int id, String name, int numOfAccounts) {
		super();
		this.u_id = id;
		this.name = name;
		this.numOfAccounts = numOfAccounts;
	}
	//id less constructor, don't know if I will be using this one, but it might be nice to have
	public User(String name, int numOfAccounts) {
		super();
		this.name = name;
		this.numOfAccounts = numOfAccounts;
	}

	//getters and setters
	public int getId() {
		return u_id;
	}

	public void setId(int id) {
		this.u_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumOfAccounts() {
		return numOfAccounts;
	}

	public void setNumOfAccounts(int numOfAccounts) {
		this.numOfAccounts = numOfAccounts;
	}
	
	/*
	public List<Account> getAllAccounts() {
		return accounts;
	}
	
	public Account getAccount(int id) {
		//if we have id's that are a high number above the size of the arraylist, then we cannot use get to get it
		return accounts.get(id);
	}
	
	public void setAccount(Account account) {
		//if the object being passed in already exists in the accounts list, remove it
		if(this.accounts.contains(account)) {
			this.accounts.remove(account);
			//otherwise add that account
		} else {
			this.accounts.add(account);
		}
			
	}
	 */
	//Overridden to string method
	@Override
	public String toString() {
		return "User [id=" + u_id + ", name=" + name + ", numOfAccounts=" + numOfAccounts + "]";
	}
	
		
	
}
