package dev.nowalk.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.nowalk.models.Movie;
import dev.nowalk.util.JDBCConnection;

public class MovieRepoDBImpl implements MovieRepo {

	
	public static Connection conn = JDBCConnection.getConnection();	
	
	@Override
	public Movie getMovie(int id) {
		//this is the sql command that we want to execute
		//we use the ? as a placeholder for what we want to input
		String sql = "SELECT * FROM movies WHERE id = ?";
		try {
			//set up PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//Set values for placeholders
			ps.setInt(1, id);
			
			//execute query, store the results
			ResultSet rs = ps.executeQuery();
			
			//extract results out of ResultSet, put it in an if statement because rs.next returns a boolean
			if(rs.next()) {			
				return buildMovie(rs);				
			}						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Movie> getAllMovies() {		
		String sql = "SELECT * FROM movies";		
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Movie> movies = new ArrayList<Movie>();
			
			while(rs.next()) {
				
				movies.add(buildMovie(rs));								
			}
			return movies;
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public Movie addMovie(Movie m) {
		
		String sql = "INSERT INTO movies VALUES (default,?,?,?,?) RETURNING *";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set values for the placeholders ?
			ps.setString(1, m.getTitle());
			ps.setDouble(2, m.getPrice());
			ps.setBoolean(3, m.isAvailable());
			ps.setLong(4, m.getReturnDate());
			
			//execute query, store the results
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//extract the data, and return it
				return buildMovie(rs);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Movie updateMovie(Movie change) {
		//adding the returning * it will return the updated values
		String sql = "UPDATE movies SET title=?, prive=?, available=?, return_date=? WHERE id =? RETURNING *";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set values for the placeholders ?
			ps.setString(1, change.getTitle());
			ps.setDouble(2, change.getPrice());
			ps.setBoolean(3, change.isAvailable());
			ps.setLong(4, change.getReturnDate());
			ps.setInt(5, change.getId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return buildMovie(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Movie deleteMovie(int id) {
		
		String sql = "DELETE FROM movies WHERE id=? RETURNING *";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return buildMovie(rs);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//helper method (or butler method as David proposed)
	private Movie buildMovie(ResultSet rs) throws SQLException {
		//create our movie obj
		Movie m = new Movie();
		//id is the column set we want 
		m.setId(rs.getInt("id")); 
		m.setTitle(rs.getString("title"));
		m.setPrice(rs.getDouble("price"));
		m.setAvailable(rs.getBoolean("available"));
		m.setReturnDate(rs.getLong("return_date"));
		
		return m;
	}

}
