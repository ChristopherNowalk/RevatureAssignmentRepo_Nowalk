package dev.nowalk.app;

import dev.nowalk.models.Account;
import dev.nowalk.models.User;
import dev.nowalk.repositories.AccountRepo;
import dev.nowalk.repositories.AccountRepoDBImpl;
import dev.nowalk.repositories.UserRepo;
import dev.nowalk.repositories.UserRepoDBImpl;

public class RepoDBTest {
	public static void main(String[] args) {
		
		UserRepo ur = new UserRepoDBImpl();
		AccountRepo ar = new AccountRepoDBImpl();
//all of these work, didnt want to keep adding the same thing over and over again, so i commented them out		
//		User u = ur.getUser(1);
//		System.out.println(u);
//		System.out.println(ur.getAllUsers());
//		System.out.println(ur.getAllUsers());
//		
		//User u2 = new User("Chris Nowalk", 2);
//		System.out.println(ur.addUser(u2));
//		
//		
//		Account a = ar.getAccount(1);
//		System.out.println(a);
//		System.out.println(ar.getAllAccounts());
//		
		Account a2 = new Account(1, "Savings", 5200.00, 4);
//		ar.addAccount(a2, a2.getUserId());
//		System.out.println(ar.getAllAccounts());
		
//		ur.deleteUser(6);
//		ur.deleteUser(7);
//		ur.deleteUser(8);
//		ur.deleteUser(9);
//		ur.deleteUser(10);
//		
//		ar.deleteAccount(10);
//		ar.deleteAccount(11);
//		ar.updateAccount(a2);
	}
}
