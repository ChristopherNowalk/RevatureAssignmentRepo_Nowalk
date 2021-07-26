package dev.nowalk.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.nowalk.models.EventType;
import dev.nowalk.services.EventTypeServices;
import io.javalin.http.Handler;

public class EventTypeController {

	public EventTypeServices ets;
	Gson gson = new Gson();
	
	public EventTypeController(EventTypeServices ets) {
		this.ets = ets;
	}
	
	public Handler addEventType = (context) -> {
		EventType et = gson.fromJson(context.body(), EventType.class);
		
		ets.addEventType(et);
		
		if(et != null) {
			context.result(gson.toJson(et));
		} else {
			context.status(400);
		}
	};
	
	public Handler getAllEventTypes = (context) -> {
		List<EventType> eventTypes = ets.getAllEventTypes();
		context.result(gson.toJson(eventTypes));
	};
	
	public Handler getEventTypeById = (context) -> {
		String event_type = context.queryParam("et_id");
		int et_id;
		
		try {
			et_id = Integer.parseInt(event_type);
		} catch (NumberFormatException e) {
			et_id = -1;
		}
		
		EventType et = ets.getEventType(et_id);
		
		if( et != null) {
			context.result(gson.toJson(et));
		} else {
			context.status(404);
		}
	};
	
	public Handler getEventTypeByName = (context) -> {
		String event_type = context.queryParam("event_type");
		
		EventType et = ets.getEventType(event_type);
		
		if( et != null) {
			context.result(gson.toJson(et));
		} else {
			context.status(404);
		}
	};
	
	public Handler updateEventType = (context) -> {
		EventType et = gson.fromJson(context.body(), EventType.class);
		et = ets.updateEventType(et);
		
		if(et != null) {
			context.result(gson.toJson(et));
			context.status(200);
		} else {
			context.status(404);
		}
	};
	
	//don't really need this right now. I shall worry about it after basic functionality has been in place
	public Handler deleteEventType = (context) -> {
		
	};
 }
