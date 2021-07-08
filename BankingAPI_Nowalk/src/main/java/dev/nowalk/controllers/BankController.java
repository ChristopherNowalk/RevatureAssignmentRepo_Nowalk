package dev.nowalk.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.nowalk.models.User;
import dev.nowalk.services.UserServices;
import io.javalin.http.Handler;

public class BankController {
	UserServices us;
	Gson gson = new Gson();
	
	public BankController(UserServices us) {
		this.us = us;
	}
	
	//our controller is responsible for handling application logic, basically what is it that our application needs to be able to do
	//In our case its to handle these routes (endpoints)
	//Holy crap this is gonna take some time
	public Handler getAllUsers = (context) -> {
		List<User> users = us.getAllUsers();
		context.result(gson.toJson(users));
	};
	
}

