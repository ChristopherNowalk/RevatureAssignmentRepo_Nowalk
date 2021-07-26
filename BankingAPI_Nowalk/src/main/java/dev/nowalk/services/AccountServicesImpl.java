package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Account;
import dev.nowalk.repositories.AccountRepo;

public class AccountServicesImpl implements AccountServices {

	public AccountRepo ar;
	
	public AccountServicesImpl(AccountRepo ar) {
		this.ar = ar;
	}
	
	@Override
	public Account addAccount(Account a, int userId) {
		return ar.addAccount(a, userId);
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = ar.getAllAccounts();
		return accounts;
	}

	@Override
	public Account getAccount(int a_id) {
		return ar.getAccount(a_id);
	}

	@Override
	public Account updateAccount(Account change) {	
		return ar.updateAccount(change);
	}

	@Override
	public Account deleteAccount (int a_id, int u_id) {
		return ar.deleteAccount(a_id);
	}
	
	@Override
	public Account withdrawFunds(Account a, double amount) {
		if(a.getBalance() > amount) {
			a.setBalance(a.getBalance() - amount);
		}
		return a;
	}
	
	@Override
	public Account addFunds(Account a, double amount) {
		a.setBalance(a.getBalance() + amount);
		return a;
	}
	@Override
	public Account transferFunds() {
		
		return null;
	}
}
