package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.Movie;

public interface MovieRepo {

	// The primary functionality that we would like our Repository (DAO, data access object) Layer to achieve is the
	//CRUD operation on our Data.
	
	//some common Retrieve/Read methods
	public Movie getMovie(int id);
	
	public List<Movie> getAllMovies();
	
	//Create method
	public Movie addMovie(Movie m);
	
	//Update method
	public Movie updateMovie(Movie change);
	
	//Delete method
	public Movie deleteMovie(int id);
}
