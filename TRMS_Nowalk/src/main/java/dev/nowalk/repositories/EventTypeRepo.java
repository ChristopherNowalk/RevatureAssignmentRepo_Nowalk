package dev.nowalk.repositories;

import java.util.List;

import dev.nowalk.models.EventType;

public interface EventTypeRepo {

	public void addEventType(EventType et);
	
	public List<EventType> getAllEventTypes();
	
	public EventType getEventType(int id);
	
	public EventType getEventType(String name);
	
	public EventType updateEventType(EventType change);
	
	public EventType deleteEventType(EventType et);
}
