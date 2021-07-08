package dev.nowalk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	private static Connection conn = null;
	
	public static Connection getConnection () {
		
		/* Just needed to write these down again to help memorize
		 * To establish a connection we need 3 credentials:
		 * url (endpoint)
		 * username
		 * password
		 */
		
		
		//the connection is a singleton
		//getting the connection here if there is no connection established
		if(conn == null) {
			
			String endpoint = "chris2106postgres.cyhaevxali9v.us-east-2.rds.amazonaws.com";			
			//URL format (postgres JDBC) is below
			//jdbc:postgresql://[endpoint]/[database]
			String url = "jdbc:postgresql://" + endpoint + "/postgres";
			String username = "ChrisNowalk";
			String password = "magicalpig";
			
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return conn;
	}
}
