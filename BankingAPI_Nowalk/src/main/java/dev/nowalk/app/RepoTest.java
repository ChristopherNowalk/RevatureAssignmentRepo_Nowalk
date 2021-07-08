package dev.nowalk.app;

import java.util.List;

import dev.nowalk.models.User;
import dev.nowalk.repositories.AccountRepo;
import dev.nowalk.repositories.AccountRepoImpl;
import dev.nowalk.repositories.UserRepo;
import dev.nowalk.repositories.UserRepoImpl;

public class RepoTest {
	public static void main(String[] args) {
		
		AccountRepo ar = new AccountRepoImpl();
		UserRepo ur = new UserRepoImpl();
		
		List<User> users = ur.getAllUsers();
		System.out.println(users);
	}
	
}
