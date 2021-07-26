package dev.nowalk.app;

import dev.nowalk.controllers.BankController;
import dev.nowalk.repositories.AccountRepo;
import dev.nowalk.repositories.AccountRepoDBImpl;
import dev.nowalk.repositories.UserRepo;
import dev.nowalk.repositories.UserRepoDBImpl;
import dev.nowalk.services.AccountServices;
import dev.nowalk.services.AccountServicesImpl;
import dev.nowalk.services.UserServices;
import dev.nowalk.services.UserServicesImpl;
import io.javalin.Javalin;

public class App {
	
	public static void main (String[] args) {
		
		//establish our javalin object
		Javalin app = Javalin.create();
		
		establishRoutes(app);
		
		app.start();
	}
	
	private static void establishRoutes(Javalin app) {
		//Here we are going to define a list of routes (endpoint's) we want javalin to manage
		
		//getting our repo's, services, and controller objects to work with
		UserRepo ur = new UserRepoDBImpl();
		AccountRepo ar = new AccountRepoDBImpl();
		UserServices us = new UserServicesImpl(ur, ar);
		AccountServices as = new AccountServicesImpl(ar);
		BankController bc = new BankController(us, as);
				
		//Establish a route to the 'landing' page.
		//ctx is our context object, we can call is context if we wanted to 
		//the result is what we want to send back, for now its just a string
		
		//this is just a test to make sure javalin was working properly
		app.get("/", (ctx) -> ctx.result("This is Our Banking App Home Page!"));
		
		//get all users
		app.get("/users", bc.getAllUsers);
		//get a specific user by id
		app.get("/users/:u_id", bc.getUserById);
		//add a user
		app.post("/users", bc.addUser);
		//update a user
		app.put("/users/:u_id", bc.updateUser);
		//delete a user
		app.delete("/users/:u_id", bc.deleteUser);
		//get all accounts, don't really need this here i guess
		app.get("/accounts",bc.getAllAccounts);	
		//get a users account by id
		app.get("/users/:u_id/accounts/:a_id", bc.getAccountByUserId);
		//get all of a users accounts
		app.get("/users/:u_id/accounts", bc.getAllAccountsByUserId);
		//delete a users account by account id
		app.delete("/users/:u_id/accounts/:a_id", bc.deleteAccount);
		//add an account to a user
		app.post("/users/:u_id/accounts", bc.addAccount);
		//add or withdraw funds to a users account
		app.patch("/users/:u_id/accounts/:a_id", bc.addOrWithdrawFunds);
		//transfer funds from one users account, to another
		app.patch("/users/:u_id/accounts/:a_id1/transfer/:a_id2", bc.transferFunds);
		
		
	}
}
