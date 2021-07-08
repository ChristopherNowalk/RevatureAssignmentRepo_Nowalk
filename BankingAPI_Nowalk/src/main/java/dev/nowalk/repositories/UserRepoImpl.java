package dev.nowalk.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dev.nowalk.models.User;
import dev.nowalk.util.FakeDB;

public class UserRepoImpl implements UserRepo {
	
	//this is the implementation using our fake database, i will make a new database implementation when all of the service methods are working
	//with this implementation
	
	@Override
	public User getUser(int id) {
		return FakeDB.users.get(id);
	}
	
	@Override
	public List<User> getAllUsers() {
		//making our list to return
		List<User> userList = new ArrayList<User>();
		//getting the keyset from the fakeDB map
		Set<Integer> keys = FakeDB.users.keySet();
		//using lambda arrow notation to add each user to the list to return
		keys.forEach(key -> userList.add(FakeDB.users.get(key)));
		return userList;
	}
	
	@Override
	public User addUser(User u) {
		//setting an id that we know wont be used
		u.setId(FakeDB.idCount++);
		FakeDB.users.put(u.getId(), u);
		return u;
	}

	@Override
	public User updateUser(User change) {
		FakeDB.users.replace(change.getId(), change);
		return change;
	}

	@Override
	public User deleteUser(int id) {
		//since this remove function returns the value associated with the id, we can just return this function
		return FakeDB.users.remove(id);
	}

}
