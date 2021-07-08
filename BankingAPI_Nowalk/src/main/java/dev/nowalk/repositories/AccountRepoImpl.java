package dev.nowalk.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dev.nowalk.models.Account;
import dev.nowalk.util.FakeDB;

public class AccountRepoImpl implements AccountRepo {

	//I guess I can make a second fake database map for the accounts, since I plan on having two different tables to access 
	//in the database
	//the problem is figuring out how to link the accounts with the users, I guess each account could have a user obj attached to it
	
	@Override
	public Account getAccount(int id) {
		return FakeDB.accounts.get(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accountList = new ArrayList<Account>();
		Set<Integer> keys = FakeDB.accounts.keySet();
		//for every key in the account map, add that account to the list of accounts to return
		keys.forEach(key -> accountList.add(FakeDB.accounts.get(key)));
		return accountList;
	}

	@Override
	public Account addAccount(Account a, int userId) {
		//setting the id of the new account to something unique
		a.setId(FakeDB.accountIdCount++);
		a.setUserId(userId);
		FakeDB.accounts.put(a.getId(), a);
		return a;
	}

	@Override
	public Account updateAccount(Account change) {
		FakeDB.accounts.replace(change.getId(), change);
		return change;
	}

	@Override
	public Account deleteAccount(int id) {		
		return FakeDB.accounts.remove(id);
	}

}
