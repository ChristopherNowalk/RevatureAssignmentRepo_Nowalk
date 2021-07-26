package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Account;
import dev.nowalk.models.User;

public interface UserServices {

	//the services associated with users
	
	//we have our basic CRUD operations here as a good practice so each layer can communicate directly above or below it
	//we dont want any skipping of layers
	
	public User getUser(int id);
	
	public List<User> getAllUsers();
	
	public User addUser(User u);
	
	public User updateUser(User change);
	
	public User deleteUser(int id);
	
	//Here we can create and delete accounts from each user
	//I don't want to be able to make a random account that could possibly not be linked to a user, so the user services will have
	//add account/delete account/ money transfer methods that will call the Account services layer
	//public Account addAccountToUser(Account a);
	
	public Account deleteAccountFromUser(int id, int userId);
	
	public Account withdrawFunds(int id, int userId, double amount);
	
	public Account addFunds(int id, int userId, double amount);
	
	public Account transferFunds(int takeId, int putId, int userId, double amount);
	
	public List<Account> getAllAccounts();
	
	public Account getAccountById(int id);
	
	public Account getAccountFromUser(int id ,int userId);
	
	public List<Account> getAllAccountsByUserId(int userId);
	
}
