package dev.nowalk.services;

import java.util.List;

import dev.nowalk.models.EventType;
import dev.nowalk.repositories.EventTypeRepo;

public class EventTypeServicesImpl implements EventTypeServices {

	public EventTypeRepo etr;
	
	public EventTypeServicesImpl(EventTypeRepo etr) {
		this.etr = etr;
	}
	
	@Override
	public void addEventType(EventType et) {
		etr.addEventType(et);
	}

	@Override
	public List<EventType> getAllEventTypes() {	
		return etr.getAllEventTypes();
	}

	@Override
	public EventType getEventType(int id) {	
		return etr.getEventType(id);
	}

	@Override
	public EventType getEventType(String name) {		
		return etr.getEventType(name);
	}

	@Override
	public EventType updateEventType(EventType change) {	
		return etr.updateEventType(change);
	}

	@Override
	public EventType deleteEventType(EventType et) {		
		return etr.deleteEventType(et);
	}

}
