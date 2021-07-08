package dev.nowalk.util;

import java.util.HashMap;
import java.util.Map;
//import java.util.Set;

import dev.nowalk.models.Account;
import dev.nowalk.models.User;

//this will serve as our testing 'database' to make sure all of our layers communicate with each other properly before transferring 
//everything over to a real database.
public class FakeDB {
	
	//our users map will have an integer as the key (the users id) and the user obj will be the value
	public static Map<Integer, User> users = new HashMap<Integer, User>();
	//now we will make a map to hold all of our accounts
	//each account should have a reference to the user using that account
	public static Map<Integer, Account> accounts = new HashMap<Integer, Account>();
	//this is a simple way to set our id's
	public static int idCount = 1;
	public static int accountIdCount = 1;
	//this static block is an initializer, the first time this is referenced then
	static {
		User u1 = new User(1, "Peter Parker", 2);
		User u2 = new User(2, "Thor Odinson", 2);
		User u3 = new User(3, "Steve Rodgers", 2);
		User u4 = new User(4, "Tony Stark", 2);
		
		Account a1 = new Account(1, "Savings", 4000, u1.getId());
		Account a2 = new Account(2, "Checking", 400, u1.getId());
		Account a3 = new Account(3, "Savings", 2000, u2.getId());
		Account a4 = new Account(4, "Checking", 200, u2.getId());
		Account a5 = new Account(5, "Savings", 300, u3.getId());
		Account a6 = new Account(6, "Checking", 20, u3.getId());
		Account a7 = new Account(7, "Savings", 5000, u4.getId());
		Account a8 = new Account(8, "Checking", 1000, u4.getId());
		
		//adding all of the accounts to users
//		u1.setAccount(a1);
//		u1.setAccount(a2);
//		u2.setAccount(a3);
//		u2.setAccount(a4);
//		u3.setAccount(a5);
//		u3.setAccount(a6);
//		u4.setAccount(a7);
//		u4.setAccount(a8);
		
		//.put is the way you add things to a map with the key and value as parameters
		users.put(idCount++, u1);
		users.put(idCount++, u2);
		users.put(idCount++, u3);
		users.put(idCount++, u4);
		
		//all of these accounts are for testing purposes
		accounts.put(accountIdCount++, a1);
		accounts.put(accountIdCount++, a2);
		accounts.put(accountIdCount++, a3);
		accounts.put(accountIdCount++, a4);
		accounts.put(accountIdCount++, a5);
		accounts.put(accountIdCount++, a6);
		accounts.put(accountIdCount++, a7);
		accounts.put(accountIdCount++, a8);
		
		
		
	}
	
}
