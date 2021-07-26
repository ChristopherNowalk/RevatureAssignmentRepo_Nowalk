package dev.nowalk.controllers;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import dev.nowalk.models.Account;
import dev.nowalk.models.CommandJSON;
import dev.nowalk.models.User;
import dev.nowalk.services.AccountServices;
import dev.nowalk.services.UserServices;
import io.javalin.http.Handler;

public class BankController {
	UserServices us;
	AccountServices as;
	Gson gson = new Gson();

	public BankController(UserServices us, AccountServices as) {
		this.us = us;
		this.as = as;
	}

	// our controller is responsible for handling application logic, basically what
	// is it that our application needs to be able to do
	// In our case its to handle these routes (endpoints)
	// Holy crap this is gonna take some time
	public Handler getAllUsers = (context) -> {
		List<User> users = us.getAllUsers();
		context.result(gson.toJson(users));
	};

	public Handler getUserById = (context) -> {
		String input = context.pathParam("u_id");
		// then the u_id is the parameter which we described in the app.get
		int u_id;
		// id -1 is a good id to give back because we know that we wont have an id of -1
		// we have to do this exception handling because if we put a non numerical value
		// into the id then we would get an internal server error
		try {
			u_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			u_id = -1;
		}
		// get our user object with the u_id that we just got
		User u = us.getUser(u_id);
		if (u != null) {
			context.result(gson.toJson(u));
		} else {
			// bad request status code, we should send this if we get a bad request instead
			// of an empty json object
			context.status(404);
		}
	};

	public Handler addUser = (context) -> {
		// here we are making a user from the body of the request
		User u = gson.fromJson(context.body(), User.class);
		
		u = us.addUser(u);

		if (u != null) {
			context.result(gson.toJson(u));
			context.status(201);
		} else {
			context.status(400);
		}
		// context.result((u != null) ? gson.toJson(u) : "{}");
	};

	public Handler updateUser = (context) -> {
		User u = gson.fromJson(context.body(), User.class);
		// same here as add user, just updating it
		u = us.updateUser(u);
		if (u != null) {
			context.result(gson.toJson(u));
			context.status(200);
		} else {
			context.status(404);
		}
	};

	public Handler deleteUser = (context) -> {
		String input = context.pathParam("u_id");

		int u_id;
		try {
			u_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			u_id = -1;
		}

		User u = us.deleteUser(u_id);
		if (u != null) {
			context.result(gson.toJson(u));
			context.status(204);
		} else {
			context.status(404);
		}
		// context.result((u != null) ? gson.toJson(u) : "{}");
	};
	// GOT IT TO WORK!!!!!!!!!!
	public Handler addAccount = (context) -> {
		// when adding objects we dont take in an input as a string, we take in the body
		// as a json and build an
		// object out of that
		String input = context.pathParam("u_id");
		// here a has a a_id value of 0 and user_id value of 0, no idea why
		Account a = gson.fromJson(context.body(), Account.class);
		// since the body was not getting fully copied i had to get the user id from the
		// path parameters and set the account user id through that
		int u_id;
		try {
			u_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			u_id = -1;
		}

		// System.out.println(a);

		if (us.getUser(u_id) != null) {
			// if a is a valid account and the user exists, add it
			a = as.addAccount(a, u_id);
			if (a != null) {
				context.result(gson.toJson(a));
				// return code 201, successfully created
				context.status(201);
			}
			// if there is no user under that userid return code 400
		} else {
			context.status(404);
		}
	};
	// works great
	public Handler deleteAccount = (context) -> {
		String userId = context.pathParam("u_id");
		String accountId = context.pathParam("a_id");

		int a_id;
		int u_id;
		try {
			u_id = Integer.parseInt(userId);
		} catch (NumberFormatException e) {
			u_id = -1;
		}
		User u = us.getUser(u_id);

		if (u != null || us.getUser(u_id) != null) {
			try {
				a_id = Integer.parseInt(accountId);
			} catch (NumberFormatException e) {
				a_id = -1;
			}
			// check if the accounts user id == the u_id passed in
			if (as.getAccount(a_id).getUserId() == u_id) {
				Account a = as.deleteAccount(a_id, u_id);
				if (a != null) {
					context.result(gson.toJson(a));
					context.status(200);
				} else {
					context.status(404);
				}
			} else {
				// return 404 if the accounts user id doesnt match the u_id passed in
				context.status(404);
			}

		} else {
			context.status(404);
		}
	};
	
	public Handler addOrWithdrawFunds = (context) -> {
		String input1 = context.pathParam("u_id");
		String input2 = context.pathParam("a_id");
		
		int u_id;
		int a_id;
		
		try {
			u_id = Integer.parseInt(input1);
			a_id = Integer.parseInt(input2);
		} catch (NumberFormatException e) {
			u_id = -1;
			a_id = -1;
		}
		User u = us.getUser(u_id);
		CommandJSON cj = gson.fromJson(context.body(), CommandJSON.class);
		
		if(u != null) {
			Account a = us.getAccountFromUser(a_id, u_id);
			if(a != null) {
				
				//if the action is add funds, add the funds to the account
				if(cj.getCommand().equals("deposit")) {
					a = as.addFunds(a, cj.getAmount());
					as.updateAccount(a);
					context.result(gson.toJson(a));
				//else if the command is withdraw, withdraw the funds from the account
				} else if(cj.getCommand().equals("withdraw")) {
					a = as.withdrawFunds(a, cj.getAmount());
					as.updateAccount(a);
					context.result(gson.toJson(a));
				}
			//if our account doesn't exist, return 404	
			} else {
				context.status(404);
			}
		//if our user doesn't exist, return 404	
		} else {
			context.status(404);
		}
	};

