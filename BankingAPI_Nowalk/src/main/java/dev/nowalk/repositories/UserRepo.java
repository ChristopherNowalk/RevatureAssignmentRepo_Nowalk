package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.User;

public interface UserRepo {
	//this is where we would want to implement our CRUD methods
	
	//Read methods
	public User getUser(int id);
	
	public List<User> getAllUsers();
	
	//Create method
	public User addUser(User u);
	
	//Update method
	public User updateUser(User change);
	
	//Delete method
	public User deleteUser(int id);
	
	
}
