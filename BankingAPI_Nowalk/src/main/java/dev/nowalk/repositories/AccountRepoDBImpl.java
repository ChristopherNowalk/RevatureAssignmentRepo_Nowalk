package dev.nowalk.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.nowalk.models.Account;
import dev.nowalk.util.JDBCConnection;

public class AccountRepoDBImpl implements AccountRepo {

	public static Connection conn = JDBCConnection.getConnection();
	
	@Override
	public Account getAccount(int id) {
		String sql = "SELECT * FROM accounts WHERE a_id=?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//setting the values of the ? placeholders
			ps.setInt(1, id);
			//executing the query and saving the result
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return makeAccount(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Account> getAllAccounts() {
		String sql = "SELECT * FROM accounts";
		
		List<Account> accounts = new ArrayList<Account>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				accounts.add(makeAccount(rs));
			}
			return accounts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account addAccount(Account a, int userId) {
		String sql = "INSERT INTO accounts VALUES (default,?,?,?) RETURNING *";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, a.getType());
			ps.setDouble(2, a.getBalance());
			//ps.setInt(3, a.getUserId());
			ps.setInt(3, userId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return makeAccount(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account updateAccount(Account change) {

		String sql = "UPDATE accounts SET type=?,balance=?,user_id=? WHERE a_id=? RETURNING *";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, change.getType());
			ps.setDouble(2, change.getBalance());
			ps.setInt(3, change.getUserId());
			ps.setInt(4, change.getId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return makeAccount(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account deleteAccount(int id) {
		
		String sql = "DELETE FROM accounts WHERE a_id=? RETURNING *";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return makeAccount(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private Account makeAccount(ResultSet rs) throws SQLException{
		//make the account we are going to be returning
		Account a = new Account();
		//set the values for our account
		a.setId(rs.getInt("a_id"));
		a.setType(rs.getString("type"));
		a.setBalance(rs.getDouble("balance"));
		a.setUserId(rs.getInt("user_id"));
		
		return a;
	}

}
