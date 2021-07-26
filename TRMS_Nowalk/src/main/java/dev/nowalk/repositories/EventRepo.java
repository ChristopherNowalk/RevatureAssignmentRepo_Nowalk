package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.Event;

public interface EventRepo {
	
	public void addEvent(Event e);
	
	public List<Event> getAllEvents();
	
	public Event getEvent(int id);
	
	public Event getEvent(String event_name);
	
	public Event updateEvent(Event change);
	
	public Event deleteEvent(Event e);
}
