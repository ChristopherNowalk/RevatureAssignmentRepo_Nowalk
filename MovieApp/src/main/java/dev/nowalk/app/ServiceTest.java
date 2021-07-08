package dev.nowalk.app;

import java.util.List;

import dev.nowalk.models.Movie;
import dev.nowalk.repositories.MovieRepo;
import dev.nowalk.repositories.MovieRepoImpl;
import dev.nowalk.services.MovieService;
import dev.nowalk.services.MovieServiceImpl;

public class ServiceTest {

	public static void main(String[] args) {
		
		MovieRepo mr = new MovieRepoImpl();
		MovieService ms = new MovieServiceImpl(mr);
		
		List<Movie> expensiveMovies = ms.getMoviesAbovePrice(7);
		
		System.out.println(expensiveMovies);
		System.out.println(ms.getMoviesAbovePrice(0));
		System.out.println(ms.getMoviesAbovePrice(Double.MAX_VALUE));
		
		Movie m = ms.getMovie(3);
		System.out.println("===CHEKCOUT===");
		System.out.println((ms.checkout(m) != null) ? "Movie Checked out!" : "Movie is not available");
		//on this second attempt we get null because we changed the isAvailable to false
		System.out.println((ms.checkout(m) != null) ? "Movie Checked out!" : "Movie is not available");
		System.out.println(ms.getMovie(3));
		
		System.out.println("===CHEKCIN===");
		System.out.println((ms.checkin(m) == true) ? "Movie checked in!" : "Movie unable to check in");
		System.out.println((ms.checkin(m) == true) ? "Movie checked in!" : "Movie unable to check in");
		System.out.println(ms.getMovie(3));
	}
	
}
