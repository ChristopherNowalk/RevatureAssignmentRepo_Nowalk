package dev.nowalk.services;

import java.util.ArrayList;
import java.util.List;

import dev.nowalk.models.Movie;
import dev.nowalk.repositories.MovieRepo;

public class MovieServiceImpl implements MovieService {

	//we need a movie repo object to work on
	public MovieRepo mr;
	
	public MovieServiceImpl(MovieRepo mr) {
		this.mr = mr;
	}
	//these trivial methods are just returning the repository implementations
	@Override
	public Movie getMovie(int id) {
		return mr.getMovie(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		return mr.getAllMovies();
	}

	@Override
	public Movie addMovie(Movie m) {
		return mr.addMovie(m);
	}

	@Override
	public Movie updateMovie(Movie change) {
		return mr.updateMovie(change);
	}

	@Override
	public Movie deleteMovie(int id) {
		return mr.deleteMovie(id);
	}
	
	//new service methods
	@Override
	public List<Movie> getMoviesAbovePrice(double price) {
		//aquire all movies. we can either call down to the DAO/Repository method, or we can call the method directly from the service layer
		List<Movie> movies = mr.getAllMovies()
;		//lets make another list to store our movies that meet the requirements
		List<Movie> refinedMovies = new ArrayList<Movie>();
		
		for(Movie m : movies) {
			if(m.getPrice() >= price) {
				refinedMovies.add(m);
			}
		}
		
		return refinedMovies;
	}

	@Override
	public Movie checkout(Movie m) {
		
		Movie movie = mr.getMovie(m.getId());
		//this checks if the movie exists in our list of movies
		if(movie != null && movie.isAvailable()) {
			
			movie.setAvailable(false);
			//adding two weeks to return time
			movie.setReturnDate(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 14));
			
			mr.updateMovie(movie);
			return movie;
			
		}
		//if the movie wasn't in the database or the availability was false, return null, we could throw a custom exception if it isnt either
		return null;
	}

	@Override
	public boolean checkin(Movie m) {
		
		Movie movie = mr.getMovie(m.getId());
		if(movie != null && !movie.isAvailable()) {
			movie.setAvailable(true);
			movie.setReturnDate(0);
			//update the database with the movie object
			mr.updateMovie(movie);
			return true;
		}
		return false;
	}

}
