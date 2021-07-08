package dev.nowalk.app;

import dev.nowalk.models.Movie;
import dev.nowalk.repositories.MovieRepo;
import dev.nowalk.repositories.MovieRepoDBImpl;

public class RepoDBTest {

	public static void main(String[] args) {
		
		MovieRepo mr = new MovieRepoDBImpl();
				
		Movie m = mr.getMovie(4);
		//if we print out a movie that means that we have successfully used JDBC to get a movie from our database
		System.out.println(m);
		System.out.println(mr.getAllMovies());
		
		
		Movie newMovie = new Movie("Guardians of the Galaxy: vol 1", 11, true, 0);
		newMovie = mr.addMovie(newMovie);		
		System.out.println(newMovie);
	}
	
}
