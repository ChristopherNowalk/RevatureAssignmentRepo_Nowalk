package dev.nowalk.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dev.nowalk.models.Movie;
import dev.nowalk.util.FakeDB;

public class MovieRepoImpl implements MovieRepo {

	@Override
	public Movie getMovie(int id) {
		//since movies is static in our FakeDB we can just access it by calling FakeDB.movies
		return FakeDB.movies.get(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList = new ArrayList<Movie>();
		Set<Integer> keys = FakeDB.movies.keySet();
//		for(Integer key : keys) {
//			movieList.add(FakeDB.movies.get(key));
//		}
		//this is a more java 8 way to do what we did above with an enhanced for loop
		//yay lambda operator (arrow notation)
		keys.forEach(key -> movieList.add(FakeDB.movies.get(key)));
		return movieList;
	}

	@Override
	public Movie addMovie(Movie m) {
		//just in case we don't have an ID. or pass in a bad ID
		//this is a lazy way to do this, but it will make sure that all of our id's will be unique
		m.setId(FakeDB.idCount++);
		
		FakeDB.movies.put(m.getId(), m);
		return m;
	}

	@Override
	public Movie updateMovie(Movie change) {
		//we are going to assume that you aren't changing the ID of the movie
		FakeDB.movies.replace(change.getId(), change);
		return change;
	}

	@Override
	public Movie deleteMovie(int id) {
		return FakeDB.movies.remove(id);
	}

	
}
