package dev.nowalk.app;

import java.util.List;

import dev.nowalk.models.Account;
import dev.nowalk.repositories.AccountRepo;
import dev.nowalk.repositories.AccountRepoImpl;
import dev.nowalk.repositories.UserRepo;
import dev.nowalk.repositories.UserRepoImpl;
import dev.nowalk.services.UserServices;
import dev.nowalk.services.UserServicesImpl;

public class ServiceTest {
	public static void main(String[] args)	{
		
		UserRepo ur = new UserRepoImpl();
		AccountRepo ar = new AccountRepoImpl();
		
		UserServices us = new UserServicesImpl(ur, ar);	
		
		Account a = new Account("roth ira", 10000.00, 1);
		//not using account services
		//AccountServices as = new AccountServicesImpl();
		List<Account> accounts = ar.getAllAccounts();
		System.out.println(accounts);
		System.out.println(us.addAccountToUser(a, 1));
		//this fails below because we are searching through the array list of accounts in a user, and it thinks the id is the index, which 
		//it most definitely is not the index of the account in the array list. we can either change the data structure or find a way
		//around the issue
		us.withdrawFunds(9, 1, 1000.00);
		System.out.println(ar.getAccount(9));
		//the account id is not updating when we print them out, but their actual id is changing, this is the fake db's fault
		System.out.println(us.addFunds(1, 1, 20.00));
		//there is some error handling I have to do if the account id passed in is out of range, it breaks the application when that 
		//happens
		us.withdrawFunds(13, 1, 1000000.00);
		System.out.println(ar.getAccount(9));
		
		us.deleteAccountFromUser(1, 1);
		//update our list of accounts to print
		accounts = ar.getAllAccounts();
		//now we have no savings WOOOO!
		System.out.println(accounts);
	}
}
