package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.Event;
import dev.nowalk.models.EventType;
import dev.nowalk.models.GradingFormat;
import dev.nowalk.repositories.EventRepo;

public class EventServicesImpl implements EventServices {

	EventRepo er;
	
	public EventServicesImpl (EventRepo er) {
		this.er = er;
	}
	
	@Override
	public void addEvent(Event e) {
		er.addEvent(e);
	}

	@Override
	public List<Event> getAllEvents() {	
		return er.getAllEvents();
	}

	@Override
	public Event getEvent(int id) {
		return er.getEvent(id);
	}

	@Override
	public Event getEvent(String event_name) {
		return er.getEvent(event_name);
	}

	@Override
	public Event updateEvent(Event chang) {	
		return er.updateEvent(chang);
	}

	@Override
	public Event deleteEvent(Event e) {	
		return er.deleteEvent(e);
	}
	
	@Override
	public Event addEventTypeToEvent(Event e, EventType et) {
		e.setEvent_type(et);
		return e;
	}

	@Override
	public Event addGraingFormatToEvent(Event e, GradingFormat gf) {
		e.setGrading_format(gf);
		return e;
	}

}
