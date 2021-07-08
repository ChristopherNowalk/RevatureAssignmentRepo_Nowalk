package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Account;

public interface AccountServices {

	//the services associated with accounts
	
	public Account AddAccount();
	
	public List<Account> GetAllAccounts();
	
	public Account GetAccount();
	
	public Account UpdateAccount();
	
	public Account DeleteAccount();
	
	//more account services to come once i think of them
	//also i might change the Account return type, not sure if i really need it here
	
	public Account WithdrawFunds();
	
	public Account AddFunds();
	
	public Account TransferFunds();
	
}
