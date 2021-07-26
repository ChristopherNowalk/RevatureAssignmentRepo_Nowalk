package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Event;
import dev.nowalk.models.EventType;
import dev.nowalk.models.GradingFormat;

public interface EventServices {

	public void addEvent(Event e);
	
	public List<Event> getAllEvents();
	
	public Event getEvent(int id);
	
	public Event getEvent(String event_name);
	
	public Event updateEvent(Event chang);
	
	public Event deleteEvent(Event e);
	
	public Event addEventTypeToEvent(Event e, EventType et);
	
	public Event addGraingFormatToEvent(Event e, GradingFormat gf);
	
}
