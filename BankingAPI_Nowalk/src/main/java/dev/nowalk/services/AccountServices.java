package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Account;

public interface AccountServices {

	//the services associated with accounts
	
	public Account addAccount(Account a, int userId);
	
	public List<Account> getAllAccounts();
	
	public Account getAccount(int a_id);
	
	public Account updateAccount(Account change);
	
	public Account deleteAccount(int a_id, int u_id);
	
	//more account services to come once i think of them
	//also i might change the Account return type, not sure if i really need it here
	
	public Account withdrawFunds(Account a, double amount);
	
	public Account addFunds(Account a, double amount);
	
	public Account transferFunds();
	
}
