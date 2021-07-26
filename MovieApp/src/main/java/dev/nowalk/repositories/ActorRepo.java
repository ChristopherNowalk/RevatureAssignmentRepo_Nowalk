package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.Actor;

public interface ActorRepo {

	
	public Actor addActor(Actor a);
	public List<Actor> getAllActors();
	public Actor getActor(int id);
	public Actor getActor(String name);
	public Actor updateActor(Actor change);
	public Actor deleteActor(int id);
	
}
