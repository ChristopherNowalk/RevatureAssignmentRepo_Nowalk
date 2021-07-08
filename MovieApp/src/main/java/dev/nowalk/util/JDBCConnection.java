package dev.nowalk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	//pur connection object
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		/*
		 * To establish a connection we need 3 credentials:
		 * url (endpoint)
		 * username
		 * password
		 */
		
		if(conn == null) {
			//establish Connection (do not hard code the credentials like we are here, it is a very bad and lazy way to do so)
			String endpoint = "chris2106postgres.cyhaevxali9v.us-east-2.rds.amazonaws.com";
			//URL format (postgres JDBC) is below
			//jdbc:postgresql://[endpoint]/[database]
			String url = "jdbc:postgresql://" + endpoint + "/postgres";
			String username = "ChrisNowalk";
			String password = "magicalpig";
				
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		//if we already have a connection, return the connection
		return conn;
	}
	
	/*
	 * THIS IS FOR TESTING PURPOSES ONLY
	 * NOT NEED TO ACTUALLY USE JDBC
	 */
//	public static void main(String[] args) {
//		
//		Connection conn1 = getConnection();
//		
//		System.out.println(conn1);
//		
//	}
	
	
}
