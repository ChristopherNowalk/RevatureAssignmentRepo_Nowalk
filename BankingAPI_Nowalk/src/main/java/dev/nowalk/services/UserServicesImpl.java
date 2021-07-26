package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Account;
import dev.nowalk.models.User;
import dev.nowalk.repositories.AccountRepo;
import dev.nowalk.repositories.UserRepo;

public class UserServicesImpl implements UserServices {

	//our user repository object to work with
	public UserRepo ur;
	//our account repository object to work with, i am only using 1 service layer as I want all account actions to go through
	//a specific user
	public AccountRepo ar;
	
	public UserServicesImpl(UserRepo ur, AccountRepo ar) {
		this.ur = ur;
		this.ar = ar;
	}
	//the first methods seem tedious, but they are meant to talk to the DAO layer instead of directly skipping to the data layer
	@Override
	public User getUser(int id) {
		return ur.getUser(id);
	}

	@Override
	public List<User> getAllUsers() {		
		return ur.getAllUsers();
	}

	@Override
	public User addUser(User u) {		
		return ur.addUser(u);
	}

	@Override
	public User updateUser(User change) {		
		return ur.updateUser(change);
	}

	@Override
	public User deleteUser(int id) {		
		return ur.deleteUser(id);
	}

	//this one I will have to think about a little bit
//	@Override
//	public Account addAccountToUser(Account a) {	
//		//a.setUserId(userId);
//		return ar.addAccount(a);
//		//User u = this.getUser(userId);
//		//u.setAccount(a);
//		//ur.updateUser(u);
//	}
	
	@Override
	public Account deleteAccountFromUser(int id, int userId) {
		//User u = this.getUser(userId);	
		//if the accounts exists with the users id, delete it from the accounts map
		if(ur.getUser(userId) == null) {
			return null;
		}
		else if(ar.getAccount(id).getUserId() == userId) {
			return ar.deleteAccount(id);
		} 
		else {
			return null;
		}
	}

	@Override
	public Account withdrawFunds(int id, int userId, double amount) {
		//access the account by the userid and the id of the account
		if(ur.getUser(userId) == null) {
			return null;
		}
		else if(ar.getAccount(id).getUserId() == userId & ar.getAccount(id).getBalance() >= amount) {
			//making our temporary account that is equal to the one we are changing
			Account a = ar.getAccount(id);
			//set the new balance
			a.setBalance(a.getBalance() - amount);
			//update and return that account
			return ar.updateAccount(a);
		} 
		else {
			return null;
		}
	}

	@Override
	public Account addFunds(int id, int userId, double amount) {
		//access the account by the userid and the id of the account
		if(ur.getUser(userId) == null) {
			return null;
		}
		//check to see if that account exists, no need to check balance for adding funds
		else if(ar.getAccount(id).getUserId() == userId) {
			//making our temporary account that is equal to the one we are changing
			Account a = ar.getAccount(id);
			//set the new balance
			a.setBalance(a.getBalance() + amount);
			//update and return that account
			return ar.updateAccount(a);
			//return ar.deleteAccount(id);
		} 
		else {
			return null;
		}
	}

	@Override
	public Account transferFunds(int takeId, int putId, int userId, double amount) {
		//basically a combination of add funds and withdraw funds
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		return ar.getAllAccounts();		
	}
	
	@Override
	public Account getAccountById(int id) {
		return ar.getAccount(id);
	}
	
	@Override
	public Account getAccountFromUser(int id, int userId) {
		List<Account> accounts = ar.getAllAccounts();
		//look through the list of accounts return the account we are looking for
		for(int i = 0; i <= accounts.size() - 1; i++) {
			Account a = accounts.get(i);
			if(a.getUserId() == userId & a.getId() == id) {
				return a;
			}
		} 
		return null;
	}	
	
	@Override
	public List<Account> getAllAccountsByUserId(int userId){
		List<Account> accounts = ar.getAllAccounts();
		//look through the list of accounts and remove those which don't have the userId or the id of the acc we are looking for
		for(int i = 0; i < accounts.size() - 1; i++) {
			Account a = accounts.get(i);
			if(a.getUserId() != userId) {
				accounts.remove(i);
			}
		}
		//return null if there are no accounts for that user
		if(accounts.isEmpty()) {
			return null;
		} else {
			return accounts;
		}
	}
}
