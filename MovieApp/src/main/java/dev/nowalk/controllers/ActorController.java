package dev.nowalk.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.nowalk.models.Actor;
import dev.nowalk.models.Movie;
import dev.nowalk.repositories.ActorRepo;
import io.javalin.http.Handler;

public class ActorController {

	Gson gson = new Gson();
	ActorRepo ar;
	
	//Please don't ever actually skip the service layer, we are just doing this because of time restraints
	public ActorController(ActorRepo ar) {
		this.ar = ar;
	}
	
	public Handler getActorById = (context) -> {
		String input = context.pathParam("id");
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
		Actor a = ar.getActor(id);
		if(a != null) {
			context.result(gson.toJson(a));
		} else {
			//bad request status code, we should send this if we get a bad request instead of an empty json object
			context.result("{}");
		}
	};
	
	public Handler addActor = (context) -> {
		Actor a = gson.fromJson(context.body(), Actor.class);
		
		a = ar.addActor(a);
		
		if(a != null) {
			context.result(gson.toJson(a));
		} else {
			//bad request status code, we should send this if we get a bad request instead of an empty json object
			context.result("{}");
		}
	};
	
	public Handler getAllActors = (context) -> {
		
		List<Actor> actors = ar.getAllActors();
		if(actors != null) {
			context.result(gson.toJson(actors));
		} else {
			context.result("[]");
		}
		
	};
	
	public Handler updateActor = (context) -> {
		Actor a = gson.fromJson(context.body(), Actor.class);
		a.setId(Integer.parseInt(context.pathParam("id")));
		
		a = ar.updateActor(a);
		if(a != null) {
			context.result(gson.toJson(a));
		} else {
			context.result("{}");
		}
		
	};
	
	public Handler deleteActor = (context) -> {
		
		int id = Integer.parseInt(context.pathParam("id"));
		
		Actor a = ar.deleteActor(id);
		if(a != null) {
			context.result(gson.toJson(a));
		} else {
			context.result("{}");
		}
	};
	
	public Handler getActorByName = (context) -> {
		
		String name = context.queryParam("name");
		
		Actor a = ar.getActor(name);
		
		if( a != null) {
			context.result(gson.toJson(a));
		} else {
			context.result("{}");
		}

	};
	
}
