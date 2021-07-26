package dev.nowalk.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.nowalk.models.User;
import dev.nowalk.util.JDBCConnection;

public class UserRepoDBImpl implements UserRepo {

	public static Connection conn = JDBCConnection.getConnection();
	
	//now this we have the specific DB implementation
	//I need to use SQL queries in each of the methods to get the information we want
	
	@Override
	public User getUser(int id) {
		//this is the sql statement we want to execute
		//remember ?'s are placeholders for information being passed in
		String sql = "SELECT * FROM users WHERE u_id=?";
		
		try {
			//set up the prepared statement
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set values for placeholders -> ?
			//the first value is the position of the ? in the query
			//the second value is the actual value which we want to pass in, here that is the id
			ps.setInt(1, id);
			
			//execute the query and store the results in rs
			ResultSet rs = ps.executeQuery();
			
			//extract the results
			if(rs.next()) {
				//we are returning the user which we want
				//we have to make the object because it doesn't exist in our java program, it only exists as numbers on our database
				return makeUser(rs);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//if all fails we return null
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM users";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//no need to set the placeholder values, as no values get passed in
			ResultSet rs = ps.executeQuery();
			
			List<User> users = new ArrayList<User>();
			//since we have to loop through every user, we use a while loop
			//once rs.next is false (because there are no users ahead) then we will stop the loop
			while(rs.next()) {
				users.add(makeUser(rs));
			}
			return users;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User addUser(User u) {
		//lets try to do this one on our own
		//we need returning * when we are inserting into tables if we want to return all of the values of that member
		String sql = "INSERT INTO users VALUES (default,?,?) RETURNING *";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, u.getName());
			ps.setInt(2, u.getNumOfAccounts());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return makeUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public User updateUser(User change) {
		
		String sql = "UPDATE users SET name=?, num_of_accounts=? WHERE u_id=? RETURNING *";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getName());
			ps.setInt(2, change.getNumOfAccounts());
			ps.setInt(3, change.getId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return makeUser(rs);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User deleteUser(int id) {
		
		String sql = "DELETE FROM users WHERE u_id=? RETURNING *";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return makeUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("No user with that ID exists");
		}
		return null;
	}

	//helper method to make the users that we want, helps organize code better
	private User makeUser(ResultSet rs) throws SQLException {
		//the new user we are making
		User u = new User();
		//getting each value for our users from the result set
		u.setId(rs.getInt("u_id"));
		u.setName(rs.getString("name"));		
		u.setNumOfAccounts(rs.getInt("num_of_accounts"));
		//return our newly created user with all of the values which the user on the db has
		return u;
	}
	
}
