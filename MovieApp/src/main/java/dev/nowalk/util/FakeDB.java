package dev.nowalk.util;

import java.util.HashMap;
import java.util.Map;

import dev.nowalk.models.Movie;

public class FakeDB {
	/*
	 * This class will eventually be replaced, this will serve as a way for us to store our data, but the data will be lost when we
	 * close out the application
	 */
	
	public static Map<Integer, Movie> movies = new HashMap<Integer, Movie>();
	public static int idCount = 1;
	//static block, this is an initializer
	//the first time there is a reference to FakeDB this static block will be executed
	//this block will pre-populate our movies. For testing purposes
	static {
		Movie m1 = new Movie(1, "Iron Man", 5.0, true, 0);
		Movie m2 = new Movie(2, "Thor", 6.0, true, 0);
		Movie m3 = new Movie(3, "Captain America", 10.0, true, 0);
		
		//.put is the way you add things to a map with the key and value as parameters
		movies.put(idCount++, m1);
		movies.put(idCount++, m2);
		movies.put(idCount++, m3);
	}
}
