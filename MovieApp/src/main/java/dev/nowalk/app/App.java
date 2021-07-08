package dev.nowalk.app;

import dev.nowalk.controllers.MovieController;
import dev.nowalk.repositories.MovieRepo;
import dev.nowalk.repositories.MovieRepoDBImpl;
import dev.nowalk.services.MovieService;
import dev.nowalk.services.MovieServiceImpl;
import io.javalin.Javalin;

public class App {
	
	public static void main(String[] args) {
		
		//Establish our javalin object
		Javalin app = Javalin.create();
		
		//Establish the Routes/Endpoint's Javalin will manage
		establishRoutes(app);
		
		//Run Javalin
		app.start(7000);
	}

	private static void establishRoutes(Javalin app) {
		//Here we are going to define a list of routes (endpoint's) we want javalin to manage
		MovieRepo mr = new MovieRepoDBImpl();
		MovieService ms = new MovieServiceImpl(mr);
		MovieController mc = new MovieController(ms);
		
		//Establish a route to the 'landing' page.
		//ctx is our context object, we can call is context if we wanted to 
		//the result is what we want to send back, for now its just a string
		app.get("/", (ctx) -> ctx.result("This is Our Movie App Home Page!"));
		app.get("/hello", (ctx) -> ctx.result("Hello World!"));
		
		app.get("/movies", mc.getAllMovies);
		//when we use the : in the path that means that the value is a placeholder that we will change
		app.get("/movies/:id", mc.getMovieById);
		//our post request, we have to use postman to do a post request because we cannot do it directly through a url
		app.post("/movies", mc.addMovie);
		
		app.put("/movies/:id", mc.updateMovie);
		
		app.delete("/movies/:id", mc.deleteMovie);
		
		app.patch("/movies/:id", mc.movieTransaction);
		
	}
}
