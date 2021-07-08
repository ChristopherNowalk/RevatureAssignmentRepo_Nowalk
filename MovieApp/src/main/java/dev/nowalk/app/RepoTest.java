package dev.nowalk.app;

import java.util.List;

import dev.nowalk.models.Movie;
import dev.nowalk.repositories.MovieRepo;
import dev.nowalk.repositories.MovieRepoImpl;
//repo test is simply for testing purposes, we will probably never use this again
public class RepoTest {
	
	public static void main(String[] args) {
		
		MovieRepo mr = new MovieRepoImpl();
		
		List<Movie> movies = mr.getAllMovies();
		System.out.println(movies);
		
		System.out.println(mr.getMovie(2));
		
		Movie m = new Movie(12341234, "Black Widow", 30.0, true, 0);
		m = mr.addMovie(m);
		System.out.println("=====ADD MOVIE======");
		System.out.println(m);
		System.out.println(mr.getAllMovies());
		
		m.setPrice(25);
		m.setAvailable(false);
		m.setReturnDate(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 14));
		
		m = mr.updateMovie(m);
		System.out.println("=====UPDATE MOVIE======");
		System.out.println(m);
		System.out.println(mr.getMovie(m.getId()));
		
		mr.deleteMovie(m.getId());
		System.out.println("=====DELETE MOVIE=====");
		System.out.println(mr.getAllMovies());
		
	}
}
