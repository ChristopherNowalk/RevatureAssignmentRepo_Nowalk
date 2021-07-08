package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Movie;

public interface MovieService {
	
	/*
	 * You may have 'trivial' services that simply call/return a particular DAO method
	 * This is because we have to have single responsibility for our layers, each layer should only talk with they layer directly below or
	 * above them with no skips. this is to prevent chaos and maintain our order
	 */	
	//in our banking api project we will need services like transfer funds and such
	public Movie getMovie(int id);
	
	public List<Movie> getAllMovies();
	
	public Movie addMovie(Movie m);
	
	public Movie updateMovie(Movie change);
	
	public Movie deleteMovie(int id);
	
	//any methods that we would like to create in this service
	//these services 'feel' like a real service. they are going to require some business logic upon data that is returned from our DAOs.
	public List<Movie> getMoviesAbovePrice(double price);
	
	public Movie checkout(Movie m);
	
	public boolean checkin(Movie m);
	
}
