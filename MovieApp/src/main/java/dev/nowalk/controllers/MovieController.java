package dev.nowalk.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.nowalk.models.CommandJson;
import dev.nowalk.models.Movie;
import dev.nowalk.services.MovieService;
import io.javalin.http.Handler;

public class MovieController {

	MovieService ms;
	Gson gson = new Gson();
	
	public MovieController(MovieService ms) {
		this.ms = ms;
	}
	
	//Our controller is responsible for managing application logic, on other words what is it our application needs to 
	//be able to do.
	//In this case, that is manage these routes (endpoint's).
	
	public Handler getAllMovies = (context) -> {
		//what do we want this to do
		List<Movie> movies = ms.getAllMovies();
		context.result(gson.toJson(movies));
	};
	
	public Handler getMovieById = (ctx) -> {
		String input = ctx.pathParam("id");
		//then the id is the parameter which we described in the app.get
		int id;
		//id -1 is a good id to give back because we know that we wont have an id of -1
		//we have to do this exception handling because if we put a non numerical value into the id then we would get an internal server error
		try {
			id = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			id = -1;
		}
		//get our movie object with the id that we just got
		Movie m = ms.getMovie(id);
		if(m != null) {
			ctx.result(gson.toJson(m));
		} else {
			//bad request status code, we should send this if we get a bad request instead of an empty json object
			ctx.status(400);
		}
	};
	
	public Handler addMovie = (context) -> {
		//this Movie.class is referencing the class itself
		//this tells gson to convert the body (which is in json) to our movie object
		Movie m = gson.fromJson(context.body(), Movie.class);
		
		m = ms.addMovie(m);
		context.result((m != null) ? gson.toJson(m) : "{}");
	};
	
	public Handler updateMovie = (context) -> {
		Movie m = gson.fromJson(context.body(), Movie.class);
		
		m = ms.updateMovie(m);
		context.result((m != null) ? gson.toJson(m) : "{}");
	};
	
	public Handler deleteMovie = (context) -> {
		String input = context.pathParam("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			id = -1;
		}
		
		Movie m = ms.deleteMovie(id);
		//we dont need to send the movie object back, but we are deciding to here
		context.result((m != null) ? gson.toJson(m) : "{}");
	};
	
	
	public Handler movieTransaction = (context) -> {
		String input = context.pathParam("id");

		int id;
		try {
			id = Integer.parseInt(input);
		} catch(NumberFormatException e) {
			id = -1;
		}
		Movie m = ms.getMovie(id);
		CommandJson cj = gson.fromJson(context.body(), CommandJson.class);
		
		System.out.println(cj);
		
		if(cj.getCommand().equals("checkin")) {
			context.result(Boolean.toString(ms.checkin(m)));
		} else if(cj.getCommand().equals("checkout")) {
			Movie movie = ms.checkout(m);
			context.result((movie != null) ? gson.toJson(movie) : "{}");
			
		} else {
			//status code 400 is bad request
			context.status(400);
		}
			
	};
}