	public Handler transferFunds = (context) -> {
		String input1 = context.pathParam("u_id");
		String input2 = context.pathParam("a_id1");
		String input3 = context.pathParam("a_id2");
		
		int u_id;
		int a_id1;
		int a_id2;
		
		try {
			u_id = Integer.parseInt(input1);
			a_id1 = Integer.parseInt(input2);
			a_id2 = Integer.parseInt(input3);
		} catch (NumberFormatException e) {
			u_id = -1;
			a_id1 = -1;
			a_id2 = -1;
		}
		User u = us.getUser(u_id);
		CommandJSON cj = gson.fromJson(context.body(), CommandJSON.class);
		
		if(u != null & a_id1 != a_id2) {
			Account a1 = us.getAccountFromUser(a_id1, u_id);
			Account a2 = us.getAccountFromUser(a_id2, u_id);
			
			if(cj.getCommand().equals("transfer") & as.getAccount(a_id1).getBalance() >= cj.getAmount()) {
				a1 = as.withdrawFunds(a1, cj.getAmount());
				as.updateAccount(a1);
				context.result(gson.toJson(a1));
				
				a2 = as.addFunds(a2, cj.getAmount());
				as.updateAccount(a2);
				context.result(gson.toJson(a2));
			} else {
				context.status(422);
			}
			
		} else {
			context.status(404);
		}
		
	};

	public Handler getAccountById = (context) -> {
		String input = context.pathParam("a_id");

		int a_id;

		try {
			a_id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			a_id = -1;
		}
		Account a = as.getAccount(a_id);
		if (a != null) {
			context.result(gson.toJson(a));
		} else {
			context.status(404);
		}
	};

	// don't know if making multiple strings is a good way to handle this, but this
	// is how I figured it out (hopefully)
	public Handler getAccountByUserId = (context) -> {
		String userId = context.pathParam("u_id");
		String accountId = context.pathParam("a_id");

		int u_id;
		int a_id;
		try {
			u_id = Integer.parseInt(userId);
		} catch (NumberFormatException e) {
			u_id = -1;
		}
		User u = us.getUser(u_id);
		// if our user exists, try getting the account associated with it
		if (u != null) {
			try {
				a_id = Integer.parseInt(accountId);
			} catch (NumberFormatException e) {
				a_id = -1;
			}
			Account a = us.getAccountFromUser(a_id, u.getId());
			// now if our account exists, return the account
			if (a != null) {
				context.result(gson.toJson(a));
				// if our account doesn't exist, return 404 not found
			} else {
				context.status(404);
			}
			// if our user doesn't exist, return 404 not found
		} else {
			context.status(404);
		}
	};

	// for both all accounts and accounts in between two values
	public Handler getAllAccounts = (context) -> {
		List<Account> accounts = as.getAllAccounts();
		context.result(gson.toJson(accounts));
	};

	public Handler getAllAccountsByUserId = (context) -> {
		String input = context.pathParam("u_id");
		// these two params are for getting accounts between balances
		String param1 = context.queryParam("amountLessThan");
		String param2 = context.queryParam("amountGreaterThan");

		int u_id;
		int under;
		int over;

		if (param1 != null) {
			try {

				u_id = Integer.parseInt(input);
				under = Integer.parseInt(param1);
				over = Integer.parseInt(param2);

			} catch (NumberFormatException e) {
				u_id = -1;
				under = -1;
				over = -1;
			}
			if (under >= 0 & over >= 0) {
				// get all accounts by user id
				if (us.getUser(u_id) != null) {

					List<Account> accounts = as.getAllAccounts();
					// the list we are returning with all of the accounts attached to the u_id
					List<Account> accounts2 = new ArrayList<Account>();
					for (int i = 0; i < accounts.size() - 1; i++) {
						// if the account matches the user id, and the balance is over and under the
						// queried values, add it to the list
						if (accounts.get(i).getUserId() == u_id & accounts.get(i).getBalance() <= under
								& accounts.get(i).getBalance() >= over) {
							accounts2.add(accounts.get(i));
						}
					}
					context.result(gson.toJson(accounts2));
					// if the parameters are not queried correctly

					// if the user does not exist, return 404
				} else {
					context.status(404);
				}
			//if the query is incorrectly typed, return 422	
			} else {
				context.status(422);
			}

			// if there are no other parameters, just get all accounts by user id
		} else {

			try {
				u_id = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				u_id = -1;
			}
			if (us.getUser(u_id) != null) {
				List<Account> accounts = as.getAllAccounts();
				// the list we are returning with all of the accounts attached to the u_id
				List<Account> accounts2 = new ArrayList<Account>();
				for (int i = 0; i < accounts.size() - 1; i++) {
					// if the user id and u_id passed in match, add it to the new list
					if (accounts.get(i).getUserId() == u_id) {
						accounts2.add(accounts.get(i));
					}
				}
				context.result(gson.toJson(accounts2));
				// if no such client exists return 404
			} else {
				context.status(404);
			}
		}

	};

}
