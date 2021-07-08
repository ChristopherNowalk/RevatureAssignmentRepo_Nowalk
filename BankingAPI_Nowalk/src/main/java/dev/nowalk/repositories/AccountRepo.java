package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.Account;

public interface AccountRepo {
	
	//Where we will declare our CRUD methods
	//Generally Ryan likes to have the methods other than the Read methods to also return the model object in case the client wants to 
	//do one last thing with them before they are changed or deleted or whatever, we could also have returned void if we wanted to 
	//or returned a boolean to tell us if the action was completed successfully or not. its up to us on how we want to handle that.
	
	//Read methods
	//TODO: ADD EXCEPTIONS THROWS AND SUCH, then we can surround the user services with try catch blocks, that will be fun
	public Account getAccount(int id);
	
	public List<Account> getAllAccounts();
	
	//Create method
	public Account addAccount(Account a, int userId);
	
	//Update method
	public Account updateAccount(Account change);
	
	//Delete Method
	public Account deleteAccount(int id);
}
